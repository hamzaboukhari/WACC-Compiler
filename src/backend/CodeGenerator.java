package backend;

import identifier_objects.Type;

import java.util.HashMap;
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
import antlr.BasicLexer;
import antlr.BasicParserBaseVisitor;
import antlr.BasicParser.ProgContext;

public class CodeGenerator extends BasicParserBaseVisitor<String>{
	
	private ProgContext tree; 
	private SymbolTable<Variable> st;
	
	private Map<String, String> output;
	private List<Message> msgLabels;
	private String currLabel;
	private Label labels;

	private boolean[] freeRegs;
	private String prevReg;
	private String currReg;
	
	private int loopIndex;
	private int msgIndex;

	private boolean[] message;
	private boolean[] print;
	
	private final int NUM_OF_REGS = 13;
	
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
	
	public void initScope(ParseTree t) {
		
		st = new SymbolTable<Variable>(st);
		
		SizeCalc sizeCalc = new SizeCalc();
		
		int totalOffset = sizeCalc.getSize(t);
		
		if(totalOffset>0){
			addSUB(STACK_POINTER, "#" + totalOffset);
			//Add totalOffset to all Variable Offsets in parent scopes
			incrementOffsets(totalOffset);
		}
		
		st.add("totalOffset", new Variable(null, totalOffset));
		st.add("varOffset", new Variable(null, 0));
		
	}
	
	public void endScope() {
		
		int totalOffset = st.lookupCurrLevelOnly("totalOffset").getOffset();

		st = st.getParent();
		
		if(totalOffset>0){
			addADD(STACK_POINTER, STACK_POINTER, "#" + totalOffset);
			//Sub totalOffset to all Variable Offsets in parent scopes
			incrementOffsets(-totalOffset);
		}
		
		
	}
	
	private void incrementOffsets(int val){
		List<String> symbols = st.getAllSymbols();
		for(String s : symbols){
			st.update(s, new Variable(getType(s),getOffset(s) + val));
		}
	}
	
	private Variable getVariable(String varName){
		return st.lookUpCurrLevelAndEnclosingLevels(varName);
	}
	
	public int getOffset(String var) {
		return getVariable(var).getOffset();
	}
	
	private int getSPLocation() {
		return st.lookupCurrLevelOnly("totalOffset").getOffset() - st.lookupCurrLevelOnly("varOffset").getOffset();
	}
	
	private void incrementVarOffset(int size) {
		st.add("varOffset", new Variable(null, st.lookupCurrLevelOnly("varOffset").getOffset() + size));
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
		labels = null;
		addNewLabel("main");
	}
	
	private void addNewLabel(String label) {
		output.put(label, label + ":\n");
		
		Label newLabel = new Label(label);
		if(labels == null){
			labels = newLabel;
		} else {
			Label curr = labels;
			while(curr.getName() != currLabel){
				curr = curr.getNext();
			}
			newLabel.setNext(curr.getNext());
			curr.setNext(newLabel);
		}
	}
	
