package backend;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.tree.ParseTree;

import frontend.SymbolTable;

import antlr.BasicParser.Arg_listContext;
import antlr.BasicParser.Array_literContext;
import antlr.BasicParser.Array_typeContext;
import antlr.BasicParser.Assign_lhsContext;
import antlr.BasicParser.Assign_rhsContext;
import antlr.BasicParser.Base_typeContext;
import antlr.BasicParser.Binary_operContext;
import antlr.BasicParser.Bool_literContext;
import antlr.BasicParser.Char_literContext;
import antlr.BasicParser.CharacterContext;
import antlr.BasicParser.ExprContext;
import antlr.BasicParser.FuncContext;
import antlr.BasicParser.IdentContext;
import antlr.BasicParser.Int_literContext;
import antlr.BasicParser.Int_signContext;
import antlr.BasicParser.Pair_elemContext;
import antlr.BasicParser.Pair_elem_typeContext;
import antlr.BasicParser.Pair_literContext;
import antlr.BasicParser.Pair_typeContext;
import antlr.BasicParser.ParamContext;
import antlr.BasicParser.Param_listContext;
import antlr.BasicParser.ProgramContext;
import antlr.BasicParser.StatContext;
import antlr.BasicParser.Str_literContext;
import antlr.BasicParser.TypeContext;
import antlr.BasicParser.Unary_operContext;
import antlr.BasicParserBaseVisitor;
import antlr.BasicParser.ProgContext;

public class CodeGenerator extends BasicParserBaseVisitor<String>{
	
	private ProgContext tree;
	private SymbolTable<Variable> st;
	
	private Map<String, String> output;
	private List<Message> msgLabels;
	private String currLabel;

	private boolean[] freeRegs;
	private String prevReg;
	private String currReg;
	
	private int loopIndex;
	private int msgIndex;
	
	private int totalOffset;

	private boolean[] message;
	private boolean[] print;
	
	private final int NUM_OF_REGS = 12;
	
	private final String RESULT_REG = "r0";
	private final String PARAM_REG = "r1";
	private final String STACK_POINTER = "sp";
	
	private final String FALSE = "#0";
	private final String TRUE = "#1";
	
	private final int SIZE_INT = 4;
	private final int SIZE_STRING = 4;
	private final int SIZE_BOOL = 1;
	private final int SIZE_CHAR = 1;
	
	public CodeGenerator(ProgContext t) {
		tree = t;
		st = new SymbolTable<Variable>(null);
		output = new HashMap<String,String>();
		msgLabels = new LinkedList<Message>();
		currLabel = "main";
		setOutput();
		setRegs();

		loopIndex = 0;
		msgIndex = 0;
		
		message = new boolean[10];
		print = new boolean[10];
		
		for (int i = 0; i < message.length; i++) {
			message[i] = true;
			print[i] = true;
		}
	}
	
	private Variable getVariable(String varName){
		return st.lookUpCurrLevelAndEnclosingLevels(varName);
	}
	
	public int getOffset(String var) {
		return getVariable(var).getOffset();
	}
	
	public String getType(String var) {
		return getVariable(var).getType();
	}
	
	private void setRegs() {
		freeRegs = new boolean[NUM_OF_REGS];
		for(int i=0; i<freeRegs.length; i++){
			freeRegs[i] = true;
		}
	}
	
	private void setOutput(){
		output.put("data", ".data\n");
		output.put("main", "");
	}
	
	private void addNewLabel(String label) {
		output.put(label, label+":\n");
	}
	
	private String addNewLoopLabel() {
		String newLoopLabel = "L" + loopIndex;
		loopIndex++;
		addNewLabel(newLoopLabel);
		return newLoopLabel;
	}
	
	public void start() {
		visitProg(tree);
	}
	
	private String compileOutput(){
		String res = "";
		
		if(output.get("data") != ".data\n"){
			res += output.get("data") + "\n";
		}
		
		for (int i = 0; i < msgLabels.size(); i++) {
			res += msgLabels.get(i).getVal();
		}
		
		res += ".text\n";
		res += ".global main\n";
		res += "main:\n";
		res += output.get("main");
		
		Set<String> labels = output.keySet();
		
		for (String l : labels) {
			if(!(l.equals("data") || l.equals("main"))){
				res += output.get(l);
			}
		}
		
		return res;
	}
	
	public void printOutput() {
		System.out.println(compileOutput());
	}
	
