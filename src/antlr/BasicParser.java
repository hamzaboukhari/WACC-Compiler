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
		WHILE=14, DOUBLE_QUOTE=50, MOD=36, CHAR=27, DO=15, FOR=13, EVERYTHING=64, 
		EQUALS=1, NOT=30, AND=45, ESCAPED_CHAR=53, ORD=32, TO_INT=33, LENGTH=31, 
		IF=9, OPEN_BRACKET=54, FREE=4, SINGLE_QUOTE=51, CLOSE_PARENTHESES=59, 
		GREATER=39, THEN=10, MULTIPLY=34, COMMA=56, NOT_EQUAL=44, IS=19, DONE=16, 
		PRINTLN=8, BEGIN=17, EQUAL=43, RETURN=5, LESS=41, ENDIF=12, IDENT=61, 
		PLUS=37, PAIR=29, COMMENT=63, NEWPAIR=21, DIVIDE=35, INTEGER=60, EXIT=6, 
		SECOND=24, NULL=57, ELSE=11, BOOL=26, WHITESPACE=62, UNDERSCORE=47, SEMICOLON=20, 
		INT=25, MINUS=38, TRUE=48, PRINT=7, SKIP=2, READ=3, OR=46, OPEN_PARENTHESES=58, 
		LESS_EQUAL=42, CALL=22, END=18, FALSE=49, GREATER_EQUAL=40, FIRST=23, 
		STRING=28, CLOSE_BRACKET=55, BACKSLASH=52;
	public static final String[] tokenNames = {
		"<INVALID>", "'='", "'skip'", "'read'", "'free'", "'return'", "'exit'", 
		"'print'", "'println'", "'if'", "'then'", "'else'", "'fi'", "'for'", "'while'", 
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
		public TerminalNode SEMICOLON(int i) {
			return getToken(BasicParser.SEMICOLON, i);
		}
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
		public List<TerminalNode> SEMICOLON() { return getTokens(BasicParser.SEMICOLON); }
		public TerminalNode EQUALS() { return getToken(BasicParser.EQUALS, 0); }
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public TerminalNode DONE() { return getToken(BasicParser.DONE, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(BasicParser.COMMA, i);
		}
		public Assign_rhsContext assign_rhs() {
			return getRuleContext(Assign_rhsContext.class,0);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode FOR() { return getToken(BasicParser.FOR, 0); }
		public TerminalNode ELSE() { return getToken(BasicParser.ELSE, 0); }
		public TerminalNode READ() { return getToken(BasicParser.READ, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BasicParser.COMMA); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ENDIF() { return getToken(BasicParser.ENDIF, 0); }
		public TerminalNode BEGIN() { return getToken(BasicParser.BEGIN, 0); }
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
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
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(90); match(COMMA);
					setState(91); ident();
					}
					}
					setState(96);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(97); match(EQUALS);
				setState(98); assign_rhs();
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
				setState(100); assign_lhs();
				setState(101); match(EQUALS);
				setState(102); assign_rhs();
				}
				break;
			case READ:
				{
				setState(104); match(READ);
				setState(105); assign_lhs();
				}
				break;
			case FREE:
				{
				setState(106); match(FREE);
				setState(107); expr(0);
				}
				break;
			case RETURN:
				{
				setState(108); match(RETURN);
				setState(109); expr(0);
				}
				break;
			case EXIT:
				{
				setState(110); match(EXIT);
				setState(111); expr(0);
				}
				break;
			case PRINT:
				{
				setState(112); match(PRINT);
				setState(113); expr(0);
				}
				break;
			case PRINTLN:
				{
				setState(114); match(PRINTLN);
				setState(115); expr(0);
				}
				break;
			case IF:
				{
				setState(116); match(IF);
				setState(117); expr(0);
				setState(118); match(THEN);
				setState(119); stat(0);
				setState(122);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(120); match(ELSE);
					setState(121); stat(0);
					}
				}

				setState(124); match(ENDIF);
				}
				break;
			case WHILE:
				{
				setState(126); match(WHILE);
				setState(127); expr(0);
				setState(128); match(DO);
				setState(129); stat(0);
				setState(130); match(DONE);
				}
				break;
			case FOR:
				{
				setState(132); match(FOR);
				setState(133); stat(0);
				setState(134); match(SEMICOLON);
				setState(135); expr(0);
				setState(136); match(SEMICOLON);
				setState(137); stat(0);
				setState(138); match(DO);
				setState(139); stat(0);
				setState(140); match(DONE);
				}
				break;
			case BEGIN:
				{
				setState(142); match(BEGIN);
				setState(143); stat(0);
				setState(144); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(153);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(148);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(149); match(SEMICOLON);
					setState(150); stat(2);
					}
					} 
				}
				setState(155);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
			setState(163);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156); ident();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157); expr(0);
				setState(158); match(OPEN_BRACKET);
				setState(159); expr(0);
				setState(160); match(CLOSE_BRACKET);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(162); pair_elem();
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
			setState(183);
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
				setState(165); expr(0);
				}
				break;
			case OPEN_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(166); array_liter();
				}
				break;
			case NEWPAIR:
				enterOuterAlt(_localctx, 3);
				{
				setState(167); match(NEWPAIR);
				setState(168); match(OPEN_PARENTHESES);
				setState(169); expr(0);
				setState(170); match(COMMA);
				setState(171); expr(0);
				setState(172); match(CLOSE_PARENTHESES);
				}
				break;
			case FIRST:
			case SECOND:
				enterOuterAlt(_localctx, 4);
				{
				setState(174); pair_elem();
				}
				break;
			case CALL:
				enterOuterAlt(_localctx, 5);
				{
				setState(175); match(CALL);
				setState(176); ident();
				setState(177); match(OPEN_PARENTHESES);
				setState(179);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << LENGTH) | (1L << ORD) | (1L << TO_INT) | (1L << PLUS) | (1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << DOUBLE_QUOTE) | (1L << SINGLE_QUOTE) | (1L << NULL) | (1L << OPEN_PARENTHESES) | (1L << INTEGER) | (1L << IDENT))) != 0)) {
					{
					setState(178); arg_list();
					}
				}

				setState(181); match(CLOSE_PARENTHESES);
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
			setState(185); expr(0);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(186); match(COMMA);
				setState(187); expr(0);
				}
				}
				setState(192);
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
			setState(197);
			switch (_input.LA(1)) {
			case FIRST:
				enterOuterAlt(_localctx, 1);
				{
				setState(193); match(FIRST);
				setState(194); expr(0);
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(195); match(SECOND);
				setState(196); expr(0);
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
			setState(202);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(199); base_type();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(200); array_type();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(201); pair_type();
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
			setState(204);
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
			setState(208);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
				{
				setState(206); base_type();
				}
				break;
			case PAIR:
				{
				setState(207); pair_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(212); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(210); match(OPEN_BRACKET);
				setState(211); match(CLOSE_BRACKET);
				}
				}
				setState(214); 
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
			setState(216); match(PAIR);
			setState(217); match(OPEN_PARENTHESES);
			setState(218); pair_elem_type();
			setState(219); match(COMMA);
			setState(220); pair_elem_type();
			setState(221); match(CLOSE_PARENTHESES);
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
			setState(226);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(223); base_type();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(224); array_type();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(225); match(PAIR);
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
			setState(242);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(229); unary_oper();
				setState(230); expr(3);
				}
				break;

			case 2:
				{
				setState(232); int_liter();
				}
				break;

			case 3:
				{
				setState(233); bool_liter();
				}
				break;

			case 4:
				{
				setState(234); char_liter();
				}
				break;

			case 5:
				{
				setState(235); str_liter();
				}
				break;

			case 6:
				{
				setState(236); pair_liter();
				}
				break;

			case 7:
				{
				setState(237); ident();
				}
				break;

			case 8:
				{
				setState(238); match(OPEN_PARENTHESES);
				setState(239); expr(0);
				setState(240); match(CLOSE_PARENTHESES);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(255);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(253);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(244);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(245); match(OPEN_BRACKET);
						setState(246); expr(0);
						setState(247); match(CLOSE_BRACKET);
						}
						break;

					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(249);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(250); binary_oper();
						setState(251); expr(0);
						}
						break;
					}
					} 
				}
				setState(257);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
			setState(258);
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
		public TerminalNode OR() { return getToken(BasicParser.OR, 0); }
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
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
			setState(260);
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
			setState(262); match(IDENT);
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
			setState(265);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(264); int_sign();
				}
			}

			setState(267); match(INTEGER);
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
			setState(269);
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
			setState(271);
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
			setState(273); match(SINGLE_QUOTE);
			setState(274); character();
			setState(275); match(SINGLE_QUOTE);
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
			setState(277); match(DOUBLE_QUOTE);
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (EQUALS - 1)) | (1L << (SKIP - 1)) | (1L << (READ - 1)) | (1L << (FREE - 1)) | (1L << (RETURN - 1)) | (1L << (EXIT - 1)) | (1L << (PRINT - 1)) | (1L << (PRINTLN - 1)) | (1L << (IF - 1)) | (1L << (THEN - 1)) | (1L << (ELSE - 1)) | (1L << (ENDIF - 1)) | (1L << (FOR - 1)) | (1L << (WHILE - 1)) | (1L << (DO - 1)) | (1L << (DONE - 1)) | (1L << (BEGIN - 1)) | (1L << (END - 1)) | (1L << (IS - 1)) | (1L << (SEMICOLON - 1)) | (1L << (NEWPAIR - 1)) | (1L << (CALL - 1)) | (1L << (FIRST - 1)) | (1L << (SECOND - 1)) | (1L << (INT - 1)) | (1L << (BOOL - 1)) | (1L << (CHAR - 1)) | (1L << (STRING - 1)) | (1L << (PAIR - 1)) | (1L << (NOT - 1)) | (1L << (LENGTH - 1)) | (1L << (ORD - 1)) | (1L << (TO_INT - 1)) | (1L << (MULTIPLY - 1)) | (1L << (DIVIDE - 1)) | (1L << (MOD - 1)) | (1L << (PLUS - 1)) | (1L << (MINUS - 1)) | (1L << (GREATER - 1)) | (1L << (GREATER_EQUAL - 1)) | (1L << (LESS - 1)) | (1L << (LESS_EQUAL - 1)) | (1L << (EQUAL - 1)) | (1L << (NOT_EQUAL - 1)) | (1L << (AND - 1)) | (1L << (OR - 1)) | (1L << (UNDERSCORE - 1)) | (1L << (TRUE - 1)) | (1L << (FALSE - 1)) | (1L << (ESCAPED_CHAR - 1)) | (1L << (OPEN_BRACKET - 1)) | (1L << (CLOSE_BRACKET - 1)) | (1L << (COMMA - 1)) | (1L << (NULL - 1)) | (1L << (OPEN_PARENTHESES - 1)) | (1L << (CLOSE_PARENTHESES - 1)) | (1L << (INTEGER - 1)) | (1L << (IDENT - 1)) | (1L << (WHITESPACE - 1)) | (1L << (COMMENT - 1)) | (1L << (EVERYTHING - 1)))) != 0)) {
				{
				{
				setState(278); character();
				}
				}
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(284); match(DOUBLE_QUOTE);
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
			setState(288);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
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
				setState(287); match(ESCAPED_CHAR);
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
			setState(290); match(OPEN_BRACKET);
			setState(299);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << LENGTH) | (1L << ORD) | (1L << TO_INT) | (1L << PLUS) | (1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << DOUBLE_QUOTE) | (1L << SINGLE_QUOTE) | (1L << NULL) | (1L << OPEN_PARENTHESES) | (1L << INTEGER) | (1L << IDENT))) != 0)) {
				{
				setState(291); expr(0);
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(292); match(COMMA);
					setState(293); expr(0);
					}
					}
					setState(298);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(301); match(CLOSE_BRACKET);
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
			setState(303); match(NULL);
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
			setState(305); program();
			setState(306); match(EOF);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3B\u0137\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\7\2;\n\2\f\2\16\2>\13\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\5\3G\n\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4Q\n\4"+
		"\f\4\16\4T\13\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6_\n\6\f\6\16\6"+
		"b\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6}\n\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0095"+
		"\n\6\3\6\3\6\3\6\7\6\u009a\n\6\f\6\16\6\u009d\13\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\5\7\u00a6\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\5\b\u00b6\n\b\3\b\3\b\5\b\u00ba\n\b\3\t\3\t\3\t\7\t\u00bf\n\t"+
		"\f\t\16\t\u00c2\13\t\3\n\3\n\3\n\3\n\5\n\u00c8\n\n\3\13\3\13\3\13\5\13"+
		"\u00cd\n\13\3\f\3\f\3\r\3\r\5\r\u00d3\n\r\3\r\3\r\6\r\u00d7\n\r\r\r\16"+
		"\r\u00d8\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\5\17\u00e5"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\5\20\u00f5\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20"+
		"\u0100\n\20\f\20\16\20\u0103\13\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\5\24\u010c\n\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\7\30\u011a\n\30\f\30\16\30\u011d\13\30\3\30\3\30\3\31\3\31\5\31"+
		"\u0123\n\31\3\32\3\32\3\32\3\32\7\32\u0129\n\32\f\32\16\32\u012c\13\32"+
		"\5\32\u012e\n\32\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\2\35\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66\2\b\3\2\33\36\4\2"+
		" #((\3\2$\60\3\2\'(\3\2\62\63\3\2\64\66\u014a\28\3\2\2\2\4B\3\2\2\2\6"+
		"M\3\2\2\2\bU\3\2\2\2\n\u0094\3\2\2\2\f\u00a5\3\2\2\2\16\u00b9\3\2\2\2"+
		"\20\u00bb\3\2\2\2\22\u00c7\3\2\2\2\24\u00cc\3\2\2\2\26\u00ce\3\2\2\2\30"+
		"\u00d2\3\2\2\2\32\u00da\3\2\2\2\34\u00e4\3\2\2\2\36\u00f4\3\2\2\2 \u0104"+
		"\3\2\2\2\"\u0106\3\2\2\2$\u0108\3\2\2\2&\u010b\3\2\2\2(\u010f\3\2\2\2"+
		"*\u0111\3\2\2\2,\u0113\3\2\2\2.\u0117\3\2\2\2\60\u0122\3\2\2\2\62\u0124"+
		"\3\2\2\2\64\u0131\3\2\2\2\66\u0133\3\2\2\28<\7\23\2\29;\5\4\3\2:9\3\2"+
		"\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2><\3\2\2\2?@\5\n\6\2@A\7\24"+
		"\2\2A\3\3\2\2\2BC\5\24\13\2CD\5$\23\2DF\7<\2\2EG\5\6\4\2FE\3\2\2\2FG\3"+
		"\2\2\2GH\3\2\2\2HI\7=\2\2IJ\7\25\2\2JK\5\n\6\2KL\7\24\2\2L\5\3\2\2\2M"+
		"R\5\b\5\2NO\7:\2\2OQ\5\b\5\2PN\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S"+
		"\7\3\2\2\2TR\3\2\2\2UV\5\24\13\2VW\5$\23\2W\t\3\2\2\2XY\b\6\1\2Y\u0095"+
		"\7\4\2\2Z[\5\24\13\2[`\5$\23\2\\]\7:\2\2]_\5$\23\2^\\\3\2\2\2_b\3\2\2"+
		"\2`^\3\2\2\2`a\3\2\2\2ac\3\2\2\2b`\3\2\2\2cd\7\3\2\2de\5\16\b\2e\u0095"+
		"\3\2\2\2fg\5\f\7\2gh\7\3\2\2hi\5\16\b\2i\u0095\3\2\2\2jk\7\5\2\2k\u0095"+
		"\5\f\7\2lm\7\6\2\2m\u0095\5\36\20\2no\7\7\2\2o\u0095\5\36\20\2pq\7\b\2"+
		"\2q\u0095\5\36\20\2rs\7\t\2\2s\u0095\5\36\20\2tu\7\n\2\2u\u0095\5\36\20"+
		"\2vw\7\13\2\2wx\5\36\20\2xy\7\f\2\2y|\5\n\6\2z{\7\r\2\2{}\5\n\6\2|z\3"+
		"\2\2\2|}\3\2\2\2}~\3\2\2\2~\177\7\16\2\2\177\u0095\3\2\2\2\u0080\u0081"+
		"\7\20\2\2\u0081\u0082\5\36\20\2\u0082\u0083\7\21\2\2\u0083\u0084\5\n\6"+
		"\2\u0084\u0085\7\22\2\2\u0085\u0095\3\2\2\2\u0086\u0087\7\17\2\2\u0087"+
		"\u0088\5\n\6\2\u0088\u0089\7\26\2\2\u0089\u008a\5\36\20\2\u008a\u008b"+
		"\7\26\2\2\u008b\u008c\5\n\6\2\u008c\u008d\7\21\2\2\u008d\u008e\5\n\6\2"+
		"\u008e\u008f\7\22\2\2\u008f\u0095\3\2\2\2\u0090\u0091\7\23\2\2\u0091\u0092"+
		"\5\n\6\2\u0092\u0093\7\24\2\2\u0093\u0095\3\2\2\2\u0094X\3\2\2\2\u0094"+
		"Z\3\2\2\2\u0094f\3\2\2\2\u0094j\3\2\2\2\u0094l\3\2\2\2\u0094n\3\2\2\2"+
		"\u0094p\3\2\2\2\u0094r\3\2\2\2\u0094t\3\2\2\2\u0094v\3\2\2\2\u0094\u0080"+
		"\3\2\2\2\u0094\u0086\3\2\2\2\u0094\u0090\3\2\2\2\u0095\u009b\3\2\2\2\u0096"+
		"\u0097\6\6\2\3\u0097\u0098\7\26\2\2\u0098\u009a\5\n\6\2\u0099\u0096\3"+
		"\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\13\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u00a6\5$\23\2\u009f\u00a0\5\36\20"+
		"\2\u00a0\u00a1\78\2\2\u00a1\u00a2\5\36\20\2\u00a2\u00a3\79\2\2\u00a3\u00a6"+
		"\3\2\2\2\u00a4\u00a6\5\22\n\2\u00a5\u009e\3\2\2\2\u00a5\u009f\3\2\2\2"+
		"\u00a5\u00a4\3\2\2\2\u00a6\r\3\2\2\2\u00a7\u00ba\5\36\20\2\u00a8\u00ba"+
		"\5\62\32\2\u00a9\u00aa\7\27\2\2\u00aa\u00ab\7<\2\2\u00ab\u00ac\5\36\20"+
		"\2\u00ac\u00ad\7:\2\2\u00ad\u00ae\5\36\20\2\u00ae\u00af\7=\2\2\u00af\u00ba"+
		"\3\2\2\2\u00b0\u00ba\5\22\n\2\u00b1\u00b2\7\30\2\2\u00b2\u00b3\5$\23\2"+
		"\u00b3\u00b5\7<\2\2\u00b4\u00b6\5\20\t\2\u00b5\u00b4\3\2\2\2\u00b5\u00b6"+
		"\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\7=\2\2\u00b8\u00ba\3\2\2\2\u00b9"+
		"\u00a7\3\2\2\2\u00b9\u00a8\3\2\2\2\u00b9\u00a9\3\2\2\2\u00b9\u00b0\3\2"+
		"\2\2\u00b9\u00b1\3\2\2\2\u00ba\17\3\2\2\2\u00bb\u00c0\5\36\20\2\u00bc"+
		"\u00bd\7:\2\2\u00bd\u00bf\5\36\20\2\u00be\u00bc\3\2\2\2\u00bf\u00c2\3"+
		"\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\21\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c3\u00c4\7\31\2\2\u00c4\u00c8\5\36\20\2\u00c5\u00c6"+
		"\7\32\2\2\u00c6\u00c8\5\36\20\2\u00c7\u00c3\3\2\2\2\u00c7\u00c5\3\2\2"+
		"\2\u00c8\23\3\2\2\2\u00c9\u00cd\5\26\f\2\u00ca\u00cd\5\30\r\2\u00cb\u00cd"+
		"\5\32\16\2\u00cc\u00c9\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cb\3\2\2\2"+
		"\u00cd\25\3\2\2\2\u00ce\u00cf\t\2\2\2\u00cf\27\3\2\2\2\u00d0\u00d3\5\26"+
		"\f\2\u00d1\u00d3\5\32\16\2\u00d2\u00d0\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3"+
		"\u00d6\3\2\2\2\u00d4\u00d5\78\2\2\u00d5\u00d7\79\2\2\u00d6\u00d4\3\2\2"+
		"\2\u00d7\u00d8\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\31"+
		"\3\2\2\2\u00da\u00db\7\37\2\2\u00db\u00dc\7<\2\2\u00dc\u00dd\5\34\17\2"+
		"\u00dd\u00de\7:\2\2\u00de\u00df\5\34\17\2\u00df\u00e0\7=\2\2\u00e0\33"+
		"\3\2\2\2\u00e1\u00e5\5\26\f\2\u00e2\u00e5\5\30\r\2\u00e3\u00e5\7\37\2"+
		"\2\u00e4\u00e1\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\35"+
		"\3\2\2\2\u00e6\u00e7\b\20\1\2\u00e7\u00e8\5 \21\2\u00e8\u00e9\5\36\20"+
		"\2\u00e9\u00f5\3\2\2\2\u00ea\u00f5\5&\24\2\u00eb\u00f5\5*\26\2\u00ec\u00f5"+
		"\5,\27\2\u00ed\u00f5\5.\30\2\u00ee\u00f5\5\64\33\2\u00ef\u00f5\5$\23\2"+
		"\u00f0\u00f1\7<\2\2\u00f1\u00f2\5\36\20\2\u00f2\u00f3\7=\2\2\u00f3\u00f5"+
		"\3\2\2\2\u00f4\u00e6\3\2\2\2\u00f4\u00ea\3\2\2\2\u00f4\u00eb\3\2\2\2\u00f4"+
		"\u00ec\3\2\2\2\u00f4\u00ed\3\2\2\2\u00f4\u00ee\3\2\2\2\u00f4\u00ef\3\2"+
		"\2\2\u00f4\u00f0\3\2\2\2\u00f5\u0101\3\2\2\2\u00f6\u00f7\6\20\3\3\u00f7"+
		"\u00f8\78\2\2\u00f8\u00f9\5\36\20\2\u00f9\u00fa\79\2\2\u00fa\u0100\3\2"+
		"\2\2\u00fb\u00fc\6\20\4\3\u00fc\u00fd\5\"\22\2\u00fd\u00fe\5\36\20\2\u00fe"+
		"\u0100\3\2\2\2\u00ff\u00f6\3\2\2\2\u00ff\u00fb\3\2\2\2\u0100\u0103\3\2"+
		"\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\37\3\2\2\2\u0103\u0101"+
		"\3\2\2\2\u0104\u0105\t\3\2\2\u0105!\3\2\2\2\u0106\u0107\t\4\2\2\u0107"+
		"#\3\2\2\2\u0108\u0109\7?\2\2\u0109%\3\2\2\2\u010a\u010c\5(\25\2\u010b"+
		"\u010a\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\7>"+
		"\2\2\u010e\'\3\2\2\2\u010f\u0110\t\5\2\2\u0110)\3\2\2\2\u0111\u0112\t"+
		"\6\2\2\u0112+\3\2\2\2\u0113\u0114\7\65\2\2\u0114\u0115\5\60\31\2\u0115"+
		"\u0116\7\65\2\2\u0116-\3\2\2\2\u0117\u011b\7\64\2\2\u0118\u011a\5\60\31"+
		"\2\u0119\u0118\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c"+
		"\3\2\2\2\u011c\u011e\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u011f\7\64\2\2"+
		"\u011f/\3\2\2\2\u0120\u0123\n\7\2\2\u0121\u0123\7\67\2\2\u0122\u0120\3"+
		"\2\2\2\u0122\u0121\3\2\2\2\u0123\61\3\2\2\2\u0124\u012d\78\2\2\u0125\u012a"+
		"\5\36\20\2\u0126\u0127\7:\2\2\u0127\u0129\5\36\20\2\u0128\u0126\3\2\2"+
		"\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012e"+
		"\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u0125\3\2\2\2\u012d\u012e\3\2\2\2\u012e"+
		"\u012f\3\2\2\2\u012f\u0130\79\2\2\u0130\63\3\2\2\2\u0131\u0132\7;\2\2"+
		"\u0132\65\3\2\2\2\u0133\u0134\5\2\2\2\u0134\u0135\7\2\2\3\u0135\67\3\2"+
		"\2\2\32<FR`|\u0094\u009b\u00a5\u00b5\u00b9\u00c0\u00c7\u00cc\u00d2\u00d8"+
		"\u00e4\u00f4\u00ff\u0101\u010b\u011b\u0122\u012a\u012d";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}