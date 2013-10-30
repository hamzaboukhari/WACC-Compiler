// Generated from ./BasicParser.g4 by ANTLR 4.1
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BasicParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BasicParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BasicParser#pair_liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair_liter(@NotNull BasicParser.Pair_literContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(@NotNull BasicParser.ParamContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#expr2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr2(@NotNull BasicParser.Expr2Context ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(@NotNull BasicParser.ExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull BasicParser.TypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#character}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacter(@NotNull BasicParser.CharacterContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#unary_oper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_oper(@NotNull BasicParser.Unary_operContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(@NotNull BasicParser.ProgContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(@NotNull BasicParser.IdentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(@NotNull BasicParser.FuncContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#array_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_type(@NotNull BasicParser.Array_typeContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#pair_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair_elem(@NotNull BasicParser.Pair_elemContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#escaped_char}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscaped_char(@NotNull BasicParser.Escaped_charContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#base_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBase_type(@NotNull BasicParser.Base_typeContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#pair_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair_type(@NotNull BasicParser.Pair_typeContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#int_sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_sign(@NotNull BasicParser.Int_signContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#str_liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStr_liter(@NotNull BasicParser.Str_literContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#assign_lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_lhs(@NotNull BasicParser.Assign_lhsContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(@NotNull BasicParser.StatContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#bool_liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_liter(@NotNull BasicParser.Bool_literContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#param_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_list(@NotNull BasicParser.Param_listContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#arg_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg_list(@NotNull BasicParser.Arg_listContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#array_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_elem(@NotNull BasicParser.Array_elemContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull BasicParser.ProgramContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#pair_elem_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair_elem_type(@NotNull BasicParser.Pair_elem_typeContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#binary_oper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary_oper(@NotNull BasicParser.Binary_operContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#char_liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar_liter(@NotNull BasicParser.Char_literContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#array_liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_liter(@NotNull BasicParser.Array_literContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_rhs(@NotNull BasicParser.Assign_rhsContext ctx);

	/**
	 * Visit a parse tree produced by {@link BasicParser#int_liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_liter(@NotNull BasicParser.Int_literContext ctx);
}