	private void resetRegs() {
		setRegs();
	}
	
	private void freeReg(String reg) {
		if(reg.length() == 2){
			reg = reg.substring(1);
		} else {
			reg = reg.substring(1,3);
		}
		freeRegs[Integer.parseInt(reg)] = true;
	}
	
	private boolean findMsgLabel(String label) {
		for (int i = 0; i < msgLabels.size(); i++) {
			if (msgLabels.get(i).getKey().equals(label)) {
				return true;
			}
		}
		
		return false;
	}
	
	public int getMsgIndex(String label) {
		if (findMsgLabel(label)) {
			for (int i = 0; i < msgLabels.size(); i++) {
				if (msgLabels.get(i).getKey().equals(label)) {
					return i;
				}
			}
		}
		
		return -1;
	}
	
	private String getFreeReg() {
		int freeReg = 0;
		
		for (int i = 0; i < freeRegs.length; i++) {
			if (freeRegs[i] == true) {
				freeReg = i;
				freeRegs[i] = false;
				break;
			}
		}
		
		prevReg = currReg;
		currReg = "r" + (freeReg);
		return "r" + (freeReg);
	}
	
	private int getSize(String str) {
		if (str.equals("int")) {
			return SIZE_INT;
		} else if (str.equals("string")) {
			return SIZE_STRING;
		} else if (str.equals("bool")) {
			return SIZE_BOOL;
		} else if (str.equals("char")) {
			return SIZE_CHAR;
		} else {
			return 0;
		}
	}
	
	private void addToFront(String str){
		output.put(currLabel, str + "\n" + output.get(currLabel));
	}
	private void addLineToFront(String str) {
		addToFront("\t" + str);
	}
	private void addPUSHToFront(String str) {
		addLineToFront("PUSH {" + str + "}");
	}

	private void addSUBToFront(String strA, String strB, String strC){
		addLineToFront("SUB " + strA + ", " + strB + ", " + strC);
	}
	
	private void add(String str){
		output.put(currLabel, output.get(currLabel) + str + "\n");
	}
	
	private void addDirective(String str) {
		add("." + str);
	}
	
	private void addLabel(String str) {
		add(str + ":");
	}
	
	private void addLine(String str) {
		add("\t" + str);
	}
	
	private void addPUSH(String str) {
		addLine("PUSH {" + str + "}");
	}
	
	private void addPOP(String str) {
		addLine("POP {" + str + "}");
	}
	
	private void addLDR(String strA,String strB) {
		addLine("LDR " + strA + ", " + strB);
	}
	
	private void addSTR(String strA,String strB) {
		addLine("STR " + strA + ", " + strB);
	}
	
	private void addSTROffset(String str,int offset) {
		if (offset == 0) {
			addLine("STR " + str + ", [" + STACK_POINTER + "]");
		} else {
			addLine("STR " + str + ", [" + STACK_POINTER + ", " +  "#" + offset + "]");
		}
	}
	
	private void addSTRB(String strA,String strB) {
		addLine("STRB " + strA + ", " + strB);
	}
	
	private void addSTRBOffset(String str,int offset) {
		if (offset == 0) {
			addLine("STRB " + str + ", [" + STACK_POINTER + "]");
		} else {
			addLine("STRB " + str + ", [" + STACK_POINTER + ", " +  "#" + offset + "]");
		}
	}
	
	private void addMOV(String strA,String strB) {
		addLine("MOV " + strA + ", " + strB);
	}
	
	private void addCMP(String strA,String strB) {
		addLine("CMP " + strA + ", " + strB);
	}
	
	private void addBEQ(String str) {
		addLine("BEQ " + str);
	}
	
	private void addB(String str) {
		addLine("B " + str);
	}
	
	private void addBL(String str) {
		addLine("BL " + str);
	}

	private void addSUB(String strA, String strB, String strC){
		addLine("SUB " + strA + ", " + strB + ", " + strC);
	}
	
	private void addADD(String strA, String strB, String strC){
		addLine("ADD " + strA + ", " + strB + ", " + strC );
	}
	
	private void addLDRNE(String strA, String strB) {
		addLine("LDRNE " + strA + ", " + strB);
	}
	
	private void addLDREQ(String strA, String strB) {
		addLine("LDREQ " + strA + ", " + strB);
	}
	
	@Override
	public String visitPair_liter(Pair_literContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPair_liter(ctx);
	}