	private String getNewLoopLabel() {
		String newLoopLabel = "L" + loopIndex;
		loopIndex++;
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
		
		Label curr = labels;
		while(curr != null){
			res += output.get(curr.getName());
			curr = curr.getNext();
		}
		
		/*
		Set<String> labels = output.keySet();
		
		for (String l : labels) {
			if(!(l.equals("data"))){
				res += output.get(l);
			}
		}
		*/
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
	
	private String token(String str){
		return "'"+str+"'";
	}
	
	private String getToken(int token){
		return BasicLexer.tokenNames[token];
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
	//	incrementOffsets(4);
			if (str.substring(0, 1).equals("r")) {
				freeReg(str);
			}
			
			addLine("PUSH {" + str + "}");	}
	
	private void addPOP(String str) {
		addLine("POP {" + str + "}");
	}
	
	private void addBLEQ(String str) {
		addLine("BLEQ " + str);
	}
	
	private void addLDR(String strA,String strB) {
		addLine("LDR " + strA + ", " + strB);
	}
	
	private void addLDROffset(String str, int offset) {
		if (offset == 0) {
			addLine("LDR " + str + ", [" + STACK_POINTER + "]");
		} else {
			addLine("LDR " + str + ", [" + STACK_POINTER + ", " +  "#" + offset + "]");
		}
	}
	
	private void addSTR(String strA,String strB) {
		addLine("STR " + strA + ", " + strB);
	}
	
	private void addSTROffset(String str, int offset) {
		if (offset == 0) {
			addLine("STR " + str + ", [" + STACK_POINTER + "]");
		} else {
			addLine("STR " + str + ", [" + STACK_POINTER + ", " +  "#" + offset + "]");
		}
	}
	
	private void addSTRB(String strA, String strB) {
		addLine("STRB " + strA + ", " + strB);
	}
	
	private void addSTRBOffset(String str, int offset) {
		if (offset == 0) {
			addLine("STRB " + str + ", [" + STACK_POINTER + "]");
		} else {
			addLine("STRB " + str + ", [" + STACK_POINTER + ", " +  "#" + offset + "]");
		}
	}
	
	private void addSTRArgOffset(String str, int offset) {
		if (offset == 0) {
			addLine("STR " + str + ", [" + STACK_POINTER + "]!");
		} else {
			addLine("STR " + str + ", [" + STACK_POINTER + ", " +  "#" + offset + "]!");
		}
	}
	
	private void addSTRBArgOffset(String str, int offset) {
		if (offset == 0) {
			addLine("STRB " + str + ", [" + STACK_POINTER + "]!");
		} else {
			addLine("STRB " + str + ", [" + STACK_POINTER + ", " +  "#" + offset + "]!");
		}
	}
	
	private void addLDRSBOffset(String str, int offset) {
		if (offset == 0) {
			addLine("LDRSB " + str + ", [" + STACK_POINTER + "]");
		} else {
			addLine("LDRSB " + str + ", [" + STACK_POINTER + ", " +  "#" + offset + "]");
		}
	}
	
	private void addMOV(String strA,String strB) {
		addLine("MOV " + strA + ", " + strB);
	}
	
	private void addMOVLT(String strA,String strB) {
		addLine("MOVLT " + strA + ", " + strB);
	}
	
	private void addMOVGE(String strA,String strB) {
		addLine("MOVGE " + strA + ", " + strB);
	}
	
	private void addMOVLE(String strA,String strB) {
		addLine("MOVLE " + strA + ", " + strB);
	}
	
	private void addMOVGT(String strA,String strB) {
		addLine("MOVGT " + strA + ", " + strB);
	}
	
	private void addMOVEQ(String strA,String strB) {
		addLine("MOVEQ " + strA + ", " + strB);
	}
	
	private void addMOVNE(String strA,String strB) {
		addLine("MOVNE " + strA + ", " + strB);
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

	private void addSUB(String strA, String strB){
		addLine("SUB " + strA + ", " + strA + ", " + strB);
	}
	
	private void addRSBS(String strA, String strB){
		addLine("RSBS " + strA + ", " + strA + ", " + strB);
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
	
	private void addADDS(String strA,String strB) {
		addLine("ADDS " + strA + ", " + strA + ", " + strB);
	}
	
	private void addSUBS(String strA,String strB) {
		addLine("SUBS " + strA + ", " + strA + ", " + strB);
	}
	
	private void addEOR(String strA,String strB) {
		addLine("EOR " + strA + ", " + strA + ", " + strB);
	}
	
	@Override
	public String visitPair_liter(Pair_literContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPair_liter(ctx);
	}

	@Override
	public String visitParam(ParamContext ctx) {
		
		int offsetVal = getSPLocation();
		
		String varName = ctx.getChild(1).getText();
		String varType = ctx.getChild(0).getText();

		if (varType.equals("int")) {
			
			offsetVal -= SIZE_INT;
			
			incrementVarOffset(SIZE_INT);
				
		} else if (varType.equals("bool")) {
			
			offsetVal -= SIZE_BOOL;
			
			incrementVarOffset(SIZE_BOOL);
			
		} else if (varType.equals("char")) {
			
			offsetVal -= SIZE_CHAR;
			
			incrementVarOffset(SIZE_CHAR);
			
		} else if (varType.equals("string")) {
			
			offsetVal -= SIZE_STRING;
			
			incrementVarOffset(SIZE_STRING);
			
		}
		
		st.add(varName, new Variable(varType, offsetVal));
		
		return null;
				
	}

	@Override
	public String visitExpr(ExprContext ctx) {
		
		if(ctx.getChildCount() == 2 && ctx.getChild(0) instanceof Unary_operContext){
			
			visitExpr((ExprContext) ctx.getChild(1));
			visitUnary_oper((Unary_operContext) ctx.getChild(0));
			
			return null;
		}else if(ctx.getChildCount() == 3 && ctx.getChild(1) instanceof Binary_operContext){
			
			visitExpr((ExprContext) ctx.getChild(0));
			visitExpr((ExprContext) ctx.getChild(2));
			visitBinary_oper((Binary_operContext) ctx.getChild(1));
			
			return null;
		}
		
		return super.visitExpr(ctx);
	}
	
	@Override
	public String visitType(TypeContext ctx) {
		
		return super.visitType(ctx);

	}

	@Override
	public String visitCharacter(CharacterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCharacter(ctx);
	}

	@Override
	public String visitUnary_oper(Unary_operContext ctx) {
		
		String token = token(ctx.getText());
		
		if(token.equals(getToken(BasicLexer.NOT))){
			addEOR(currReg,"#1");
			freeReg(currReg);
		}
		if(token.equals(getToken(BasicLexer.MINUS))){
			addRSBS(currReg,"#0");
			freeReg(currReg);
		}
		if(token.equals(getToken(BasicLexer.LENGTH))){
			
		}
		
		return super.visitUnary_oper(ctx);
	}

	@Override
	public String visitProg(ProgContext ctx) {
		// TODO Auto-generated method stub
		return super.visitProg(ctx);
	}

	@Override
	public String visitIdent(IdentContext ctx) {
		
		boolean expr = false;
		ParseTree node = ctx.getParent();
		while(!(node instanceof ProgContext)){
			if(node instanceof ExprContext){
				expr = true;
			}
			node = node.getParent();
		}
		if(expr){
			if(getType(ctx.getText()).equals("char")
					|| getType(ctx.getText()).equals("bool")){
				addLDRSBOffset(getFreeReg(), getOffset(ctx.getText()));
			} else {
				addLDROffset(getFreeReg(), getOffset(ctx.getText()));
			}
		}
		
		return super.visitIdent(ctx);
	}
	
	@Override
	public String visitFunc(FuncContext ctx) {
		
		String funcL = "f_" + ctx.getChild(1).getText();
		addNewLabel(funcL);
		
		String prevLabel = currLabel;
		currLabel = funcL;
		
		addPUSH("lr");
		
		initScope(ctx);
		
		visitChildren(ctx);
		
		endScope();
		
		addPOP("pc");
		addPOP("pc");
		addLine(".ltorg");
		
		currLabel = prevLabel;
		
		freeReg(currReg);
		
		return null;
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
	public String visitStr_liter(Str_literContext ctx)  {		
		Message m = new Message(ctx.getText(), ""); 
		msgLabels.add(m); m.addLabel(msgLabels.size() - 1); 
		m.addLine(".word " + ctx.getText().length());
		m.addLine(".ascii " + ctx.getText()); 
		addLDR(getFreeReg(), "=" + "msg_" + (msgLabels.size() - 1)); 
		
		return super.visitStr_liter(ctx);
	}

	public void addPrint(ParseTree expr) {
		String prevLabel = currLabel;
		ParseTree fstChild = expr.getChild(0);
		
		if (fstChild instanceof Int_literContext) {
			addPrint_Int((Int_literContext) fstChild);
		}
		else if (fstChild instanceof Bool_literContext) {
			addPrint_Bool((Bool_literContext) fstChild);
		}
		else if (fstChild instanceof Char_literContext) {
			addPrint_Char((Char_literContext) fstChild);
		}
		else if (fstChild instanceof Str_literContext) {
			addPrint_String((Str_literContext) fstChild);
		}
		else if (fstChild instanceof Pair_literContext) {
			addPrint_Pair((Pair_literContext) fstChild);
		}
		else if (fstChild instanceof Array_literContext) {
			addPrint_Array((Array_literContext) fstChild);
		}
		else if (fstChild instanceof IdentContext) {
			addPrint_Ident((IdentContext) fstChild);
		}
		
		currLabel = prevLabel;
	}
	
	@Override
	public String visitAssign_lhs(Assign_lhsContext ctx) {
		
		if (ctx.getParent().getChild(1).getText().equals("=")) {
			
			// Assignment
			
			if (ctx.getChildCount() == 4) {
				
				// Array
				
				String arrName = ctx.getChild(0).getText();
				String arrType = getType(arrName);
				
				String valReg = currReg;
			
				//prevReg
				visitExpr((ExprContext) ctx.getChild(2));
				
				//currReg
				addMOV(getFreeReg(), "#0");
				
				addADD(currReg, currReg, "#4");
				
				if (arrType.equals("int[]")) {

					addADD(currReg, currReg, prevReg + ", LSL #2");
				 
				} else if (arrType.equals("bool[]")) {	
					
					addADD(currReg, currReg, prevReg);
					
				} else if (arrType.equals("char[]")) {
					
					addADD(currReg, currReg, prevReg);
					
				} else if (arrType.equals("string[]")) {
				
					addADD(currReg, currReg, prevReg + ", LSL #2");
				}
				
				addSTR(valReg, "[" + currReg + "]");
				
				resetRegs();
				
				return null;
				
			} else if (ctx.getChild(0) instanceof Pair_elemContext) {	
				String pair = ctx.getChild(0).getText().substring(3, 4);
				
				addPUSH(currReg);
				addLDR(getFreeReg(), "[" + STACK_POINTER + ", #" + getOffset(pair) + "]");
				
				addBL("p_check_null_pointer");
				
				if (ctx.getChild(0).getText().substring(0, 3).equals("fst")) {
					addADD(currReg, currReg, "#0");
				}
				else {
					addADD(currReg, currReg, "#4");
				}
								
				addPUSH(currReg);
				addLDR(getFreeReg(), "[" + currReg + "]");
				addBL("free");
				addMOV(currReg, "#4");
				addBL("malloc");
								
				addPOP(getFreeReg());
				addSTR(prevReg, "[" + currReg + "]");
				addMOV(currReg, prevReg);
				addPOP(prevReg);
				addSTR(prevReg, "[" + currReg + "]");
								
				freeReg(currReg);
				freeReg(prevReg);
				
				if (message[PrintType.NULL.ordinal()]) {
					addMsg("" + 50, "\"NullReferenceError: dereference a null reference\n\0\"");
					message[PrintType.NULL.ordinal()] = false;
				}
				
				if (message[PrintType.STRING.ordinal()]) {
					addMsg("" + 5, "\"%.*s\0\"");
					message[PrintType.STRING.ordinal()] = false;
				}
				
				if (print[PrintType.NULL.ordinal()]) {
					addPrint_p_null(getFreeReg());
				}
				
				if (print[PrintType.RUNTIME.ordinal()]) {
					addPrint_p_throw(getFreeReg());
				}
				
				if (print[PrintType.STRING.ordinal()]) {
					addPrint_p_print("string", getFreeReg());
				}
			}
			else {				
				if (ctx.getParent().getChild(2).getChild(1) instanceof IdentContext) {
					
					if (ctx.getChildCount() > 4) {
						
						visitArg_list((Arg_listContext) ctx.getParent().getChild(2).getChild(3));

					}
					addBL("f_" + ctx.getParent().getChild(2).getChild(1).getText());
					currReg = "r0";
				}
				
				// Base
				
				String varName = ctx.getChild(0).getText();
				String varType = getType(varName);

				int offsetVal = getOffset(varName);
				
				if (varType.equals("int")) {

					addSTROffset(currReg, offsetVal);
					
				} else if (varType.equals("bool")) {	
					
					addSTRBOffset(currReg, offsetVal);
					
				} else if (varType.equals("char")) {
					
					addSTRBOffset(currReg, offsetVal);
					
				} else if (varType.equals("string")) {
				
					addSTROffset(currReg, offsetVal);
					
				}
				
				freeReg(currReg);
				
				return null;
				
			}
				
		} else {
			
			// READ
			/*
			addPUSH("lr");
			addMOV("r1", "r0");
			addLDR(getFreeReg(), "msg_3");
			addADD(getFreeReg(), getFreeReg(), "#4");
			addBL("scanf");
			addPOP("pc");
			*/
		}

		return super.visitAssign_lhs(ctx);
	}

	@Override
	public String visitStat(StatContext ctx) {
		
		if (ctx.getChildCount() > 2 && ctx.getChild(2).getText().equals("=")) {
			// Found declaration

			visitAssign_rhs((Assign_rhsContext) ctx.getChild(3));
			
			return null;
				
		} else if (ctx.getChildCount() > 2 && ctx.getChild(1).getText().equals("=")) {
			// Found assignment
			
			visitAssign_rhs((Assign_rhsContext) ctx.getChild(2));
			visitAssign_lhs((Assign_lhsContext) ctx.getChild(0));
			
			return null;
				
		} else if (ctx.getChild(0).getText().equals("exit")) {
			
			addLDR(getFreeReg(), ctx.getChild(1).getText());
			addBL("exit");
			
		} else if (ctx.getChild(0).getText().equals("print") || ctx.getChild(0).getText().equals("println")) {
			
			if (ctx.getChild(1).getChild(0) instanceof Unary_operContext) {
				String Unary_oper = ctx.getChild(1).getText();				
				visitExpr((ExprContext) ctx.getChild(1).getChild(1));
				
				if (Unary_oper == "!") {
					addBL("p_print_bool");
				}
				else if (Unary_oper == "-" || Unary_oper == "len" || Unary_oper == "toInt") {
					addBL("p_print_int");
				}					
			}
			else if (ctx.getChild(1).getChild(0) instanceof ExprContext ) {

			}
			else if (ctx.getChild(1).getChild(0).getText().equals("(")) {
				
			}
			else {
				visitExpr((ExprContext) ctx.getChild(1));
				addPrint(ctx.getChild(1));
			}

			if (ctx.getChild(0).getText().equals("println")) {
				addPrintln();
			}

			if (ctx.getChild(0).getText().equals("println")) {
				addPrintln();
			}			
			
			return null;
			
		} else if(ctx.getChild(0).getText().equals("if")){
			
			visitExpr((ExprContext) ctx.getChild(1));
			addCMP(currReg,"#0");
			freeReg(currReg);
			
			String ifL = getNewLoopLabel();
			String fiL = getNewLoopLabel();
			
			addBEQ(ifL);
			
			String prevLabel = currLabel;
			addNewLabel(ifL);
			currLabel = ifL;
			initScope(ctx.getChild(5));
			
			visitStat((StatContext) ctx.getChild(5));
			
			endScope();
			
			String lastUsedLabel = currLabel;
			currLabel = prevLabel;
			initScope(ctx.getChild(3));
			
			visitStat((StatContext) ctx.getChild(3));
			
			endScope();
			
			addB(fiL);
			
			currLabel = lastUsedLabel;
			addNewLabel(fiL);
			currLabel = fiL;
		
			return null;
		} else if(ctx.getChild(0).getText().equals("while")){
			
			String bodyL  = getNewLoopLabel();
			String whileL = getNewLoopLabel();
			
			addB(whileL);
			
			addNewLabel(bodyL);
			currLabel = bodyL;
			addNewLabel(whileL);
			
			initScope(ctx.getChild(3));

			visitStat((StatContext) ctx.getChild(3));
			
			endScope();
			
			currLabel = whileL;
			
			visitExpr((ExprContext) ctx.getChild(1));
			
			addCMP(currReg,TRUE);
			addBEQ(bodyL);
			
			freeReg(currReg);
			
			return null;
		} else if(ctx.getChild(0).getText().equals("begin")){
			initScope(ctx);
			visitChildren(ctx);
			endScope();
			return null;
		}
		
		return super.visitStat(ctx);
	}

	@Override
	public String visitBool_liter(Bool_literContext ctx) {		
		if(ctx.getText().equals("true")){
			
			addMOV(getFreeReg(), TRUE);
			
		} else if(ctx.getText().equals("false")){
			
			addMOV(getFreeReg(), FALSE);
			
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
		
		for (int i = ctx.getChildCount() - 1 ; i >= 0 ; i -= 2) {
			
			visitExpr((ExprContext) ctx.getChild(i));
			
			GetType findType = new GetType(st);
			
			Type argType = findType.getType(ctx.getChild(i));
				
			if (argType == Type.INT) {
				
				addSTRArgOffset(currReg, - SIZE_INT);
				
			} else if (argType == Type.BOOL) {
				
				addSTRBArgOffset(currReg, - SIZE_BOOL);
				
			} else if (argType == Type.CHAR) {
				
				addSTRBArgOffset(currReg, - SIZE_CHAR);
				
			} else if (argType == Type.STRING) {
				
				addSTRArgOffset(currReg, - SIZE_STRING);
				
			}
		
		}
		
		return null;
	}

	@Override
	public String visitProgram(ProgramContext ctx) {
		
		addPUSH("lr");
		initScope(ctx);
		
		String ret = super.visitProgram(ctx);
		
		endScope();
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
		
		String token = token(ctx.getText());
		
		if(token.equals(getToken(BasicLexer.PLUS))){
			addADDS(prevReg,currReg);
			freeReg(currReg);
			currReg = prevReg;
		}
		if(token.equals(getToken(BasicLexer.MINUS))){
			addSUBS(prevReg,currReg);
			freeReg(currReg);
			currReg = prevReg;
		}
		if(token.equals(getToken(BasicLexer.MULTIPLY))){
			//
			freeReg(prevReg);
			freeReg(currReg);
		}
		if(token.equals(getToken(BasicLexer.DIVIDE))){
			//
			freeReg(prevReg);
			freeReg(currReg);
		}
		if(token.equals(getToken(BasicLexer.MOD))){
			addBL("__aeabi_idivmod");
			freeReg(prevReg);
			freeReg(currReg);
		}
		if(token.equals(getToken(BasicLexer.GREATER))){
			addCMP(prevReg,currReg);
			addMOVGT(prevReg,TRUE);
			addMOVLE(prevReg,FALSE);
			freeReg(currReg);
			currReg = prevReg;
		}
		if(token.equals(getToken(BasicLexer.GREATER_EQUAL))){
			addCMP(prevReg,currReg);
			addMOVGE(prevReg,TRUE);
			addMOVLT(prevReg,FALSE);
			freeReg(currReg);
			currReg = prevReg;
		}
		if(token.equals(getToken(BasicLexer.LESS))){
			addCMP(prevReg,currReg);
			addMOVLT(prevReg,TRUE);
			addMOVGE(prevReg,FALSE);
			freeReg(currReg);
			currReg = prevReg;
		}
		if(token.equals(getToken(BasicLexer.LESS_EQUAL))){
			addCMP(prevReg,currReg);
			addMOVLE(prevReg,TRUE);
			addMOVGT(prevReg,FALSE);
			freeReg(currReg);
			currReg = prevReg;
		}
		if(token.equals(getToken(BasicLexer.EQUAL))){
			addCMP(prevReg,currReg);
			addMOVEQ(prevReg,TRUE);
			addMOVNE(prevReg,FALSE);
			freeReg(currReg);
			currReg = prevReg;
		}
		if(token.equals(getToken(BasicLexer.NOT_EQUAL))){
			addCMP(prevReg,currReg);
			addMOVNE(prevReg,TRUE);
			addMOVEQ(prevReg,FALSE);
			freeReg(currReg);
			currReg = prevReg;
		}
		if(token.equals(getToken(BasicLexer.AND))){
			
		}
		if(token.equals(getToken(BasicLexer.OR))){
			
		}

		return null;
	}

	@Override
	public String visitChar_liter(Char_literContext ctx) {
		
		addMOV(getFreeReg(), "#" + ctx.getText());
		
		return super.visitChar_liter(ctx);
	}

	@Override
	public String visitArray_liter(Array_literContext ctx) {
		
		int numExp = (ctx.getChildCount() - 1 ) / 2;
		int offsetVal = 4;
		
		String arrName;
		String arrType;
		
		boolean dec;
		
		if (ctx.getParent().getParent().getChildCount() == 4) {
			
			// Declaration
			
			dec = true;
			
			arrType = ctx.getParent().getParent().getChild(0).getText();
			
		} else {
			
			// Assignment
			
			dec = false;
			
			arrName = ctx.getParent().getParent().getChild(0).getText();
			arrType = getType(arrName);
		
		}
		
		for (int i = 1 ; i < ctx.getChildCount() - 1 ; i += 2) {
			
			if (arrType.equals("int[]")) {
					
				visitInt_liter((Int_literContext) ctx.getChild(i).getChild(0));
				
				addSTROffset(currReg, offsetVal);
				
				offsetVal += SIZE_INT;
				
				freeReg(currReg);
					
			} else if (arrType.equals("bool[]")) {

				visitBool_liter((Bool_literContext) ctx.getChild(i).getChild(0));
				
				addSTRBOffset(currReg, offsetVal);
				
				offsetVal += SIZE_BOOL;
				
				freeReg(currReg);
				
			} else if (arrType.equals("char[]")) {

				visitChar_liter((Char_literContext) ctx.getChild(i).getChild(0));
					
				addSTRBOffset(currReg, offsetVal);
				
				offsetVal += SIZE_CHAR;
				
				freeReg(currReg);
				
			} else if (arrType.equals("string[]")) {
				
				visitStr_liter((Str_literContext) ctx.getChild(i).getChild(0));
				
				addSTROffset(currReg, offsetVal);
				
				offsetVal += SIZE_STRING;
				
				freeReg(currReg);
				
			}
			
		}
		
		addMOV(getFreeReg(), "#" + numExp);	
		addSTROffset(currReg, 0);	
		addMOV(currReg, STACK_POINTER);
		if (dec) {addSTROffset(currReg, getSPLocation());}
		
		freeReg(currReg);
			
		return null;
	}

	@Override
	public String visitAssign_rhs(Assign_rhsContext ctx) {
		
		int numExp;		
		int offsetVal = getSPLocation();
		
		if (ctx.getParent().getChild(0).getChild(0) instanceof Array_typeContext) {
			// Array
			
			String arrName = ctx.getParent().getChild(1).getText();
			String arrType = ctx.getParent().getChild(0).getText();
			numExp = (ctx.getChild(0).getChildCount() - 1 ) / 2;
			
			incrementVarOffset(SIZE_INT);
			
			if (arrType.equals("int[]")) {
				
				offsetVal -= SIZE_INT * numExp;

			} else if (arrType.equals("bool[]")) {
				
				offsetVal -= SIZE_BOOL * numExp;
	
			} else if (arrType.equals("char[]")) {
				
				offsetVal -= SIZE_CHAR * numExp;

			} else if (arrType.equals("string[]")) {
				
				offsetVal -= SIZE_STRING * numExp;
	
			} 
			
			st.add(arrName, new Variable(arrType, offsetVal));
			
		} else if (ctx.getChild(0).getText().equals("newpair")) {
			if (ctx.getParent().getChild(0) instanceof TypeContext) {
				// Declaration
				String varType = ctx.getParent().getChild(0).getText();
				String varName = ctx.getParent().getChild(1).getText();
				
				offsetVal -= 4;
				incrementVarOffset(4);
				
				st.add(varName, new Variable(varType, offsetVal));

				visitExpr((ExprContext) ctx.getChild(2));
				addPUSH(currReg);
				addNewpair_type(ctx.getChild(2).getChild(0));			
				
				visitExpr((ExprContext) ctx.getChild(4));
				addPUSH(currReg);
				addNewpair_type(ctx.getChild(4).getChild(0));
								
				addMOV(getFreeReg(), "#8");
				
				String reg1 = getFreeReg();
				String reg2 = getFreeReg();
				
				addBL("malloc");
				addPOP(reg1);
				addPOP(reg2);
				addSTR(reg2, "[" + RESULT_REG + "]");
				addSTR(reg1, "[" + RESULT_REG + ", #4]");
				addSTR(RESULT_REG, "[sp]");
				
				freeReg(RESULT_REG);
				freeReg(reg1);
				freeReg(reg2);
			}
			else {
				// Assignment
				String varName = ctx.getParent().getChild(0).getText();
				st.add(varName, new Variable(getType(varName), offsetVal));

				visitExpr((ExprContext) ctx.getChild(2));
				addPUSH(currReg);
				addNewpair_type(ctx.getChild(2).getChild(0));	
				
				visitExpr((ExprContext) ctx.getChild(4));
				addPUSH(currReg);
				addNewpair_type(ctx.getChild(4).getChild(0));

				addMOV(getFreeReg(), "#8");
				
				String reg1 = getFreeReg();
				String reg2 = getFreeReg();
				
				addBL("malloc");
				addPOP(reg1);
				addPOP(reg2);
				addSTR(reg2, "[" + RESULT_REG + "]");
				addSTR(reg1, "[" + RESULT_REG + ", #4]");
				addSTR(RESULT_REG, "[sp]");
			}
			
			return null;
		} 
		else if (ctx.getChild(0) instanceof Pair_elemContext) {
			addBL("p_check_null_pointer");
			
			if (ctx.getChild(0).getChild(0).equals("fst")) {
				addLDR(RESULT_REG, "[" + RESULT_REG + "]");
			}
			else {
				addLDR(RESULT_REG, "[" + RESULT_REG + ", #4]");
			}
			
			addLDR(RESULT_REG, "[" + RESULT_REG + "]");
			addSTR(RESULT_REG, "[" + STACK_POINTER + "]");

			if (message[PrintType.NULL.ordinal()]) {
				addMsg("" + 50, "\"NullReferenceError: dereference a null reference\n\0\"");
				message[PrintType.NULL.ordinal()] = false;
			}
			
			if (message[PrintType.STRING.ordinal()]) {
				addMsg("" + 5, "\"%.*s\0\"");
				message[PrintType.STRING.ordinal()] = false;
			}
			
			if (print[PrintType.NULL.ordinal()]) {
				addPrint_p_null(getFreeReg());
			}
			
			if (print[PrintType.RUNTIME.ordinal()]) {
				addPrint_p_throw(getFreeReg());
			}
			
			if (print[PrintType.STRING.ordinal()]) {
				addPrint_p_print("string", getFreeReg());
			}
		}		
		else if (ctx.getParent().getChild(0) instanceof TypeContext){
			// Base
			
			String varName = ctx.getParent().getChild(1).getText();
			String varType = ctx.getParent().getChild(0).getText();
			
			if (ctx.getChild(0) instanceof ExprContext) {
				
				visitExpr((ExprContext) ctx.getChild(0));
				
			} else if (ctx.getChild(1) instanceof IdentContext) {
				
				if (ctx.getChildCount() > 4) {
					
					visitArg_list((Arg_listContext) ctx.getChild(3));

				}
				
				addBL("f_" + ctx.getChild(1).getText());
				
			}
			
			if (varType.equals("int")) {
				
				incrementVarOffset(SIZE_INT);
				
				addSTROffset(currReg, getSPLocation());
				
			} else if (varType.equals("bool")) {
				
				incrementVarOffset(SIZE_BOOL);
				
				addSTROffset(currReg, getSPLocation());
				
			} else if (varType.equals("char")) {
				
				incrementVarOffset(SIZE_CHAR);
				
				addSTROffset(currReg, getSPLocation());
				
			} else if (varType.equals("string")) {
				
				incrementVarOffset(SIZE_STRING);
				
				addSTROffset(currReg, getSPLocation());
				
			}
			
			st.add(varName, new Variable(varType, getSPLocation()));
			
			freeReg(currReg);
			
			return null;
			
		}
		
		return super.visitAssign_rhs(ctx);
	}
	
	private void addNewpair_type(ParseTree ctx) {
		if (ctx instanceof Int_literContext) {
			addMOV(getFreeReg(), "#4");
		}
		else if (ctx instanceof Bool_literContext) {
			addMOV(getFreeReg(), "#1");
		}
		else if (ctx instanceof Char_literContext) {
			addMOV(getFreeReg(), "#1");
		}
		else if (ctx instanceof Str_literContext) {
			addMOV(getFreeReg(), "#4");
		}
		else if (ctx instanceof IdentContext) {
			addMOV(getFreeReg(), "#4");
		}
			
		addBL("malloc");
		addPOP(getFreeReg());
		addSTR(currReg, "[" + prevReg + "]");
		addPUSH(prevReg);
		
		freeReg(currReg);
	}
	
	private void addPrint_Int(Int_literContext ctx) {
		if (message[PrintType.INT.ordinal()]) {
			addMsg("3", "\"%d\\0\"");
			message[PrintType.INT.ordinal()] = false;
		}	
		
		addBL("p_print_int");
		
		if (print[PrintType.INT.ordinal()]) {
			addPrint_p_print("int", RESULT_REG);
		}
	}
	
	private void addPrint_Bool(Bool_literContext ctx) {	
		if (message[PrintType.BOOL.ordinal()]) {
			addMsg("5", "\"true\\0\"");
			addMsg("6", "\"false\\0\"");
			message[PrintType.BOOL.ordinal()] = false;
		}	
		
		addBL("p_print_bool");
		
		if (print[PrintType.BOOL.ordinal()]) {
			addPrint_p_print("bool", RESULT_REG);
		}
	}
	
	private void addPrint_Char(Char_literContext ctx) {
		addBL("putchar");
	}
	
	private void addPrint_String(Str_literContext ctx) {
		if (message[PrintType.STRING.ordinal()]) {
			addMsg("5", "\"%.*s\0\"");
			message[PrintType.STRING.ordinal()] = false;
		}
		
		addBL("p_print_string");
		
		if (print[PrintType.STRING.ordinal()]) {
			addPrint_p_print("string", RESULT_REG);
		}
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
		
		addBL("p_print_reference");
	
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
		String type = getType(ctx.getText());
				
		if (type.equals("int")) {
			if (message[PrintType.INT.ordinal()]) {
				addMsg("3", "\"%d\\0\"");
				message[PrintType.INT.ordinal()] = false;
			}	
			
			addBL("p_print_int");
			
			if (print[PrintType.INT.ordinal()]) {
				addPrint_p_print("int", RESULT_REG);
			}			
		}
		else if (type.equals("bool")) {
			if (message[PrintType.BOOL.ordinal()]) {
				addMsg("5", "\"true\\0\"");
				addMsg("6", "\"false\\0\"");
				message[PrintType.BOOL.ordinal()] = false;
			}	
			
			addBL("p_print_bool");
	
			if (print[PrintType.BOOL.ordinal()]) {
				addPrint_p_print("bool", RESULT_REG);
			}
		}
		else if (type.equals("char")) {
		    addBL("putchar");
		}
		else if (type.equals("string")) {			
			addBL("p_print_string");
						
			if (message[PrintType.STRING.ordinal()]) {
				addMsg("5", "\"%.*s\0\"");
				message[PrintType.STRING.ordinal()] = false;
			}
			
			if (print[PrintType.STRING.ordinal()]) {
				addPrint_p_print("string", RESULT_REG);
			}
		}
	}
	
	private void addMsg(String word, String ascii) {
		Message m = new Message(ascii, "");
		
		msgLabels.add(m);
		m.addLabel(msgLabels.size() - 1);
		
		m.addLine(".word " + word);
		m.addLine(".ascii  " + ascii);
	}
	
	private void addPrint_p_print(String func, String reg1) {
		String prevLabel = currLabel;

		addNewLabel("p_print_" + func);
		currLabel = "p_print_" + func;
		addPUSH("lr");
		
		if (func.equals("int")) {
			String reg2 = getFreeReg();
			
			addMOV(reg2, reg1);
			addLDR(reg1, "msg_" + (msgLabels.size() - 1));
			addADD(reg1, reg1, "#4");
			
			freeReg(reg2);
			print[PrintType.INT.ordinal()] = false;
		}
		else if (func.equals("bool")) {
			addLDRNE(reg1, "=msg_" + (msgLabels.size() - 2));
			addLDREQ(reg1, "=msg_" + (msgLabels.size() - 1));
			addADD(reg1, reg1, "#4");
			print[PrintType.BOOL.ordinal()] = false;
		}
		else if (func.equals("string")) {
			String reg2 = getFreeReg();
			String reg3 = getFreeReg();
			
			addLDR(reg2, "[" + reg1 + "]");
			addADD(reg3, reg1, "#4");
			addLDR(reg1, "=msg_" + (msgLabels.size() - 2));
			addADD(reg1, reg1, "#4");
					
			freeReg(reg2);
			freeReg(reg3);
			print[PrintType.STRING.ordinal()] = false;
		}
		
		addBL("printf");
		addMOV(reg1, "#0");
		addBL("fflush");
		addPOP("pc");
		
		freeReg(reg1);
		currLabel = prevLabel;
	}
	
	private void addPrint_p_null(String reg1) {
		int reg1_n = Integer.parseInt(reg1.substring(1));			

		String prevLabel = currLabel;
		addNewLabel("p_print_check_null_pointer");
		currLabel = "p_print_check_null_pointer";
		
		addPUSH("lr");
		addCMP(reg1, "#0");
		addLDREQ(reg1, "=msg_" + getMsgIndex("\"NullReferenceError: dereference a null reference\n\0\""));
		addBLEQ("p_throw_runtime_error");
		addPOP("pc");
		
		currLabel = prevLabel;
		print[PrintType.NULL.ordinal()] = false;
		freeRegs[reg1_n] = true;
	}
	
	private void addPrint_p_throw(String reg1) {
		int reg1_n = Integer.parseInt(reg1.substring(1));			

		String prevLabel = currLabel;
		addNewLabel("p_print_throw_runtime_error");
		currLabel = "p_print_throw_runtime_error";

		
		addBL("p_print_string");
		addMOV(reg1, "#-1");
		addBL("exit");
		
		print[PrintType.RUNTIME.ordinal()] = false;
		freeRegs[reg1_n] = true;
		
		currLabel = prevLabel;
	}
	
	public void addPrintln() {
		String prevLabel = currLabel;
		
		if (message[PrintType.NEWLINE.ordinal()]) {			
			addMsg("1", "\"\\0\"");
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
	public String visitInt_liter(Int_literContext ctx) {
		addLDR(getFreeReg(), "=" + ctx.getText());	
		return super.visitInt_liter(ctx);
	}
}

