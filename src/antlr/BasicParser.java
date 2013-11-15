// Generated from ./BasicParser.g4 by ANTLR 4.1

package antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BasicParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHILE=13, MOD=35, DOUBLE_QUOTE=49, CHAR=26, DO=14, EVERYTHING=63, EQUALS=1, 
		NOT=29, AND=44, ESCAPED_CHAR=52, ORD=31, TO_INT=32, LENGTH=30, IF=9, OPEN_BRACKET=53, 
		FREE=4, SINGLE_QUOTE=50, CLOSE_PARENTHESES=58, GREATER=38, THEN=10, MULTIPLY=33, 
		COMMA=55, NOT_EQUAL=43, IS=18, DONE=15, PRINTLN=8, BEGIN=16, EQUAL=42, 
		RETURN=5, LESS=40, ENDIF=12, IDENT=60, PLUS=36, PAIR=28, COMMENT=62, NEWPAIR=20, 
		DIVIDE=34, INTEGER=59, EXIT=6, SECOND=23, NULL=56, ELSE=11, BOOL=25, WHITESPACE=61, 
		UNDERSCORE=46, INT=24, SEMICOLON=19, MINUS=37, TRUE=47, PRINT=7, SKIP=2, 
		READ=3, OR=45, OPEN_PARENTHESES=57, LESS_EQUAL=41, CALL=21, END=17, FALSE=48, 
		GREATER_EQUAL=39, FIRST=22, STRING=27, CLOSE_BRACKET=54, BACKSLASH=51;
	public static final String[] tokenNames = {
		"<INVALID>", "'='", "'skip'", "'read'", "'free'", "'return'", "'exit'", 
		"'print'", "'println'", "'if'", "'then'", "'else'", "'fi'", "'while'", 
		"'do'", "'done'", "'begin'", "'end'", "'is'", "';'", "'newpair'", "'call'", 
		"'fst'", "'snd'", "'int'", "'bool'", "'char'", "'string'", "'pair'", "'!'", 
		"'len'", "'ord'", "'toInt'", "'*'", "'/'", "'%'", "'+'", "'-'", "'>'", 
		"'>='", "'<'", "'<='", "'=='", "'!='", "'&&'", "'||'", "'_'", "'true'", 
		"'false'", "'\"'", "'''", "'\\'", "ESCAPED_CHAR", "'['", "']'", "','", 
		"'null'", "'('", "')'", "INTEGER", "IDENT", "WHITESPACE", "COMMENT", "EVERYTHING"
	};
	public static final int
		RULE_program = 0, RULE_func = 1, RULE_param_list = 2, RULE_param = 3, 
		RULE_stat = 4, RULE_assign_lhs = 5, RULE_assign_rhs = 6, RULE_arg_list = 7, 
		RULE_pair_elem = 8, RULE_type = 9, RULE_base_type = 10, RULE_array_type = 11, 
		RULE_pair_type = 12, RULE_pair_elem_type = 13, RULE_expr = 14, RULE_unary_oper = 15, 
		RULE_binary_oper = 16, RULE_ident = 17, RULE_int_liter = 18, RULE_int_sign = 19, 
		RULE_bool_liter = 20, RULE_char_liter = 21, RULE_str_liter = 22, RULE_character = 23, 
		RULE_array_liter = 24, RULE_pair_liter = 25, RULE_prog = 26;
	public static final String[] ruleNames = {
		"program", "func", "param_list", "param", "stat", "assign_lhs", "assign_rhs", 
		"arg_list", "pair_elem", "type", "base_type", "array_type", "pair_type", 
		"pair_elem_type", "expr", "unary_oper", "binary_oper", "ident", "int_liter", 
		"int_sign", "bool_liter", "char_liter", "str_liter", "character", "array_liter", 
		"pair_liter", "prog"
	};

	@Override
	public String getGrammarFileName() { return "BasicParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public BasicParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(BasicParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(54); match(BEGIN);
			setState(58);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(55); func();
					}
					} 
				}
				setState(60);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(61); stat(0);
			setState(62); match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncContext extends ParserRuleContext {
		public Param_listContext param_list() {
			return getRuleContext(Param_listContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode IS() { return getToken(BasicParser.IS, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64); type();
			setState(65); ident();
			setState(66); match(OPEN_PARENTHESES);
			setState(68);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << PAIR))) != 0)) {
				{
				setState(67); param_list();
				}
			}

			setState(70); match(CLOSE_PARENTHESES);
			setState(71); match(IS);
			setState(72); stat(0);
			setState(73); match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_listContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicParser.COMMA); }
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(BasicParser.COMMA, i);
		}
		public Param_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitParam_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_listContext param_list() throws RecognitionException {
		Param_listContext _localctx = new Param_listContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75); param();
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(76); match(COMMA);
				setState(77); param();
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83); type();
			setState(84); ident();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public int _p;
		public TerminalNode SKIP() { return getToken(BasicParser.SKIP, 0); }
		public TerminalNode WHILE() { return getToken(BasicParser.WHILE, 0); }
		public TerminalNode IF() { return getToken(BasicParser.IF, 0); }
		public Assign_lhsContext assign_lhs() {
			return getRuleContext(Assign_lhsContext.class,0);
		}
		public TerminalNode DO() { return getToken(BasicParser.DO, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(BasicParser.RETURN, 0); }
		public TerminalNode FREE() { return getToken(BasicParser.FREE, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public TerminalNode EXIT() { return getToken(BasicParser.EXIT, 0); }
		public TerminalNode PRINTLN() { return getToken(BasicParser.PRINTLN, 0); }
		public TerminalNode PRINT() { return getToken(BasicParser.PRINT, 0); }
		public TerminalNode THEN() { return getToken(BasicParser.THEN, 0); }
		public TerminalNode SEMICOLON() { return getToken(BasicParser.SEMICOLON, 0); }
		public TerminalNode EQUALS() { return getToken(BasicParser.EQUALS, 0); }
		public TerminalNode DONE() { return getToken(BasicParser.DONE, 0); }
		public Assign_rhsContext assign_rhs() {
			return getRuleContext(Assign_rhsContext.class,0);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(BasicParser.ELSE, 0); }
		public TerminalNode READ() { return getToken(BasicParser.READ, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ENDIF() { return getToken(BasicParser.ENDIF, 0); }
		public TerminalNode BEGIN() { return getToken(BasicParser.BEGIN, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public StatContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatContext _localctx = new StatContext(_ctx, _parentState, _p);
		StatContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, RULE_stat);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			switch (_input.LA(1)) {
			case SKIP:
				{
				setState(87); match(SKIP);
				}
				break;
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
			case PAIR:
				{
				setState(88); type();
				setState(89); ident();
				setState(90); match(EQUALS);
				setState(91); assign_rhs();
				}
				break;
			case FIRST:
			case SECOND:
			case NOT:
			case LENGTH:
			case ORD:
			case TO_INT:
			case PLUS:
			case MINUS:
			case TRUE:
			case FALSE:
			case DOUBLE_QUOTE:
			case SINGLE_QUOTE:
			case NULL:
			case OPEN_PARENTHESES:
			case INTEGER:
			case IDENT:
				{
				setState(93); assign_lhs();
				setState(94); match(EQUALS);
				setState(95); assign_rhs();
				}
				break;
			case READ:
				{
				setState(97); match(READ);
				setState(98); assign_lhs();
				}
				break;
			case FREE:
				{
				setState(99); match(FREE);
				setState(100); expr(0);
				}
				break;
			case RETURN:
				{
				setState(101); match(RETURN);
				setState(102); expr(0);
				}
				break;
			case EXIT:
				{
				setState(103); match(EXIT);
				setState(104); expr(0);
				}
				break;
			case PRINT:
				{
				setState(105); match(PRINT);
				setState(106); expr(0);
				}
				break;
			case PRINTLN:
				{
				setState(107); match(PRINTLN);
				setState(108); expr(0);
				}
				break;
			case IF:
				{
				setState(109); match(IF);
				setState(110); expr(0);
				setState(111); match(THEN);
				setState(112); stat(0);
				setState(113); match(ELSE);
				setState(114); stat(0);
				setState(115); match(ENDIF);
				}
				break;
			case WHILE:
				{
				setState(117); match(WHILE);
				setState(118); expr(0);
				setState(119); match(DO);
				setState(120); stat(0);
				setState(121); match(DONE);
				}
				break;
			case BEGIN:
				{
				setState(123); match(BEGIN);
				setState(124); stat(0);
				setState(125); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(134);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(129);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(130); match(SEMICOLON);
					setState(131); stat(2);
					}
					} 
				}
				setState(136);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Assign_lhsContext extends ParserRuleContext {
		public Pair_elemContext pair_elem() {
			return getRuleContext(Pair_elemContext.class,0);
		}
		public TerminalNode CLOSE_BRACKET() { return getToken(BasicParser.CLOSE_BRACKET, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPEN_BRACKET() { return getToken(BasicParser.OPEN_BRACKET, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Assign_lhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_lhs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssign_lhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_lhsContext assign_lhs() throws RecognitionException {
		Assign_lhsContext _localctx = new Assign_lhsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assign_lhs);
		try {
			setState(144);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137); ident();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138); expr(0);
				setState(139); match(OPEN_BRACKET);
				setState(140); expr(0);
				setState(141); match(CLOSE_BRACKET);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(143); pair_elem();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_rhsContext extends ParserRuleContext {
		public TerminalNode CALL() { return getToken(BasicParser.CALL, 0); }
		public Pair_elemContext pair_elem() {
			return getRuleContext(Pair_elemContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode COMMA() { return getToken(BasicParser.COMMA, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NEWPAIR() { return getToken(BasicParser.NEWPAIR, 0); }
		public Array_literContext array_liter() {
			return getRuleContext(Array_literContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Assign_rhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_rhs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssign_rhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_rhsContext assign_rhs() throws RecognitionException {
		Assign_rhsContext _localctx = new Assign_rhsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assign_rhs);
		int _la;
		try {
			setState(164);
			switch (_input.LA(1)) {
			case NOT:
			case LENGTH:
			case ORD:
			case TO_INT:
			case PLUS:
			case MINUS:
			case TRUE:
			case FALSE:
			case DOUBLE_QUOTE:
			case SINGLE_QUOTE:
			case NULL:
			case OPEN_PARENTHESES:
			case INTEGER:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(146); expr(0);
				}
				break;
			case OPEN_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(147); array_liter();
				}
				break;
			case NEWPAIR:
				enterOuterAlt(_localctx, 3);
				{
				setState(148); match(NEWPAIR);
				setState(149); match(OPEN_PARENTHESES);
				setState(150); expr(0);
				setState(151); match(COMMA);
				setState(152); expr(0);
				setState(153); match(CLOSE_PARENTHESES);
				}
				break;
			case FIRST:
			case SECOND:
				enterOuterAlt(_localctx, 4);
				{
				setState(155); pair_elem();
				}
				break;
			case CALL:
				enterOuterAlt(_localctx, 5);
				{
				setState(156); match(CALL);
				setState(157); ident();
				setState(158); match(OPEN_PARENTHESES);
				setState(160);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << LENGTH) | (1L << ORD) | (1L << TO_INT) | (1L << PLUS) | (1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << DOUBLE_QUOTE) | (1L << SINGLE_QUOTE) | (1L << NULL) | (1L << OPEN_PARENTHESES) | (1L << INTEGER) | (1L << IDENT))) != 0)) {
					{
					setState(159); arg_list();
					}
				}

				setState(162); match(CLOSE_PARENTHESES);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Arg_listContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicParser.COMMA); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(BasicParser.COMMA, i);
		}
		public Arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArg_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arg_listContext arg_list() throws RecognitionException {
		Arg_listContext _localctx = new Arg_listContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arg_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166); expr(0);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(167); match(COMMA);
				setState(168); expr(0);
				}
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pair_elemContext extends ParserRuleContext {
		public TerminalNode FIRST() { return getToken(BasicParser.FIRST, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SECOND() { return getToken(BasicParser.SECOND, 0); }
		public Pair_elemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_elem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPair_elem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_elemContext pair_elem() throws RecognitionException {
		Pair_elemContext _localctx = new Pair_elemContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pair_elem);
		try {
			setState(178);
			switch (_input.LA(1)) {
			case FIRST:
				enterOuterAlt(_localctx, 1);
				{
				setState(174); match(FIRST);
				setState(175); expr(0);
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(176); match(SECOND);
				setState(177); expr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public Pair_typeContext pair_type() {
			return getRuleContext(Pair_typeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		try {
			setState(183);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(180); base_type();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(181); array_type();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(182); pair_type();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Base_typeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(BasicParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(BasicParser.INT, 0); }
		public TerminalNode STRING() { return getToken(BasicParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(BasicParser.CHAR, 0); }
		public Base_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBase_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Base_typeContext base_type() throws RecognitionException {
		Base_typeContext _localctx = new Base_typeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_base_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_typeContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACKET(int i) {
			return getToken(BasicParser.OPEN_BRACKET, i);
		}
		public List<TerminalNode> CLOSE_BRACKET() { return getTokens(BasicParser.CLOSE_BRACKET); }
		public List<TerminalNode> OPEN_BRACKET() { return getTokens(BasicParser.OPEN_BRACKET); }
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public Pair_typeContext pair_type() {
			return getRuleContext(Pair_typeContext.class,0);
		}
		public TerminalNode CLOSE_BRACKET(int i) {
			return getToken(BasicParser.CLOSE_BRACKET, i);
		}
		public Array_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArray_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_typeContext array_type() throws RecognitionException {
		Array_typeContext _localctx = new Array_typeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_array_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
				{
				setState(187); base_type();
				}
				break;
			case PAIR:
				{
				setState(188); pair_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(193); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(191); match(OPEN_BRACKET);
				setState(192); match(CLOSE_BRACKET);
				}
				}
				setState(195); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OPEN_BRACKET );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pair_typeContext extends ParserRuleContext {
		public List<Pair_elem_typeContext> pair_elem_type() {
			return getRuleContexts(Pair_elem_typeContext.class);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode COMMA() { return getToken(BasicParser.COMMA, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public TerminalNode PAIR() { return getToken(BasicParser.PAIR, 0); }
		public Pair_elem_typeContext pair_elem_type(int i) {
			return getRuleContext(Pair_elem_typeContext.class,i);
		}
		public Pair_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPair_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_typeContext pair_type() throws RecognitionException {
		Pair_typeContext _localctx = new Pair_typeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pair_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197); match(PAIR);
			setState(198); match(OPEN_PARENTHESES);
			setState(199); pair_elem_type();
			setState(200); match(COMMA);
			setState(201); pair_elem_type();
			setState(202); match(CLOSE_PARENTHESES);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pair_elem_typeContext extends ParserRuleContext {
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public TerminalNode PAIR() { return getToken(BasicParser.PAIR, 0); }
		public Pair_elem_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_elem_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPair_elem_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_elem_typeContext pair_elem_type() throws RecognitionException {
		Pair_elem_typeContext _localctx = new Pair_elem_typeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pair_elem_type);
		try {
			setState(207);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(204); base_type();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(205); array_type();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(206); match(PAIR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public int _p;
		public TerminalNode CLOSE_BRACKET() { return getToken(BasicParser.CLOSE_BRACKET, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public TerminalNode OPEN_BRACKET() { return getToken(BasicParser.OPEN_BRACKET, 0); }
		public Unary_operContext unary_oper() {
			return getRuleContext(Unary_operContext.class,0);
		}
		public Binary_operContext binary_oper() {
			return getRuleContext(Binary_operContext.class,0);
		}
		public Char_literContext char_liter() {
			return getRuleContext(Char_literContext.class,0);
		}
		public Str_literContext str_liter() {
			return getRuleContext(Str_literContext.class,0);
		}
		public Int_literContext int_liter() {
			return getRuleContext(Int_literContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public Pair_literContext pair_liter() {
			return getRuleContext(Pair_literContext.class,0);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public Bool_literContext bool_liter() {
			return getRuleContext(Bool_literContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState, _p);
		ExprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, RULE_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(210); unary_oper();
				setState(211); expr(3);
				}
				break;

			case 2:
				{
				setState(213); int_liter();
				}
				break;

			case 3:
				{
				setState(214); bool_liter();
				}
				break;

			case 4:
				{
				setState(215); char_liter();
				}
				break;

			case 5:
				{
				setState(216); str_liter();
				}
				break;

			case 6:
				{
				setState(217); pair_liter();
				}
				break;

			case 7:
				{
				setState(218); ident();
				}
				break;

			case 8:
				{
				setState(219); match(OPEN_PARENTHESES);
				setState(220); expr(0);
				setState(221); match(CLOSE_PARENTHESES);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(236);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(234);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(225);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(226); match(OPEN_BRACKET);
						setState(227); expr(0);
						setState(228); match(CLOSE_BRACKET);
						}
						break;

					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(230);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(231); binary_oper();
						setState(232); expr(0);
						}
						break;
					}
					} 
				}
				setState(238);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Unary_operContext extends ParserRuleContext {
		public TerminalNode TO_INT() { return getToken(BasicParser.TO_INT, 0); }
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(BasicParser.NOT, 0); }
		public TerminalNode ORD() { return getToken(BasicParser.ORD, 0); }
		public TerminalNode LENGTH() { return getToken(BasicParser.LENGTH, 0); }
		public Unary_operContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_oper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitUnary_oper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_operContext unary_oper() throws RecognitionException {
		Unary_operContext _localctx = new Unary_operContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_unary_oper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << LENGTH) | (1L << ORD) | (1L << TO_INT) | (1L << MINUS))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_operContext extends ParserRuleContext {
		public TerminalNode GREATER_EQUAL() { return getToken(BasicParser.GREATER_EQUAL, 0); }
		public TerminalNode AND() { return getToken(BasicParser.AND, 0); }
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public TerminalNode OR() { return getToken(BasicParser.OR, 0); }
		public TerminalNode MULTIPLY() { return getToken(BasicParser.MULTIPLY, 0); }
		public TerminalNode EQUAL() { return getToken(BasicParser.EQUAL, 0); }
		public TerminalNode DIVIDE() { return getToken(BasicParser.DIVIDE, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(BasicParser.NOT_EQUAL, 0); }
		public TerminalNode LESS() { return getToken(BasicParser.LESS, 0); }
		public TerminalNode LESS_EQUAL() { return getToken(BasicParser.LESS_EQUAL, 0); }
		public TerminalNode PLUS() { return getToken(BasicParser.PLUS, 0); }
		public TerminalNode GREATER() { return getToken(BasicParser.GREATER, 0); }
		public TerminalNode MOD() { return getToken(BasicParser.MOD, 0); }
		public Binary_operContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_oper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBinary_oper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binary_operContext binary_oper() throws RecognitionException {
		Binary_operContext _localctx = new Binary_operContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_binary_oper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULTIPLY) | (1L << DIVIDE) | (1L << MOD) | (1L << PLUS) | (1L << MINUS) | (1L << GREATER) | (1L << GREATER_EQUAL) | (1L << LESS) | (1L << LESS_EQUAL) | (1L << EQUAL) | (1L << NOT_EQUAL) | (1L << AND) | (1L << OR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243); match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Int_literContext extends ParserRuleContext {
		public Int_signContext int_sign() {
			return getRuleContext(Int_signContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(BasicParser.INTEGER, 0); }
		public Int_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitInt_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Int_literContext int_liter() throws RecognitionException {
		Int_literContext _localctx = new Int_literContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_int_liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(245); int_sign();
				}
			}

			setState(248); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Int_signContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(BasicParser.PLUS, 0); }
		public Int_signContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_sign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitInt_sign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Int_signContext int_sign() throws RecognitionException {
		Int_signContext _localctx = new Int_signContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_int_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bool_literContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(BasicParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(BasicParser.FALSE, 0); }
		public Bool_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBool_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_literContext bool_liter() throws RecognitionException {
		Bool_literContext _localctx = new Bool_literContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_bool_liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Char_literContext extends ParserRuleContext {
		public TerminalNode SINGLE_QUOTE(int i) {
			return getToken(BasicParser.SINGLE_QUOTE, i);
		}
		public List<TerminalNode> SINGLE_QUOTE() { return getTokens(BasicParser.SINGLE_QUOTE); }
		public CharacterContext character() {
			return getRuleContext(CharacterContext.class,0);
		}
		public Char_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_char_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitChar_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Char_literContext char_liter() throws RecognitionException {
		Char_literContext _localctx = new Char_literContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_char_liter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254); match(SINGLE_QUOTE);
			setState(255); character();
			setState(256); match(SINGLE_QUOTE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Str_literContext extends ParserRuleContext {
		public CharacterContext character(int i) {
			return getRuleContext(CharacterContext.class,i);
		}
		public List<CharacterContext> character() {
			return getRuleContexts(CharacterContext.class);
		}
		public TerminalNode DOUBLE_QUOTE(int i) {
			return getToken(BasicParser.DOUBLE_QUOTE, i);
		}
		public List<TerminalNode> DOUBLE_QUOTE() { return getTokens(BasicParser.DOUBLE_QUOTE); }
		public Str_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_str_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitStr_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Str_literContext str_liter() throws RecognitionException {
		Str_literContext _localctx = new Str_literContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_str_liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258); match(DOUBLE_QUOTE);
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUALS) | (1L << SKIP) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << IF) | (1L << THEN) | (1L << ELSE) | (1L << ENDIF) | (1L << WHILE) | (1L << DO) | (1L << DONE) | (1L << BEGIN) | (1L << END) | (1L << IS) | (1L << SEMICOLON) | (1L << NEWPAIR) | (1L << CALL) | (1L << FIRST) | (1L << SECOND) | (1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << PAIR) | (1L << NOT) | (1L << LENGTH) | (1L << ORD) | (1L << TO_INT) | (1L << MULTIPLY) | (1L << DIVIDE) | (1L << MOD) | (1L << PLUS) | (1L << MINUS) | (1L << GREATER) | (1L << GREATER_EQUAL) | (1L << LESS) | (1L << LESS_EQUAL) | (1L << EQUAL) | (1L << NOT_EQUAL) | (1L << AND) | (1L << OR) | (1L << UNDERSCORE) | (1L << TRUE) | (1L << FALSE) | (1L << ESCAPED_CHAR) | (1L << OPEN_BRACKET) | (1L << CLOSE_BRACKET) | (1L << COMMA) | (1L << NULL) | (1L << OPEN_PARENTHESES) | (1L << CLOSE_PARENTHESES) | (1L << INTEGER) | (1L << IDENT) | (1L << WHITESPACE) | (1L << COMMENT) | (1L << EVERYTHING))) != 0)) {
				{
				{
				setState(259); character();
				}
				}
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(265); match(DOUBLE_QUOTE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CharacterContext extends ParserRuleContext {
		public TerminalNode SINGLE_QUOTE() { return getToken(BasicParser.SINGLE_QUOTE, 0); }
		public TerminalNode BACKSLASH() { return getToken(BasicParser.BACKSLASH, 0); }
		public TerminalNode DOUBLE_QUOTE() { return getToken(BasicParser.DOUBLE_QUOTE, 0); }
		public TerminalNode ESCAPED_CHAR() { return getToken(BasicParser.ESCAPED_CHAR, 0); }
		public CharacterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_character; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitCharacter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CharacterContext character() throws RecognitionException {
		CharacterContext _localctx = new CharacterContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_character);
		int _la;
		try {
			setState(269);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				_la = _input.LA(1);
				if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_QUOTE) | (1L << SINGLE_QUOTE) | (1L << BACKSLASH))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(268); match(ESCAPED_CHAR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_literContext extends ParserRuleContext {
		public TerminalNode CLOSE_BRACKET() { return getToken(BasicParser.CLOSE_BRACKET, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicParser.COMMA); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPEN_BRACKET() { return getToken(BasicParser.OPEN_BRACKET, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(BasicParser.COMMA, i);
		}
		public Array_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArray_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_literContext array_liter() throws RecognitionException {
		Array_literContext _localctx = new Array_literContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_array_liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271); match(OPEN_BRACKET);
			setState(280);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << LENGTH) | (1L << ORD) | (1L << TO_INT) | (1L << PLUS) | (1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << DOUBLE_QUOTE) | (1L << SINGLE_QUOTE) | (1L << NULL) | (1L << OPEN_PARENTHESES) | (1L << INTEGER) | (1L << IDENT))) != 0)) {
				{
				setState(272); expr(0);
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(273); match(COMMA);
					setState(274); expr(0);
					}
					}
					setState(279);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(282); match(CLOSE_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pair_literContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(BasicParser.NULL, 0); }
		public Pair_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPair_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_literContext pair_liter() throws RecognitionException {
		Pair_literContext _localctx = new Pair_literContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_pair_liter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284); match(NULL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BasicParser.EOF, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286); program();
			setState(287); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4: return stat_sempred((StatContext)_localctx, predIndex);

		case 14: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return 4 >= _localctx._p;

		case 2: return 2 >= _localctx._p;
		}
		return true;
	}
	private boolean stat_sempred(StatContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 1 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3A\u0124\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\7\2;\n\2\f\2\16\2>\13\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\5\3G\n\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4Q\n\4"+
		"\f\4\16\4T\13\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0082\n\6\3\6"+
		"\3\6\3\6\7\6\u0087\n\6\f\6\16\6\u008a\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\5\7\u0093\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\5\b\u00a3\n\b\3\b\3\b\5\b\u00a7\n\b\3\t\3\t\3\t\7\t\u00ac\n\t\f\t\16"+
		"\t\u00af\13\t\3\n\3\n\3\n\3\n\5\n\u00b5\n\n\3\13\3\13\3\13\5\13\u00ba"+
		"\n\13\3\f\3\f\3\r\3\r\5\r\u00c0\n\r\3\r\3\r\6\r\u00c4\n\r\r\r\16\r\u00c5"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\5\17\u00d2\n\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u00e2\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00ed\n"+
		"\20\f\20\16\20\u00f0\13\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\5\24\u00f9"+
		"\n\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\7\30"+
		"\u0107\n\30\f\30\16\30\u010a\13\30\3\30\3\30\3\31\3\31\5\31\u0110\n\31"+
		"\3\32\3\32\3\32\3\32\7\32\u0116\n\32\f\32\16\32\u0119\13\32\5\32\u011b"+
		"\n\32\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\2\35\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\66\2\b\3\2\32\35\4\2\37\"\'\'\3\2"+
		"#/\3\2&\'\3\2\61\62\3\2\63\65\u0134\28\3\2\2\2\4B\3\2\2\2\6M\3\2\2\2\b"+
		"U\3\2\2\2\n\u0081\3\2\2\2\f\u0092\3\2\2\2\16\u00a6\3\2\2\2\20\u00a8\3"+
		"\2\2\2\22\u00b4\3\2\2\2\24\u00b9\3\2\2\2\26\u00bb\3\2\2\2\30\u00bf\3\2"+
		"\2\2\32\u00c7\3\2\2\2\34\u00d1\3\2\2\2\36\u00e1\3\2\2\2 \u00f1\3\2\2\2"+
		"\"\u00f3\3\2\2\2$\u00f5\3\2\2\2&\u00f8\3\2\2\2(\u00fc\3\2\2\2*\u00fe\3"+
		"\2\2\2,\u0100\3\2\2\2.\u0104\3\2\2\2\60\u010f\3\2\2\2\62\u0111\3\2\2\2"+
		"\64\u011e\3\2\2\2\66\u0120\3\2\2\28<\7\22\2\29;\5\4\3\2:9\3\2\2\2;>\3"+
		"\2\2\2<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2><\3\2\2\2?@\5\n\6\2@A\7\23\2\2A\3"+
		"\3\2\2\2BC\5\24\13\2CD\5$\23\2DF\7;\2\2EG\5\6\4\2FE\3\2\2\2FG\3\2\2\2"+
		"GH\3\2\2\2HI\7<\2\2IJ\7\24\2\2JK\5\n\6\2KL\7\23\2\2L\5\3\2\2\2MR\5\b\5"+
		"\2NO\79\2\2OQ\5\b\5\2PN\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\7\3\2\2"+
		"\2TR\3\2\2\2UV\5\24\13\2VW\5$\23\2W\t\3\2\2\2XY\b\6\1\2Y\u0082\7\4\2\2"+
		"Z[\5\24\13\2[\\\5$\23\2\\]\7\3\2\2]^\5\16\b\2^\u0082\3\2\2\2_`\5\f\7\2"+
		"`a\7\3\2\2ab\5\16\b\2b\u0082\3\2\2\2cd\7\5\2\2d\u0082\5\f\7\2ef\7\6\2"+
		"\2f\u0082\5\36\20\2gh\7\7\2\2h\u0082\5\36\20\2ij\7\b\2\2j\u0082\5\36\20"+
		"\2kl\7\t\2\2l\u0082\5\36\20\2mn\7\n\2\2n\u0082\5\36\20\2op\7\13\2\2pq"+
		"\5\36\20\2qr\7\f\2\2rs\5\n\6\2st\7\r\2\2tu\5\n\6\2uv\7\16\2\2v\u0082\3"+
		"\2\2\2wx\7\17\2\2xy\5\36\20\2yz\7\20\2\2z{\5\n\6\2{|\7\21\2\2|\u0082\3"+
		"\2\2\2}~\7\22\2\2~\177\5\n\6\2\177\u0080\7\23\2\2\u0080\u0082\3\2\2\2"+
		"\u0081X\3\2\2\2\u0081Z\3\2\2\2\u0081_\3\2\2\2\u0081c\3\2\2\2\u0081e\3"+
		"\2\2\2\u0081g\3\2\2\2\u0081i\3\2\2\2\u0081k\3\2\2\2\u0081m\3\2\2\2\u0081"+
		"o\3\2\2\2\u0081w\3\2\2\2\u0081}\3\2\2\2\u0082\u0088\3\2\2\2\u0083\u0084"+
		"\6\6\2\3\u0084\u0085\7\25\2\2\u0085\u0087\5\n\6\2\u0086\u0083\3\2\2\2"+
		"\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\13"+
		"\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u0093\5$\23\2\u008c\u008d\5\36\20\2"+
		"\u008d\u008e\7\67\2\2\u008e\u008f\5\36\20\2\u008f\u0090\78\2\2\u0090\u0093"+
		"\3\2\2\2\u0091\u0093\5\22\n\2\u0092\u008b\3\2\2\2\u0092\u008c\3\2\2\2"+
		"\u0092\u0091\3\2\2\2\u0093\r\3\2\2\2\u0094\u00a7\5\36\20\2\u0095\u00a7"+
		"\5\62\32\2\u0096\u0097\7\26\2\2\u0097\u0098\7;\2\2\u0098\u0099\5\36\20"+
		"\2\u0099\u009a\79\2\2\u009a\u009b\5\36\20\2\u009b\u009c\7<\2\2\u009c\u00a7"+
		"\3\2\2\2\u009d\u00a7\5\22\n\2\u009e\u009f\7\27\2\2\u009f\u00a0\5$\23\2"+
		"\u00a0\u00a2\7;\2\2\u00a1\u00a3\5\20\t\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\7<\2\2\u00a5\u00a7\3\2\2\2\u00a6"+
		"\u0094\3\2\2\2\u00a6\u0095\3\2\2\2\u00a6\u0096\3\2\2\2\u00a6\u009d\3\2"+
		"\2\2\u00a6\u009e\3\2\2\2\u00a7\17\3\2\2\2\u00a8\u00ad\5\36\20\2\u00a9"+
		"\u00aa\79\2\2\u00aa\u00ac\5\36\20\2\u00ab\u00a9\3\2\2\2\u00ac\u00af\3"+
		"\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\21\3\2\2\2\u00af"+
		"\u00ad\3\2\2\2\u00b0\u00b1\7\30\2\2\u00b1\u00b5\5\36\20\2\u00b2\u00b3"+
		"\7\31\2\2\u00b3\u00b5\5\36\20\2\u00b4\u00b0\3\2\2\2\u00b4\u00b2\3\2\2"+
		"\2\u00b5\23\3\2\2\2\u00b6\u00ba\5\26\f\2\u00b7\u00ba\5\30\r\2\u00b8\u00ba"+
		"\5\32\16\2\u00b9\u00b6\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00b8\3\2\2\2"+
		"\u00ba\25\3\2\2\2\u00bb\u00bc\t\2\2\2\u00bc\27\3\2\2\2\u00bd\u00c0\5\26"+
		"\f\2\u00be\u00c0\5\32\16\2\u00bf\u00bd\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0"+
		"\u00c3\3\2\2\2\u00c1\u00c2\7\67\2\2\u00c2\u00c4\78\2\2\u00c3\u00c1\3\2"+
		"\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\31\3\2\2\2\u00c7\u00c8\7\36\2\2\u00c8\u00c9\7;\2\2\u00c9\u00ca\5\34\17"+
		"\2\u00ca\u00cb\79\2\2\u00cb\u00cc\5\34\17\2\u00cc\u00cd\7<\2\2\u00cd\33"+
		"\3\2\2\2\u00ce\u00d2\5\26\f\2\u00cf\u00d2\5\30\r\2\u00d0\u00d2\7\36\2"+
		"\2\u00d1\u00ce\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\35"+
		"\3\2\2\2\u00d3\u00d4\b\20\1\2\u00d4\u00d5\5 \21\2\u00d5\u00d6\5\36\20"+
		"\2\u00d6\u00e2\3\2\2\2\u00d7\u00e2\5&\24\2\u00d8\u00e2\5*\26\2\u00d9\u00e2"+
		"\5,\27\2\u00da\u00e2\5.\30\2\u00db\u00e2\5\64\33\2\u00dc\u00e2\5$\23\2"+
		"\u00dd\u00de\7;\2\2\u00de\u00df\5\36\20\2\u00df\u00e0\7<\2\2\u00e0\u00e2"+
		"\3\2\2\2\u00e1\u00d3\3\2\2\2\u00e1\u00d7\3\2\2\2\u00e1\u00d8\3\2\2\2\u00e1"+
		"\u00d9\3\2\2\2\u00e1\u00da\3\2\2\2\u00e1\u00db\3\2\2\2\u00e1\u00dc\3\2"+
		"\2\2\u00e1\u00dd\3\2\2\2\u00e2\u00ee\3\2\2\2\u00e3\u00e4\6\20\3\3\u00e4"+
		"\u00e5\7\67\2\2\u00e5\u00e6\5\36\20\2\u00e6\u00e7\78\2\2\u00e7\u00ed\3"+
		"\2\2\2\u00e8\u00e9\6\20\4\3\u00e9\u00ea\5\"\22\2\u00ea\u00eb\5\36\20\2"+
		"\u00eb\u00ed\3\2\2\2\u00ec\u00e3\3\2\2\2\u00ec\u00e8\3\2\2\2\u00ed\u00f0"+
		"\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\37\3\2\2\2\u00f0"+
		"\u00ee\3\2\2\2\u00f1\u00f2\t\3\2\2\u00f2!\3\2\2\2\u00f3\u00f4\t\4\2\2"+
		"\u00f4#\3\2\2\2\u00f5\u00f6\7>\2\2\u00f6%\3\2\2\2\u00f7\u00f9\5(\25\2"+
		"\u00f8\u00f7\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb"+
		"\7=\2\2\u00fb\'\3\2\2\2\u00fc\u00fd\t\5\2\2\u00fd)\3\2\2\2\u00fe\u00ff"+
		"\t\6\2\2\u00ff+\3\2\2\2\u0100\u0101\7\64\2\2\u0101\u0102\5\60\31\2\u0102"+
		"\u0103\7\64\2\2\u0103-\3\2\2\2\u0104\u0108\7\63\2\2\u0105\u0107\5\60\31"+
		"\2\u0106\u0105\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109"+
		"\3\2\2\2\u0109\u010b\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u010c\7\63\2\2"+
		"\u010c/\3\2\2\2\u010d\u0110\n\7\2\2\u010e\u0110\7\66\2\2\u010f\u010d\3"+
		"\2\2\2\u010f\u010e\3\2\2\2\u0110\61\3\2\2\2\u0111\u011a\7\67\2\2\u0112"+
		"\u0117\5\36\20\2\u0113\u0114\79\2\2\u0114\u0116\5\36\20\2\u0115\u0113"+
		"\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118"+
		"\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u0112\3\2\2\2\u011a\u011b\3\2"+
		"\2\2\u011b\u011c\3\2\2\2\u011c\u011d\78\2\2\u011d\63\3\2\2\2\u011e\u011f"+
		"\7:\2\2\u011f\65\3\2\2\2\u0120\u0121\5\2\2\2\u0121\u0122\7\2\2\3\u0122"+
		"\67\3\2\2\2\30<FR\u0081\u0088\u0092\u00a2\u00a6\u00ad\u00b4\u00b9\u00bf"+
		"\u00c5\u00d1\u00e1\u00ec\u00ee\u00f8\u0108\u010f\u0117\u011a";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}