	@Override
	public String visitParam(ParamContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParam(ctx);
	}

	@Override
	public String visitExpr(ExprContext ctx) {
		
		if(ctx.getChildCount() > 2 && ctx.getChild(1) instanceof Binary_operContext){
			System.out.println("TODO");
			
			visitExpr((ExprContext) ctx.getChild(0));
			visitExpr((ExprContext) ctx.getChild(2));
			
			return null;
		}
		
		return super.visitExpr(ctx);
	}

	@Override
	public String visitType(TypeContext ctx) {
	
		String varName = ctx.getParent().getChild(1).getText();
		String varType = ctx.getText();
		
		int offsetVal = totalOffset;
		
		st.add(varName, new Variable(varType, offsetVal));
		
		if (varType.equals("int")) {
			
			totalOffset += SIZE_INT;
			
			addSTROffset(RESULT_REG, offsetVal);
				
		} else if (varType.equals("bool")) {
			
			totalOffset += SIZE_BOOL;
			
			addSTRBOffset(RESULT_REG, offsetVal);
			
		} else if (varType.equals("char")) {
			
			totalOffset += SIZE_CHAR;
				
			addSTRBOffset(RESULT_REG, offsetVal);
			
		} else if (varType.equals("string")) {
			
			totalOffset += SIZE_STRING;
			
			addSTROffset(RESULT_REG, offsetVal);
		}
		
		return super.visitType(ctx);

	}

	@Override
	public String visitCharacter(CharacterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCharacter(ctx);
	}

	@Override
	public String visitUnary_oper(Unary_operContext ctx) {
		// TODO Auto-generated method stub
		return super.visitUnary_oper(ctx);
	}

	@Override
	public String visitProg(ProgContext ctx) {
		// TODO Auto-generated method stub
		return super.visitProg(ctx);
	}

	@Override
	public String visitIdent(IdentContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIdent(ctx);
	}

	@Override
	public String visitFunc(FuncContext ctx) {
		
		String funcL = ctx.getChild(1).getText();
		addNewLabel(funcL);
		
		String prevLabel = currLabel;
		currLabel = funcL;
		
		addPUSH("lr");
		String ret = super.visitFunc(ctx);
		addPOP("pc");
		addPOP("pc");
		addLine(".ltorg");
		
		currLabel = prevLabel;
		return ret;
	}

	@Override
	public String visitArray_type(Array_typeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitArray_type(ctx);
	}

	@Override
	public String visitPair_elem(Pair_elemContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPair_elem(ctx);
	}

	@Override
	public String visitBase_type(Base_typeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBase_type(ctx);
	}

	@Override
	public String visitPair_type(Pair_typeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPair_type(ctx);
	}

	@Override
	public String visitInt_sign(Int_signContext ctx) {
		// TODO Auto-generated method stub
		return super.visitInt_sign(ctx);
	}

	@Override
	public String visitStr_liter(Str_literContext ctx) {
		
		Message m = new Message(ctx.getText(), ""); 
		msgLabels.add(m); m.addLabel(msgLabels.size() - 1); 
		m.addLine(".word " + ctx.getText().length());
		m.addLine(".ascii " + ctx.getText()); 
		addLDR(RESULT_REG, "=" + "msg_" + (msgLabels.size() - 1)); 
		
		return super.visitStr_liter(ctx);
	}

	public void addPrint(ParseTree expr) {
		String prevLabel = currLabel;
		
		if (expr instanceof Int_literContext) {
			addPrint_Int((Int_literContext) expr);
		}
		else if (expr instanceof Bool_literContext) {
			addPrint_Bool((Bool_literContext) expr);
		}
		else if (expr instanceof Char_literContext) {
			addPrint_Char((Char_literContext) expr);
		}
		else if (expr instanceof Str_literContext) {
			addPrint_String((Str_literContext) expr);
		}
		else if (expr instanceof Pair_literContext) {
			addPrint_Pair((Pair_literContext) expr);
		}
		else if (expr instanceof Array_literContext) {
			addPrint_Array((Array_literContext) expr);
		}
		else if (expr instanceof IdentContext) {
			addPrint_Ident((IdentContext) expr);
		}
		
		currLabel = prevLabel;
	}
	
