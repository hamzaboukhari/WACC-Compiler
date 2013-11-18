package backend;

import java.util.HashMap;
import java.util.Map;

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
	private String currLabel;
	private String prevLabel;
	private int stringLabelIndex;
	private boolean[] freeRegs;
	private int totalSize;
	private Map<String, String> variables;
	
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
		setRegs();
		addNewLabel("main");
		addNewLabel("data");
		stringLabelIndex = 0;
	}
	
	private void setRegs() {
		freeRegs = new boolean[NUM_OF_REGS];
		for(int i=0; i<freeRegs.length; i++){
			freeRegs[i] = true;
		}
	}
	
	private void addNewLabel(String label) {
		output.put(label, "");
	}
	
	public void start() {
		visitProg(tree);
	}
	
	public void printOutput() {
		String res = "";
				
		if(output.get("data") != ""){
			res += ".data\n" + output.get("data");
		}
		
		res += output.get("main");
		
		System.out.println(res);
	}
	
	private void resetRegs() {
		setRegs();
	}
	
	private String getFreeReg() {
		int freeReg = 0;
		for(int i = 0; i < freeRegs.length; i++) {
			if(freeRegs[i] == true){
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
	
	private void addDirective(String str) {
		String toAdd = "." + str + "\n";
		output.put(currLabel, output.get(currLabel) + toAdd);
	}
	
	private void addLabel(String str) {
		String toAdd = str + ":\n";
		output.put(currLabel, output.get(currLabel) + toAdd);
	}
	
	private void addLine(String str) {
		String toAdd = "\t" + str + "\n";
		output.put(currLabel, output.get(currLabel) + toAdd);
	}
	
	private void addPUSH(String str) {
		String toAdd = "\tPUSH {" + str + "}\n";
		output.put(currLabel, output.get(currLabel) + toAdd);
	}
	
	private void addPOP(String str) {
		String toAdd = "\tPOP {" + str + "}\n";
		output.put(currLabel, output.get(currLabel) + toAdd);
	}
	
	private void addLDR(String strA,String strB) {
		String toAdd = "\tLDR " + strA + ", " + strB + "\n";
		output.put(currLabel, output.get(currLabel) + toAdd);
	}
	
	private void addSTR(String strA,String strB) {
		String toAdd = "\tSTR " + strA + ", " + strB + "\n";
		output.put(currLabel, output.get(currLabel) + toAdd);
	}
	
	private void addSTRB(String strA,String strB) {
		String toAdd = "\tSTRB " + strA + ", " + strB + "\n";
		output.put(currLabel, output.get(currLabel) + toAdd);
	}
	
	private void addMOV(String strA,String strB) {
		String toAdd = "\tMOV " + strA + ", " + strB + "\n";
		output.put(currLabel, output.get(currLabel) + toAdd);
	}
	
	private void addBL(String str) {
		String toAdd = "\tBL " + str + "\n";
		output.put(currLabel, output.get(currLabel) + toAdd);
	}

	private void addSUB(String strA, String strB, String strC){
		String toAdd = "\tSUB " + strA + ", " + strB + ", " + strC + "\n";
		output.put(currLabel, output.get(currLabel) + toAdd);
	}
	
	private void addADD(String strA, String strB, String strC){
		String toAdd = "\tADD " + strA + ", " + strB + ", " + strC + "\n";
		output.put(currLabel, output.get(currLabel) + toAdd);
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
			addLDR(RESULT_REG, "=" + "msg_" + stringLabelIndex);
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

	public void addPrint(String s) {
		prevLabel = currLabel;
		currLabel = "data";
		addLabel("msg_" + stringLabelIndex++);
		addLine(".word " + (s.length() - 1));
		addLine(".ascii  " + s);
		currLabel = prevLabel;
	}
	
	@Override
	public String visitAssign_lhs(Assign_lhsContext ctx) {
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
			addLDR(RESULT_REG, "=" + "msg_" + stringLabelIndex);
			addSTR(RESULT_REG, "[" + STACK_POINTER + "]");
		}
		addADD(STACK_POINTER, STACK_POINTER, size);
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
		}
		else if (ctx.getChild(0).getText().equals("print") || ctx.getChild(0).getText().equals("println")) {
			addPrint(ctx.getChild(1).getText());
		}	
	/* else if (ctx.getChild(0) instanceof BasicParser.StatContext) {
	for (int i = 0 ; i < ctx.getChildCount() ; i += 2) {
		if (ctx.getChild(i).getChild(0) instanceof BasicParser.TypeContext) {
			totalSize += getSize(ctx.getChild(i).getChild(0).getText());
		}
	}
	addSUB(STACK_POINTER, STACK_POINTER, "#" + totalSize);
	super.visitStat(ctx);
	addADD(STACK_POINTER, STACK_POINTER, "#" + totalSize);
	
}*/
		return super.visitStat(ctx);
	}

	@Override
	public String visitBool_liter(Bool_literContext ctx) {
		// TODO Auto-generated method stub
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
		addDirective("text");
		addDirective("global main");
		addLabel("main");
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
