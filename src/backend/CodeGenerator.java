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
	private Map<String,String> output;
	private String currLabel;
	private int usedRegs;
	
	public CodeGenerator(ProgContext t){
		tree = t;
		output = new HashMap<String,String>();
		currLabel = "main";
		addNewLabel(currLabel);
		usedRegs = 0;
	}
	
	private void addNewLabel(String label){
		output.put(label, "");
	}
	
	public void start(){
		visitProg(tree);
	}
	
	public void printOutput(){
		String res = "";
				
		if(output.get("data")!=null){
			res += ".data\n" + output.get("data");
		}
		
		res += output.get("main");
		
		System.out.println(res);
	}
	
	private void resetRegs(){
		usedRegs = 0;
	}
	
	private String getReg(){
		usedRegs++;
		return "r"+(usedRegs-1);
	}
	
	private void addDirective(String str){
		String toAdd = "." + str + "\n";
		output.put(currLabel, output.get(currLabel) + toAdd);
	}
	
	private void addLabel(String str){
		String toAdd = str + ":\n";
		output.put(currLabel, output.get(currLabel) + toAdd);
	}
	
	private void addLine(String str){
		String toAdd = "\t" + str + "\n";
		output.put(currLabel, output.get(currLabel) + toAdd);
	}
	
	private void addPUSH(String str){
		String toAdd = "\tPUSH {" + str + "}\n";
		output.put(currLabel, output.get(currLabel) + toAdd);
	}
	
	private void addPOP(String str){
		String toAdd = "\tPOP {" + str + "}\n";
		output.put(currLabel, output.get(currLabel) + toAdd);
	}
	
	private void addLDR(String strA,String strB){
		String toAdd = "\tLDR " + strA + ", " + strB + "\n";
		output.put(currLabel, output.get(currLabel) + toAdd);
	}
	
	private void addSTR(String strA,String strB){
		String toAdd = "\tSTR " + strA + ", " + strB + "\n";
		output.put(currLabel, output.get(currLabel) + toAdd);
	}
	
	private void addMOV(String strA,String strB){
		String toAdd = "\tMOV " + strA + ", " + strB + "\n";
		output.put(currLabel, output.get(currLabel) + toAdd);
	}
	
	private void addBL(String str){
		String toAdd = "\tBL " + str + "\n";
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return super.visitStr_liter(ctx);
	}

	@Override
	public String visitAssign_lhs(Assign_lhsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssign_lhs(ctx);
	}

	@Override
	public String visitStat(StatContext ctx) {
		if (ctx.getChild(0).getText().equals("exit")) {
			addLDR("r0",ctx.getChild(1).getText());
			addBL("exit");
		}
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