	private void addPrint_Int(Int_literContext ctx) {
		if (message[PrintType.INT.ordinal()]) {
			Message m = new Message("%d", "");
			msgLabels.add(m);
			m.addLabel(msgLabels.size() - 1);
			m.addLine(".word 3");
			m.addLine(".ascii  \"%d\\0\"");
			message[PrintType.INT.ordinal()] = false;
		}
				
		String reg1 = getFreeReg();
		int reg1_n = Integer.parseInt(reg1.substring(1));
		
		addLDR(reg1, "=" + ctx.getText());
		addBL("p_print_int");
		
		if (print[PrintType.INT.ordinal()]) {
			String reg2 = getFreeReg();
			int reg2_n = Integer.parseInt(reg2.substring(1));

			// Create print function
			addNewLabel("p_print_int");
			currLabel = "p_print_int";
			addPUSH("lr");
			addMOV(reg2, reg1);
			addLDR(reg1, "msg_" + (msgLabels.size() - 1));
			addADD(reg1, reg1, "#4");
			addBL("printf");
			addMOV(reg1, "#0");
			addBL("fflush");
			addPOP("pc");
			
			// Free registers
			freeRegs[reg2_n] = true;
			
			print[PrintType.INT.ordinal()] = false;
		}
		
		freeRegs[reg1_n] = true;
	}
	
	private void addPrint_Bool(Bool_literContext ctx) {
		if (message[PrintType.BOOLEAN.ordinal()]) {
			// Add boolean message labels
			Message m1 = new Message("true", "");
			msgLabels.add(m1);
			m1.addLabel(msgLabels.size() - 1);
			m1.addLine(".word 5");
			m1.addLine(".ascii  \"true\\0\"");
			
			Message m2 = new Message("false", "");
			msgLabels.add(m2);
			m2.addLabel(msgLabels.size() - 1);
			m2.addLine(".word 6");
			m2.addLine(".ascii  \"false\\0\"");
			
			message[PrintType.BOOLEAN.ordinal()] = false;
		}
		
		String reg1 = getFreeReg();
		int reg1_n = Integer.parseInt(reg1.substring(1));

		if (ctx.getText().equals("true")) {
			addMOV(reg1, "#1");
			addBL("p_print_bool");
		} else {
			addMOV(reg1, "#0");
			addBL("p_print_bool");
		}
		
		addMOV(reg1, "#0");	

		if (print[PrintType.BOOLEAN.ordinal()]) {
			addNewLabel("p_print_bool");
			currLabel = "p_print_bool";
			addPUSH("lr");
			addCMP(reg1, "#0");
			addLDRNE(reg1, "=msg_" + (msgLabels.size() - 2));
			addLDREQ(reg1, "=msg_" + (msgLabels.size() - 1));
			addADD(reg1, reg1, "#4");
			addBL("printf");
			addMOV(reg1, "#0");
			addBL("fflush");
			addPOP("pc");
			
			print[PrintType.BOOLEAN.ordinal()] = false;
		}
		
		freeRegs[reg1_n] = true;
	}
	
	private void addPrint_Char(Char_literContext ctx) {
		
		String reg1 = getFreeReg();
		int reg1_n = Integer.parseInt(reg1.substring(1));
		currLabel = "main";
		
		addMOV(reg1, "#" + ctx.getText());
		addBL("putchar");
		addMOV(reg1, "#0");
		
		freeRegs[reg1_n] = true;		
	}
	
	private void addPrint_String(Str_literContext ctx) {
		if (message[PrintType.STRING.ordinal()]) {
			Message m = new Message("s", "");
			msgLabels.add(m);
			m.addLabel(msgLabels.size() - 1);
			
			m.addLine(".word 5");
			m.addLine(".ascii  \"%.*s\0\"");
					
			message[PrintType.STRING.ordinal()] = false;
		}
		
		// Add msg label
		String s = ctx.getText();

		Message m = new Message(s, "");
		msgLabels.add(m);
		m.addLabel(msgLabels.size() - 1);
		m.addLine(".word " + (s.length() - 2));
		m.addLine(".ascii  " + s);
		
		// Get register
		String reg1 = getFreeReg();
		int reg1_n = Integer.parseInt(reg1.substring(1));

		// Add main instructions
		addLDR(reg1, "=msg_" + (msgLabels.size() - 1));
		addBL("p_print_string");
		
		// Add print function
		if (print[PrintType.STRING.ordinal()]) {
			addNewLabel("p_print_string");
			currLabel = "p_print_string";
			
			String reg2 = getFreeReg();
			int reg2_n = Integer.parseInt(reg2.substring(1));
			String reg3 = getFreeReg();
			int reg3_n = Integer.parseInt(reg2.substring(1));
			
			addPUSH("lr");
			addLDR(reg2, "[" + reg1 + "]");
			addADD(reg3, reg1, "#4");
			addLDR(reg1, "=msg_" + (msgLabels.size() - 2));
			addADD(reg1, reg1, "#4");
			addBL("printf");
			addMOV(reg1, "#0");
			addBL("fflush");
			addPOP("pc");
			
			// Free registers
			freeRegs[reg2_n] = true;		
			freeRegs[reg3_n] = true;		
			
			print[PrintType.STRING.ordinal()] = false;
		}
		
		freeRegs[reg1_n] = true;		
	}
	
