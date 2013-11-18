package backend;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.tree.ParseTree;

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
	
	private Map<String, String> output;
	private Map<String, String> variables;
	private String currLabel;

	private boolean[] freeRegs;
	private String lastUsedReg;
	
	private int loopIndex;
	private int msgIndex;
	private int stringIndex;
	
	private int totalSize;

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
		output = new HashMap<String,String>();
		variables = new HashMap<String, String>();
		currLabel = "main";
		setOutput();
		setRegs();

		loopIndex = 0;
		msgIndex = 0;
		stringIndex = 0;
		
		message = new boolean[10];
		print = new boolean[10];
		
		for (int i = 0; i < message.length; i++) {
			message[i] = true;
			print[i] = true;
		}
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
		addDirective("text");
		addDirective("global main");
		addLabel("main");
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
		int r = ((int) reg.charAt(1)) - 48;
		freeRegs[r] = true;
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
	
	private void addSTRB(String strA,String strB) {
		addLine("STRB " + strA + ", " + strB);
	}
	
	private void addMOV(String strA,String strB) {
		lastUsedReg = strA;
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
		// TODO Auto-generated method stub
		return super.visitExpr(ctx);
	}

	@Override
	public String visitType(TypeContext ctx) {
		totalSize = getSize(ctx.getText());
		String size = "#" + totalSize;
		addSUB(STACK_POINTER, STACK_POINTER, size);
		variables.put(ctx.getParent().getChild(1).getText(), ctx.getText());
		if (ctx.getText().equals("int")) {
			addLDR(RESULT_REG, "=" + ctx.getParent().getChild(3).getText());
			addSTR(RESULT_REG, "[" + STACK_POINTER + "]");
		} else if (ctx.getText().equals("bool")) {
			if (ctx.getParent().getChild(3).getText().equals("true")) {
				addMOV(RESULT_REG, TRUE);
			} else {
				addMOV(RESULT_REG, FALSE);
			}
			addSTRB(RESULT_REG, "[" + STACK_POINTER + "]");
		} else if (ctx.getText().equals("char")) {
			addMOV(RESULT_REG, "#" + ctx.getParent().getChild(3).getText());
			addSTRB(RESULT_REG, "[" + STACK_POINTER + "]");
		} else if (ctx.getText().equals("string")) {
			String s = ctx.getParent().getChild(3).getText();
			addLDR(RESULT_REG, "=" + "msg_" + msgIndex);
			currLabel = "data";
			addLabel("msg_" + msgIndex++);
			addLine(".word " + (s.length() - 2));
			addLine(".ascii  " + s);
			currLabel = "main";
			addSTR(RESULT_REG, "[" + STACK_POINTER + "]");
		}
		addADD(STACK_POINTER, STACK_POINTER, size);
		return null;
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
		// TODO Auto-generated method stub
		return super.visitFunc(ctx);
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
		return null;
	}

	public void addPrint(ParseTree expr) {
		String prevLabel = currLabel;
		currLabel = "data";
		
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
			// Add message label
			addLabel("msg_" + msgIndex++);
			addLine(".word 3");
			addLine(".ascii  \"%d\\0\"");
			message[PrintType.INT.ordinal()] = false;
		}
				
		String reg1 = getFreeReg();
		int reg1_n = Integer.parseInt(reg1.substring(1));
		
		currLabel = "main";
		addLDR(reg1, "=" + ctx.getText());
		addBL("p_print_int");
		
		if (print[PrintType.INT.ordinal()]) {
			String reg2 = getFreeReg();
			int reg2_n = Integer.parseInt(reg2.substring(1));

			// Create print function
			addNewLabel("p_print_int");
			currLabel = "p_print_int";
			addLabel("p_print_int");
			addPUSH("lr");
			addMOV(reg2, reg1);
			addLDR(reg1, "msg_" + (msgIndex - 1));
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
			addLabel("msg_" + msgIndex++);
			addLine(".word 5");
			addLine(".ascii  \"true\\0\"");
			addLabel("msg_" + msgIndex++);
			addLine(".word 6");
			addLine(".ascii  \"false\\0\"");
			message[PrintType.BOOLEAN.ordinal()] = false;
		}
		
		String reg1 = getFreeReg();
		int reg1_n = Integer.parseInt(reg1.substring(1));

		currLabel = "main";
		
		if (ctx.getText().equals("true")) {
			addMOV(reg1, "#1");
		} else {
			addMOV(reg1, "#0");
		}
		
		addBL("p_print_bool");
		
		if (print[PrintType.BOOLEAN.ordinal()]) {
			addCMP(reg1, "#0");
			addLDRNE(reg1, "=msg_" + (msgIndex - 2));
			addLDREQ(reg1, "=msg_" + (msgIndex - 1));
			addADD(reg1, reg1, "#4");
			addBL("printf");
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
			stringIndex = msgIndex;
			addLabel("msg_" + msgIndex++);
			addLine(".word 5");
			addLine(".ascii  \"%.*s\0\"");
			message[PrintType.STRING.ordinal()] = false;
		}
		
		// Add msg label
		String s = ctx.getText();
		addLabel("msg_" + msgIndex++);
		addLine(".word " + (s.length() - 2));
		addLine(".ascii  " + s);
		
		// Get register
		String reg1 = getFreeReg();
		int reg1_n = Integer.parseInt(reg1.substring(1));

		// Add main instructions
		currLabel = "main";
		addLDR(reg1, "=msg_" + (msgIndex - 1));
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
			addLDR(reg1, "=msg_" + stringIndex);
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
		
	}
	
	private void addPrint_Array(Array_literContext ctx) {
		
	}
	
	private void addPrint_Ident(IdentContext ctx) {
		
		
	}
	
	public void addPrintln() {
		String prevLabel = currLabel;
		currLabel = "data";
		
		// Add msg label
		addLabel("msg_" + msgIndex++);
		addLine(".word 1");
		addLine(".ascii  \"\\0\"");
		
		addNewLabel("p_print_ln");
		currLabel = "p_print_ln";
		
		// Get register
		String reg1 = getFreeReg();
		int reg1_n = Integer.parseInt(reg1.substring(1));
		
		addPUSH("lr");
		addLDR(reg1, "=msg_" + (msgIndex - 1));
		addADD(reg1, reg1, "#4");
		addBL("puts");
		addMOV(reg1, "#0");
		addBL("fflush");
		addPOP("pc");
		
		freeRegs[reg1_n] = true;		
		currLabel = prevLabel;
	}
	
	@Override
	public String visitAssign_lhs(Assign_lhsContext ctx) {
		if (ctx.getParent().getChild(1).getText().equals("=")) {
			String var = ctx.getChild(0).getText();
			String type = variables.get(var);
			totalSize = getSize(type);
			String size = "#" + totalSize;
			addSUB(STACK_POINTER, STACK_POINTER, size);
			if (type.equals("int")) {
				addLDR(RESULT_REG, "=" + ctx.getParent().getChild(2).getText());
				addSTR(RESULT_REG, "[" + STACK_POINTER + "]");
			} else if (type.equals("bool")) {
				if (ctx.getParent().getChild(3).getText().equals("true")) {
					addMOV(RESULT_REG, TRUE);
				} else {
					addMOV(RESULT_REG, FALSE);
				}
				addSTRB(RESULT_REG, "[" + STACK_POINTER + "]");
			} else if (type.equals("char")) {
				addMOV(RESULT_REG, "#" + ctx.getParent().getChild(2).getText());
				addSTRB(RESULT_REG, "[" + STACK_POINTER + "]");
			} else if (type.equals("string")) {
				String s = ctx.getParent().getChild(2).getText();
				addLDR(RESULT_REG, "=" + "msg_" + msgIndex);
				currLabel = "data";
				addLabel("msg_" + msgIndex++);
				addLine(".word " + (s.length() - 2));
				addLine(".ascii  " + s);
				currLabel = "main";
				addSTR(RESULT_REG, "[" + STACK_POINTER + "]");
			}
			addADD(STACK_POINTER, STACK_POINTER, size);
		}
		//return null;
		/*
		if (ctx.getChild(0) instanceof BasicParser.IdentContext) {
			visitIdent((IdentContext) ctx.getChild(0));
		} else if (ctx.getChild(0) instanceof BasicParser.ExprContext) {
			visitExpr((ExprContext) ctx.getChild(0));
		} else {
			visitPair_elem_type((Pair_elem_typeContext) ctx.getChild(0));
		}
		*/
		return super.visitAssign_lhs(ctx);
	}

	@Override
	public String visitStat(StatContext ctx) {
		if (ctx.getChild(0).getText().equals("exit")) {
			addLDR(RESULT_REG,ctx.getChild(1).getText());
			addBL("exit");
		} else if (ctx.getChild(0).getText().equals("print") || ctx.getChild(0).getText().equals("println")) {
			addPrint(ctx.getChild(1).getChild(0));
			
			if (ctx.getChild(0).getText().equals("println")) {
				addPrintln();
			}
		} else if(ctx.getChild(0).getText().equals("if")){
			
			visitExpr((ExprContext) ctx.getChild(1));
			addCMP(lastUsedReg,"#0");
			freeReg(lastUsedReg);
			
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
			
			addCMP(lastUsedReg,"#0");
			addBEQ(bodyL);

			freeReg(lastUsedReg);
			
			return null;
		}
		/* 
		
		else if (ctx.getChild(0) instanceof BasicParser.StatContext) {
		for (int i = 0 ; i < ctx.getChildCount() ; i += 2) {
			if (ctx.getChild(i).getChild(0) instanceof BasicParser.TypeContext) {
				totalSize += getSize(ctx.getChild(i).getChild(0).getText());
			}
		}
		addSUB(STACK_POINTER, STACK_POINTER, "#" + totalSize);
		super.visitStat(ctx);
		addADD(STACK_POINTER, STACK_POINTER, "#" + totalSize);
		
	}
	*/
		return super.visitStat(ctx);
	}

	@Override
	public String visitBool_liter(Bool_literContext ctx) {
		if(ctx.getText().equals("true")){
			addMOV(getFreeReg(),TRUE);
		} else if(ctx.getText().equals("false")){
			addMOV(getFreeReg(),FALSE);
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
		addPUSH("lr");
		String ret = super.visitProgram(ctx);
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return super.visitInt_liter(ctx);
	}
	
	
	
}