	private void addPrint_Pair(Pair_literContext ctx) {
		if (message[PrintType.PAIR.ordinal()]) {
			Message m = new Message("p", "");
			msgLabels.add(m);
			m.addLabel(msgLabels.size() - 1);
			
			m.addLine(".word 3");
			m.addLine(".ascii \"%p\\0\"");
					
			message[PrintType.PAIR.ordinal()] = false;
		}
		
		String reg1 = getFreeReg();
		int reg1_n = Integer.parseInt(reg1.substring(1));
		
		addMOV(reg1, "#0");
		addBL("p_print_reference");
		addMOV(reg1, "#0");

		// Create p_print_reference function		
		if (print[PrintType.REFERENCE.ordinal()]) {
			addNewLabel("p_print_string");
			currLabel = "p_print_string";
			
			String reg2 = getFreeReg();
			int reg2_n = Integer.parseInt(reg2.substring(1));
			
			addPUSH("lr");
			addMOV(reg2, reg1);
			addLDR(reg1, "=msg_" + (msgLabels.size() - 1));
			addADD(reg1, reg1, "#4");
			addBL("printf");
			addMOV(reg1, "#0");
			addBL("fflush");
			addPOP("pc");
			
			freeRegs[reg2_n] = true;
			print[PrintType.REFERENCE.ordinal()] = false;			
		}
		
		freeRegs[reg1_n] = true;		
	}
	
	private void addPrint_Array(Array_literContext ctx) {
		
	}
	
	private void addPrint_Ident(IdentContext ctx) {
		String ident = ctx.getText();
		String type = getType(ident);
		int offset = getOffset(ident);
		
		if (type.equals("string")) {
			if (offset == 0) {
				addLDR("r0", "[sp]");
				addBL("p_print_string");
			}
		}
	}
	
	public void addPrintln() {
		String prevLabel = currLabel;
		
		if (message[PrintType.NEWLINE.ordinal()]) {
			// Add msg label
			Message m = new Message("0", "");
			msgLabels.add(m);
			m.addLabel(msgLabels.size() - 1);
			m.addLine(".word 1");
			m.addLine(".ascii  \"\\0\"");
			message[PrintType.NEWLINE.ordinal()] = false;
		}
		
		addBL("p_print_ln");
		
		if (print[PrintType.NEWLINE.ordinal()]) {
			addNewLabel("p_print_ln");
			currLabel = "p_print_ln";
			
			// Get register
			String reg1 = getFreeReg();
			int reg1_n = Integer.parseInt(reg1.substring(1));
			
			addPUSH("lr");
			addLDR(reg1, "=msg_" + (msgLabels.size() - 1));
			addADD(reg1, reg1, "#4");
			addBL("puts");
			addMOV(reg1, "#0");
			addBL("fflush");
			addPOP("pc");
			
			print[PrintType.NEWLINE.ordinal()] = false;
			freeRegs[reg1_n] = true;
		}		
		
		currLabel = prevLabel;
	}
	
	@Override
	public String visitAssign_lhs(Assign_lhsContext ctx) {
		if (ctx.getParent().getChild(1).getText().equals("=")) {
			// Assignment

			String varName = ctx.getChild(0).getText();
			String varType = getType(varName);
			
			int offsetVal = getOffset(varName);
			
			if (varType.equals("int")) {
				
				addSTROffset(RESULT_REG, offsetVal);
				
			} else if (varType.equals("bool")) {
				
				addSTRBOffset(RESULT_REG, offsetVal);
				
			} else if (varType.equals("char")) {
			
				addSTRBOffset(RESULT_REG, offsetVal);
				
			} else if (varType.equals("string")) {
				
				addSTROffset(RESULT_REG, offsetVal);
				
			}
			
		}

		return super.visitAssign_lhs(ctx);
	}

	@Override
	public String visitStat(StatContext ctx) {
		
		if (ctx.getChildCount() > 2 && ctx.getChild(2).getText().equals("=")) {
			// Found declaration
			
			visitAssign_rhs((Assign_rhsContext) ctx.getChild(3));
			visitType((TypeContext) ctx.getChild(0));
			
			return null;
				
		} else if (ctx.getChildCount() > 2 && ctx.getChild(1).getText().equals("=")) {
			// Found assignment
			
			visitAssign_rhs((Assign_rhsContext) ctx.getChild(2));
			visitAssign_lhs((Assign_lhsContext) ctx.getChild(0));
			
			return null;
				
		} else if (ctx.getChild(0).getText().equals("exit")) {
			
			addLDR(RESULT_REG,ctx.getChild(1).getText());
			addBL("exit");
			
		} else if (ctx.getChild(0).getText().equals("print") || ctx.getChild(0).getText().equals("println")) {
			
			addPrint(ctx.getChild(1).getChild(0));
			
			if (ctx.getChild(0).getText().equals("println")) {
				addPrintln();
			}
			
		} else if(ctx.getChild(0).getText().equals("if")){
			
			visitExpr((ExprContext) ctx.getChild(1));
			addCMP(currReg,"#0");
			freeReg(currReg);
			
			String ifL = addNewLoopLabel();
			addBEQ(ifL);
			
			String prevLabel = currLabel;
			currLabel = ifL;
			
			visitStat((StatContext) ctx.getChild(3));
			
			currLabel = prevLabel;
			visitStat((StatContext) ctx.getChild(5));
			
			String fiL = addNewLoopLabel();
			addB(fiL);
			
			currLabel = fiL;
			
			return null;
		} else if(ctx.getChild(0).getText().equals("while")){
			
			String bodyL  = addNewLoopLabel();
			String whileL = addNewLoopLabel();
			
			addB(whileL);
			
			currLabel = bodyL;

			visitStat((StatContext) ctx.getChild(3));
			
			currLabel = whileL;
			
			visitExpr((ExprContext) ctx.getChild(1));
			
			addCMP(currReg,"#0");
			addBEQ(bodyL);

			//freeReg(currReg);
			
			return null;
		}
		
		return super.visitStat(ctx);
	}

	@Override
	public String visitBool_liter(Bool_literContext ctx) {
		
		if(ctx.getText().equals("true")){
			
			addMOV(RESULT_REG, TRUE);
			
		} else if(ctx.getText().equals("false")){
			
			addMOV(RESULT_REG, FALSE);
			
		}
		return super.visitBool_liter(ctx);
	}

	@Override
	public String visitParam_list(Param_listContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParam_list(ctx);
	}

	@Override
	public String visitArg_list(Arg_listContext ctx) {
		// TODO Auto-generated method stub
		return super.visitArg_list(ctx);
	}

	@Override
	public String visitProgram(ProgramContext ctx) {
		String ret = super.visitProgram(ctx);
		
		String prevLabel = currLabel;
		currLabel = "main";
		if(totalOffset>0){addSUBToFront(STACK_POINTER, STACK_POINTER, "#" + totalOffset);}
		addPUSHToFront("lr");
		
		currLabel = prevLabel;
		if(totalOffset>0){addADD(STACK_POINTER, STACK_POINTER, "#" + totalOffset);}
		addMOV(RESULT_REG, "#0");
		addPOP("pc");
		return ret;
	}

	@Override
	public String visitPair_elem_type(Pair_elem_typeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPair_elem_type(ctx);
	}

	@Override
	public String visitBinary_oper(Binary_operContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBinary_oper(ctx);
	}

	@Override
	public String visitChar_liter(Char_literContext ctx) {
		
		addMOV(RESULT_REG, "#" + ctx.getText());
		
		return super.visitChar_liter(ctx);
	}

	@Override
	public String visitArray_liter(Array_literContext ctx) {
		// TODO Auto-generated method stub
		return super.visitArray_liter(ctx);
	}

	@Override
	public String visitAssign_rhs(Assign_rhsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssign_rhs(ctx);
	}

	@Override
	public String visitInt_liter(Int_literContext ctx) {
		
		addLDR(RESULT_REG, "=" + ctx.getText());
		
		return super.visitInt_liter(ctx);
	}
	
	
	
}

