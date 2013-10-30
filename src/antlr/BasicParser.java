// Generated from ./BasicParser.g4 by ANTLR 4.1
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
		WHILE=13, DOUBLE_QUOTE=60, MOD=36, CHAR=26, DO=14, EQUALS=1, NOT=29, AND=45, 
		ORD=32, TO_INT=33, LENGTH=31, IF=9, OPEN_BRACKET=63, FREE=4, SINGLE_QUOTE=61, 
		LOWERCASE_LETTER=48, CLOSE_PARENTHESES=68, GREATER=39, UPPERCASE_LETTER=49, 
		BACKSPACE=55, THEN=10, MULTIPLY=34, COMMA=65, NOT_EQUAL=44, IS=18, DONE=15, 
		PRINTLN=8, BEGIN=16, EQUAL=43, RETURN=5, LESS=41, ENDIF=12, PLUS=37, PAIR=28, 
		COMMENT=71, NEWPAIR=20, DIVIDE=35, INTEGER=69, EXIT=6, POSITIVE=51, SECOND=23, 
		CARRIAGE_RETURN=59, NULL=66, NEGATIVE=50, ELSE=11, BOOL=25, TAB=56, WHITESPACE=70, 
		NEGATE=30, UNDERSCORE=47, INT=24, SEMICOLON=19, MINUS=38, TRUE=52, PRINT=7, 
		NUL=54, SKIP=2, FORM_FEED=58, NEWLINE=57, READ=3, OR=46, OPEN_PARENTHESES=67, 
		LESS_EQUAL=42, CALL=21, END=17, FALSE=53, GREATER_EQUAL=40, FIRST=22, 
		STRING=27, CLOSE_BRACKET=64, BACKSLASH=62;
	public static final String[] tokenNames = {
		"<INVALID>", "'='", "'skip'", "'read'", "'free'", "'return'", "'exit'", 
		"'print'", "'println'", "'if'", "'then'", "'else'", "'fi'", "'while'", 
		"'do'", "'done'", "'begin'", "'end'", "'is'", "';'", "'newpair'", "'call'", 
		"'fst'", "'snd'", "'int'", "'bool'", "'char'", "'string'", "'pair'", "'!'", 
		"NEGATE", "'len'", "'ord'", "'toInt'", "'*'", "'/'", "'%'", "PLUS", "MINUS", 
		"'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'&&'", "'||'", "'_'", "LOWERCASE_LETTER", 
		"UPPERCASE_LETTER", "NEGATIVE", "POSITIVE", "'true'", "'false'", "'0'", 
		"'b'", "'t'", "'n'", "'f'", "'r'", "'\"'", "'''", "'\\'", "'['", "']'", 
		"','", "'null'", "'('", "')'", "INTEGER", "WHITESPACE", "COMMENT"
	};
	public static final int
		RULE_program = 0, RULE_func = 1, RULE_param_list = 2, RULE_param = 3, 
		RULE_stat = 4, RULE_assign_lhs = 5, RULE_assign_rhs = 6, RULE_arg_list = 7, 
		RULE_pair_elem = 8, RULE_type = 9, RULE_base_type = 10, RULE_array_type = 11, 
		RULE_pair_type = 12, RULE_pair_elem_type = 13, RULE_expr = 14, RULE_expr2 = 15, 
		RULE_unary_oper = 16, RULE_binary_oper = 17, RULE_ident = 18, RULE_array_elem = 19, 
		RULE_int_liter = 20, RULE_int_sign = 21, RULE_bool_liter = 22, RULE_char_liter = 23, 
		RULE_str_liter = 24, RULE_character = 25, RULE_escaped_char = 26, RULE_array_liter = 27, 
		RULE_pair_liter = 28, RULE_prog = 29;
	public static final String[] ruleNames = {
		"program", "func", "param_list", "param", "stat", "assign_lhs", "assign_rhs", 
		"arg_list", "pair_elem", "type", "base_type", "array_type", "pair_type", 
		"pair_elem_type", "expr", "expr2", "unary_oper", "binary_oper", "ident", 
		"array_elem", "int_liter", "int_sign", "bool_liter", "char_liter", "str_liter", 
		"character", "escaped_char", "array_liter", "pair_liter", "prog"
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
			setState(60); match(BEGIN);
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(61); func();
					}
					} 
				}
				setState(66);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(67); stat(0);
			setState(68); match(END);
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
			setState(70); type();
			setState(71); ident();
			setState(72); match(OPEN_PARENTHESES);
			setState(74);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << PAIR))) != 0)) {
				{
				setState(73); param_list();
				}
			}

			setState(76); match(CLOSE_PARENTHESES);
			setState(77); match(IS);
			setState(78); stat(0);
			setState(79); match(END);
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
			setState(81); param();
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(82); match(COMMA);
				setState(83); param();
				}
				}
				setState(88);
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
			setState(89); type();
			setState(90); ident();
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
			setState(133);
			switch (_input.LA(1)) {
			case SKIP:
				{
				setState(93); match(SKIP);
				}
				break;
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
			case PAIR:
				{
				setState(94); type();
				setState(95); ident();
				setState(96); match(EQUALS);
				setState(97); assign_rhs();
				}
				break;
			case FIRST:
			case SECOND:
			case NOT:
			case NEGATE:
			case LENGTH:
			case ORD:
			case TO_INT:
			case UNDERSCORE:
			case LOWERCASE_LETTER:
			case UPPERCASE_LETTER:
			case NEGATIVE:
			case POSITIVE:
			case TRUE:
			case FALSE:
			case DOUBLE_QUOTE:
			case SINGLE_QUOTE:
			case NULL:
			case OPEN_PARENTHESES:
			case INTEGER:
				{
				setState(99); assign_lhs();
				setState(100); match(EQUALS);
				setState(101); assign_rhs();
				}
				break;
			case READ:
				{
				setState(103); match(READ);
				setState(104); assign_lhs();
				}
				break;
			case FREE:
				{
				setState(105); match(FREE);
				setState(106); expr(0);
				}
				break;
			case RETURN:
				{
				setState(107); match(RETURN);
				setState(108); expr(0);
				}
				break;
			case EXIT:
				{
				setState(109); match(EXIT);
				setState(110); expr(0);
				}
				break;
			case PRINT:
				{
				setState(111); match(PRINT);
				setState(112); expr(0);
				}
				break;
			case PRINTLN:
				{
				setState(113); match(PRINTLN);
				setState(114); expr(0);
				}
				break;
			case IF:
				{
				setState(115); match(IF);
				setState(116); expr(0);
				setState(117); match(THEN);
				setState(118); stat(0);
				setState(119); match(ELSE);
				setState(120); stat(0);
				setState(121); match(ENDIF);
				}
				break;
			case WHILE:
				{
				setState(123); match(WHILE);
				setState(124); expr(0);
				setState(125); match(DO);
				setState(126); stat(0);
				setState(127); match(DONE);
				}
				break;
			case BEGIN:
				{
				setState(129); match(BEGIN);
				setState(130); stat(0);
				setState(131); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(140);
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
					setState(135);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(136); match(SEMICOLON);
					setState(137); stat(2);
					}
					} 
				}
				setState(142);
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
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Array_elemContext array_elem() {
			return getRuleContext(Array_elemContext.class,0);
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
			setState(146);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(143); ident();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(144); array_elem();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(145); pair_elem();
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
			setState(166);
			switch (_input.LA(1)) {
			case NOT:
			case NEGATE:
			case LENGTH:
			case ORD:
			case TO_INT:
			case UNDERSCORE:
			case LOWERCASE_LETTER:
			case UPPERCASE_LETTER:
			case NEGATIVE:
			case POSITIVE:
			case TRUE:
			case FALSE:
			case DOUBLE_QUOTE:
			case SINGLE_QUOTE:
			case NULL:
			case OPEN_PARENTHESES:
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(148); expr(0);
				}
				break;
			case OPEN_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(149); array_liter();
				}
				break;
			case NEWPAIR:
				enterOuterAlt(_localctx, 3);
				{
				setState(150); match(NEWPAIR);
				setState(151); match(OPEN_PARENTHESES);
				setState(152); expr(0);
				setState(153); match(COMMA);
				setState(154); expr(0);
				setState(155); match(CLOSE_PARENTHESES);
				}
				break;
			case FIRST:
			case SECOND:
				enterOuterAlt(_localctx, 4);
				{
				setState(157); pair_elem();
				}
				break;
			case CALL:
				enterOuterAlt(_localctx, 5);
				{
				setState(158); match(CALL);
				setState(159); ident();
				setState(160); match(OPEN_PARENTHESES);
				setState(162);
				_la = _input.LA(1);
				if (((((_la - 29)) & ~0x3f) == 0 && ((1L << (_la - 29)) & ((1L << (NOT - 29)) | (1L << (NEGATE - 29)) | (1L << (LENGTH - 29)) | (1L << (ORD - 29)) | (1L << (TO_INT - 29)) | (1L << (UNDERSCORE - 29)) | (1L << (LOWERCASE_LETTER - 29)) | (1L << (UPPERCASE_LETTER - 29)) | (1L << (NEGATIVE - 29)) | (1L << (POSITIVE - 29)) | (1L << (TRUE - 29)) | (1L << (FALSE - 29)) | (1L << (DOUBLE_QUOTE - 29)) | (1L << (SINGLE_QUOTE - 29)) | (1L << (NULL - 29)) | (1L << (OPEN_PARENTHESES - 29)) | (1L << (INTEGER - 29)))) != 0)) {
					{
					setState(161); arg_list();
					}
				}

				setState(164); match(CLOSE_PARENTHESES);
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
			setState(168); expr(0);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(169); match(COMMA);
				setState(170); expr(0);
				}
				}
				setState(175);
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
			setState(180);
			switch (_input.LA(1)) {
			case FIRST:
				enterOuterAlt(_localctx, 1);
				{
				setState(176); match(FIRST);
				setState(177); expr(0);
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(178); match(SECOND);
				setState(179); expr(0);
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
			setState(185);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(182); base_type();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(183); array_type();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(184); pair_type();
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
			setState(187);
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
		public TerminalNode CLOSE_BRACKET() { return getToken(BasicParser.CLOSE_BRACKET, 0); }
		public TerminalNode OPEN_BRACKET() { return getToken(BasicParser.OPEN_BRACKET, 0); }
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public Pair_typeContext pair_type() {
			return getRuleContext(Pair_typeContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
				{
				setState(189); base_type();
				}
				break;
			case PAIR:
				{
				setState(190); pair_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(193); match(OPEN_BRACKET);
			setState(194); match(CLOSE_BRACKET);
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
			setState(196); match(PAIR);
			setState(197); match(OPEN_PARENTHESES);
			setState(198); pair_elem_type();
			setState(199); match(COMMA);
			setState(200); pair_elem_type();
			setState(201); match(CLOSE_PARENTHESES);
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
			setState(206);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(203); base_type();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(204); array_type();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(205); match(PAIR);
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
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public Unary_operContext unary_oper() {
			return getRuleContext(Unary_operContext.class,0);
		}
		public Array_elemContext array_elem() {
			return getRuleContext(Array_elemContext.class,0);
		}
		public Char_literContext char_liter() {
			return getRuleContext(Char_literContext.class,0);
		}
		public Binary_operContext binary_oper() {
			return getRuleContext(Binary_operContext.class,0);
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
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(209); unary_oper();
				setState(210); expr(3);
				}
				break;

			case 2:
				{
				setState(212); int_liter();
				}
				break;

			case 3:
				{
				setState(213); bool_liter();
				}
				break;

			case 4:
				{
				setState(214); char_liter();
				}
				break;

			case 5:
				{
				setState(215); str_liter();
				}
				break;

			case 6:
				{
				setState(216); pair_liter();
				}
				break;

			case 7:
				{
				setState(217); ident();
				}
				break;

			case 8:
				{
				setState(218); array_elem();
				}
				break;

			case 9:
				{
				setState(219); match(OPEN_PARENTHESES);
				setState(220); expr(0);
				setState(221); match(CLOSE_PARENTHESES);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(225);
					if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
					setState(226); binary_oper();
					setState(227); expr(0);
					}
					} 
				}
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class Expr2Context extends ParserRuleContext {
		public int _p;
		public Expr2Context expr2(int i) {
			return getRuleContext(Expr2Context.class,i);
		}
		public List<Expr2Context> expr2() {
			return getRuleContexts(Expr2Context.class);
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
		public Pair_literContext pair_liter() {
			return getRuleContext(Pair_literContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public Unary_operContext unary_oper() {
			return getRuleContext(Unary_operContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Bool_literContext bool_liter() {
			return getRuleContext(Bool_literContext.class,0);
		}
		public Expr2Context(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Expr2Context(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expr2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExpr2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr2Context expr2(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr2Context _localctx = new Expr2Context(_ctx, _parentState, _p);
		Expr2Context _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, RULE_expr2);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			switch (_input.LA(1)) {
			case NOT:
			case NEGATE:
			case LENGTH:
			case ORD:
			case TO_INT:
				{
				setState(235); unary_oper();
				setState(236); expr2(3);
				}
				break;
			case NEGATIVE:
			case POSITIVE:
			case INTEGER:
				{
				setState(238); int_liter();
				}
				break;
			case TRUE:
			case FALSE:
				{
				setState(239); bool_liter();
				}
				break;
			case SINGLE_QUOTE:
				{
				setState(240); char_liter();
				}
				break;
			case DOUBLE_QUOTE:
				{
				setState(241); str_liter();
				}
				break;
			case NULL:
				{
				setState(242); pair_liter();
				}
				break;
			case UNDERSCORE:
			case LOWERCASE_LETTER:
			case UPPERCASE_LETTER:
				{
				setState(243); ident();
				}
				break;
			case OPEN_PARENTHESES:
				{
				setState(244); match(OPEN_PARENTHESES);
				setState(245); expr2(0);
				setState(246); match(CLOSE_PARENTHESES);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(256);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr2Context(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_expr2);
					setState(250);
					if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
					setState(251); binary_oper();
					setState(252); expr2(0);
					}
					} 
				}
				setState(258);
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
		public TerminalNode NOT() { return getToken(BasicParser.NOT, 0); }
		public TerminalNode ORD() { return getToken(BasicParser.ORD, 0); }
		public TerminalNode LENGTH() { return getToken(BasicParser.LENGTH, 0); }
		public TerminalNode NEGATE() { return getToken(BasicParser.NEGATE, 0); }
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
		enterRule(_localctx, 32, RULE_unary_oper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << NEGATE) | (1L << LENGTH) | (1L << ORD) | (1L << TO_INT))) != 0)) ) {
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
		enterRule(_localctx, 34, RULE_binary_oper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
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
		public TerminalNode INTEGER(int i) {
			return getToken(BasicParser.INTEGER, i);
		}
		public List<TerminalNode> UNDERSCORE() { return getTokens(BasicParser.UNDERSCORE); }
		public TerminalNode LOWERCASE_LETTER(int i) {
			return getToken(BasicParser.LOWERCASE_LETTER, i);
		}
		public TerminalNode UNDERSCORE(int i) {
			return getToken(BasicParser.UNDERSCORE, i);
		}
		public List<TerminalNode> LOWERCASE_LETTER() { return getTokens(BasicParser.LOWERCASE_LETTER); }
		public TerminalNode UPPERCASE_LETTER(int i) {
			return getToken(BasicParser.UPPERCASE_LETTER, i);
		}
		public List<TerminalNode> INTEGER() { return getTokens(BasicParser.INTEGER); }
		public List<TerminalNode> UPPERCASE_LETTER() { return getTokens(BasicParser.UPPERCASE_LETTER); }
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
		enterRule(_localctx, 36, RULE_ident);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNDERSCORE) | (1L << LOWERCASE_LETTER) | (1L << UPPERCASE_LETTER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(267);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(264);
					_la = _input.LA(1);
					if ( !(((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & ((1L << (UNDERSCORE - 47)) | (1L << (LOWERCASE_LETTER - 47)) | (1L << (UPPERCASE_LETTER - 47)) | (1L << (INTEGER - 47)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					} 
				}
				setState(269);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public static class Array_elemContext extends ParserRuleContext {
		public Expr2Context expr2(int i) {
			return getRuleContext(Expr2Context.class,i);
		}
		public List<Expr2Context> expr2() {
			return getRuleContexts(Expr2Context.class);
		}
		public TerminalNode CLOSE_BRACKET() { return getToken(BasicParser.CLOSE_BRACKET, 0); }
		public TerminalNode OPEN_BRACKET() { return getToken(BasicParser.OPEN_BRACKET, 0); }
		public Array_elemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_elem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArray_elem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_elemContext array_elem() throws RecognitionException {
		Array_elemContext _localctx = new Array_elemContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_array_elem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270); expr2(0);
			setState(271); match(OPEN_BRACKET);
			setState(272); expr2(0);
			setState(273); match(CLOSE_BRACKET);
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
		enterRule(_localctx, 40, RULE_int_liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			_la = _input.LA(1);
			if (_la==NEGATIVE || _la==POSITIVE) {
				{
				setState(275); int_sign();
				}
			}

			setState(278); match(INTEGER);
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
		public TerminalNode POSITIVE() { return getToken(BasicParser.POSITIVE, 0); }
		public TerminalNode NEGATIVE() { return getToken(BasicParser.NEGATIVE, 0); }
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
		enterRule(_localctx, 42, RULE_int_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			_la = _input.LA(1);
			if ( !(_la==NEGATIVE || _la==POSITIVE) ) {
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
		enterRule(_localctx, 44, RULE_bool_liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
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
		enterRule(_localctx, 46, RULE_char_liter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284); match(SINGLE_QUOTE);
			setState(285); character();
			setState(286); match(SINGLE_QUOTE);
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
		enterRule(_localctx, 48, RULE_str_liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288); match(DOUBLE_QUOTE);
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUALS) | (1L << SKIP) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << IF) | (1L << THEN) | (1L << ELSE) | (1L << ENDIF) | (1L << WHILE) | (1L << DO) | (1L << DONE) | (1L << BEGIN) | (1L << END) | (1L << IS) | (1L << SEMICOLON) | (1L << NEWPAIR) | (1L << CALL) | (1L << FIRST) | (1L << SECOND) | (1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << PAIR) | (1L << NOT) | (1L << NEGATE) | (1L << LENGTH) | (1L << ORD) | (1L << TO_INT) | (1L << MULTIPLY) | (1L << DIVIDE) | (1L << MOD) | (1L << PLUS) | (1L << MINUS) | (1L << GREATER) | (1L << GREATER_EQUAL) | (1L << LESS) | (1L << LESS_EQUAL) | (1L << EQUAL) | (1L << NOT_EQUAL) | (1L << AND) | (1L << OR) | (1L << UNDERSCORE) | (1L << LOWERCASE_LETTER) | (1L << UPPERCASE_LETTER) | (1L << NEGATIVE) | (1L << POSITIVE) | (1L << TRUE) | (1L << FALSE) | (1L << NUL) | (1L << BACKSPACE) | (1L << TAB) | (1L << NEWLINE) | (1L << FORM_FEED) | (1L << CARRIAGE_RETURN) | (1L << BACKSLASH) | (1L << OPEN_BRACKET))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CLOSE_BRACKET - 64)) | (1L << (COMMA - 64)) | (1L << (NULL - 64)) | (1L << (OPEN_PARENTHESES - 64)) | (1L << (CLOSE_PARENTHESES - 64)) | (1L << (INTEGER - 64)) | (1L << (WHITESPACE - 64)) | (1L << (COMMENT - 64)))) != 0)) {
				{
				{
				setState(289); character();
				}
				}
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(295); match(DOUBLE_QUOTE);
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
		public Escaped_charContext escaped_char() {
			return getRuleContext(Escaped_charContext.class,0);
		}
		public TerminalNode SINGLE_QUOTE() { return getToken(BasicParser.SINGLE_QUOTE, 0); }
		public TerminalNode BACKSLASH() { return getToken(BasicParser.BACKSLASH, 0); }
		public TerminalNode DOUBLE_QUOTE() { return getToken(BasicParser.DOUBLE_QUOTE, 0); }
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
		enterRule(_localctx, 50, RULE_character);
		int _la;
		try {
			setState(300);
			switch (_input.LA(1)) {
			case EQUALS:
			case SKIP:
			case READ:
			case FREE:
			case RETURN:
			case EXIT:
			case PRINT:
			case PRINTLN:
			case IF:
			case THEN:
			case ELSE:
			case ENDIF:
			case WHILE:
			case DO:
			case DONE:
			case BEGIN:
			case END:
			case IS:
			case SEMICOLON:
			case NEWPAIR:
			case CALL:
			case FIRST:
			case SECOND:
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
			case PAIR:
			case NOT:
			case NEGATE:
			case LENGTH:
			case ORD:
			case TO_INT:
			case MULTIPLY:
			case DIVIDE:
			case MOD:
			case PLUS:
			case MINUS:
			case GREATER:
			case GREATER_EQUAL:
			case LESS:
			case LESS_EQUAL:
			case EQUAL:
			case NOT_EQUAL:
			case AND:
			case OR:
			case UNDERSCORE:
			case LOWERCASE_LETTER:
			case UPPERCASE_LETTER:
			case NEGATIVE:
			case POSITIVE:
			case TRUE:
			case FALSE:
			case NUL:
			case BACKSPACE:
			case TAB:
			case NEWLINE:
			case FORM_FEED:
			case CARRIAGE_RETURN:
			case OPEN_BRACKET:
			case CLOSE_BRACKET:
			case COMMA:
			case NULL:
			case OPEN_PARENTHESES:
			case CLOSE_PARENTHESES:
			case INTEGER:
			case WHITESPACE:
			case COMMENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				_la = _input.LA(1);
				if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_QUOTE) | (1L << SINGLE_QUOTE) | (1L << BACKSLASH))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case BACKSLASH:
				enterOuterAlt(_localctx, 2);
				{
				setState(298); match(BACKSLASH);
				setState(299); escaped_char();
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

	public static class Escaped_charContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(BasicParser.NEWLINE, 0); }
		public TerminalNode SINGLE_QUOTE() { return getToken(BasicParser.SINGLE_QUOTE, 0); }
		public TerminalNode BACKSLASH() { return getToken(BasicParser.BACKSLASH, 0); }
		public TerminalNode CARRIAGE_RETURN() { return getToken(BasicParser.CARRIAGE_RETURN, 0); }
		public TerminalNode DOUBLE_QUOTE() { return getToken(BasicParser.DOUBLE_QUOTE, 0); }
		public TerminalNode FORM_FEED() { return getToken(BasicParser.FORM_FEED, 0); }
		public TerminalNode BACKSPACE() { return getToken(BasicParser.BACKSPACE, 0); }
		public TerminalNode TAB() { return getToken(BasicParser.TAB, 0); }
		public TerminalNode NUL() { return getToken(BasicParser.NUL, 0); }
		public Escaped_charContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escaped_char; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitEscaped_char(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Escaped_charContext escaped_char() throws RecognitionException {
		Escaped_charContext _localctx = new Escaped_charContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_escaped_char);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUL) | (1L << BACKSPACE) | (1L << TAB) | (1L << NEWLINE) | (1L << FORM_FEED) | (1L << CARRIAGE_RETURN) | (1L << DOUBLE_QUOTE) | (1L << SINGLE_QUOTE) | (1L << BACKSLASH))) != 0)) ) {
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
		enterRule(_localctx, 54, RULE_array_liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304); match(OPEN_BRACKET);
			setState(313);
			_la = _input.LA(1);
			if (((((_la - 29)) & ~0x3f) == 0 && ((1L << (_la - 29)) & ((1L << (NOT - 29)) | (1L << (NEGATE - 29)) | (1L << (LENGTH - 29)) | (1L << (ORD - 29)) | (1L << (TO_INT - 29)) | (1L << (UNDERSCORE - 29)) | (1L << (LOWERCASE_LETTER - 29)) | (1L << (UPPERCASE_LETTER - 29)) | (1L << (NEGATIVE - 29)) | (1L << (POSITIVE - 29)) | (1L << (TRUE - 29)) | (1L << (FALSE - 29)) | (1L << (DOUBLE_QUOTE - 29)) | (1L << (SINGLE_QUOTE - 29)) | (1L << (NULL - 29)) | (1L << (OPEN_PARENTHESES - 29)) | (1L << (INTEGER - 29)))) != 0)) {
				{
				setState(305); expr(0);
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(306); match(COMMA);
					setState(307); expr(0);
					}
					}
					setState(312);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(315); match(CLOSE_BRACKET);
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
		enterRule(_localctx, 56, RULE_pair_liter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317); match(NULL);
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
		enterRule(_localctx, 58, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319); program();
			setState(320); match(EOF);
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

		case 15: return expr2_sempred((Expr2Context)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr2_sempred(Expr2Context _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return 2 >= _localctx._p;
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return 2 >= _localctx._p;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3I\u0145\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\7"+
		"\2A\n\2\f\2\16\2D\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3M\n\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\7\4W\n\4\f\4\16\4Z\13\4\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\5\6\u0088\n\6\3\6\3\6\3\6\7\6\u008d\n\6\f\6\16\6\u0090\13"+
		"\6\3\7\3\7\3\7\5\7\u0095\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\b\u00a5\n\b\3\b\3\b\5\b\u00a9\n\b\3\t\3\t\3\t\7\t\u00ae"+
		"\n\t\f\t\16\t\u00b1\13\t\3\n\3\n\3\n\3\n\5\n\u00b7\n\n\3\13\3\13\3\13"+
		"\5\13\u00bc\n\13\3\f\3\f\3\r\3\r\5\r\u00c2\n\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\5\17\u00d1\n\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00e2"+
		"\n\20\3\20\3\20\3\20\3\20\7\20\u00e8\n\20\f\20\16\20\u00eb\13\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u00fb\n\21\3\21\3\21\3\21\3\21\7\21\u0101\n\21\f\21\16\21\u0104\13\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\7\24\u010c\n\24\f\24\16\24\u010f\13\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\26\5\26\u0117\n\26\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\32\3\32\7\32\u0125\n\32\f\32\16\32\u0128\13"+
		"\32\3\32\3\32\3\33\3\33\3\33\5\33\u012f\n\33\3\34\3\34\3\35\3\35\3\35"+
		"\3\35\7\35\u0137\n\35\f\35\16\35\u013a\13\35\5\35\u013c\n\35\3\35\3\35"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\2 \2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<\2\13\3\2\32\35\3\2\37#\3\2$\60\3\2\61\63\4"+
		"\2\61\63GG\3\2\64\65\3\2\66\67\3\2>@\3\28@\u015a\2>\3\2\2\2\4H\3\2\2\2"+
		"\6S\3\2\2\2\b[\3\2\2\2\n\u0087\3\2\2\2\f\u0094\3\2\2\2\16\u00a8\3\2\2"+
		"\2\20\u00aa\3\2\2\2\22\u00b6\3\2\2\2\24\u00bb\3\2\2\2\26\u00bd\3\2\2\2"+
		"\30\u00c1\3\2\2\2\32\u00c6\3\2\2\2\34\u00d0\3\2\2\2\36\u00e1\3\2\2\2 "+
		"\u00fa\3\2\2\2\"\u0105\3\2\2\2$\u0107\3\2\2\2&\u0109\3\2\2\2(\u0110\3"+
		"\2\2\2*\u0116\3\2\2\2,\u011a\3\2\2\2.\u011c\3\2\2\2\60\u011e\3\2\2\2\62"+
		"\u0122\3\2\2\2\64\u012e\3\2\2\2\66\u0130\3\2\2\28\u0132\3\2\2\2:\u013f"+
		"\3\2\2\2<\u0141\3\2\2\2>B\7\22\2\2?A\5\4\3\2@?\3\2\2\2AD\3\2\2\2B@\3\2"+
		"\2\2BC\3\2\2\2CE\3\2\2\2DB\3\2\2\2EF\5\n\6\2FG\7\23\2\2G\3\3\2\2\2HI\5"+
		"\24\13\2IJ\5&\24\2JL\7E\2\2KM\5\6\4\2LK\3\2\2\2LM\3\2\2\2MN\3\2\2\2NO"+
		"\7F\2\2OP\7\24\2\2PQ\5\n\6\2QR\7\23\2\2R\5\3\2\2\2SX\5\b\5\2TU\7C\2\2"+
		"UW\5\b\5\2VT\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\7\3\2\2\2ZX\3\2\2"+
		"\2[\\\5\24\13\2\\]\5&\24\2]\t\3\2\2\2^_\b\6\1\2_\u0088\7\4\2\2`a\5\24"+
		"\13\2ab\5&\24\2bc\7\3\2\2cd\5\16\b\2d\u0088\3\2\2\2ef\5\f\7\2fg\7\3\2"+
		"\2gh\5\16\b\2h\u0088\3\2\2\2ij\7\5\2\2j\u0088\5\f\7\2kl\7\6\2\2l\u0088"+
		"\5\36\20\2mn\7\7\2\2n\u0088\5\36\20\2op\7\b\2\2p\u0088\5\36\20\2qr\7\t"+
		"\2\2r\u0088\5\36\20\2st\7\n\2\2t\u0088\5\36\20\2uv\7\13\2\2vw\5\36\20"+
		"\2wx\7\f\2\2xy\5\n\6\2yz\7\r\2\2z{\5\n\6\2{|\7\16\2\2|\u0088\3\2\2\2}"+
		"~\7\17\2\2~\177\5\36\20\2\177\u0080\7\20\2\2\u0080\u0081\5\n\6\2\u0081"+
		"\u0082\7\21\2\2\u0082\u0088\3\2\2\2\u0083\u0084\7\22\2\2\u0084\u0085\5"+
		"\n\6\2\u0085\u0086\7\23\2\2\u0086\u0088\3\2\2\2\u0087^\3\2\2\2\u0087`"+
		"\3\2\2\2\u0087e\3\2\2\2\u0087i\3\2\2\2\u0087k\3\2\2\2\u0087m\3\2\2\2\u0087"+
		"o\3\2\2\2\u0087q\3\2\2\2\u0087s\3\2\2\2\u0087u\3\2\2\2\u0087}\3\2\2\2"+
		"\u0087\u0083\3\2\2\2\u0088\u008e\3\2\2\2\u0089\u008a\6\6\2\3\u008a\u008b"+
		"\7\25\2\2\u008b\u008d\5\n\6\2\u008c\u0089\3\2\2\2\u008d\u0090\3\2\2\2"+
		"\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\13\3\2\2\2\u0090\u008e"+
		"\3\2\2\2\u0091\u0095\5&\24\2\u0092\u0095\5(\25\2\u0093\u0095\5\22\n\2"+
		"\u0094\u0091\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095\r\3"+
		"\2\2\2\u0096\u00a9\5\36\20\2\u0097\u00a9\58\35\2\u0098\u0099\7\26\2\2"+
		"\u0099\u009a\7E\2\2\u009a\u009b\5\36\20\2\u009b\u009c\7C\2\2\u009c\u009d"+
		"\5\36\20\2\u009d\u009e\7F\2\2\u009e\u00a9\3\2\2\2\u009f\u00a9\5\22\n\2"+
		"\u00a0\u00a1\7\27\2\2\u00a1\u00a2\5&\24\2\u00a2\u00a4\7E\2\2\u00a3\u00a5"+
		"\5\20\t\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2"+
		"\u00a6\u00a7\7F\2\2\u00a7\u00a9\3\2\2\2\u00a8\u0096\3\2\2\2\u00a8\u0097"+
		"\3\2\2\2\u00a8\u0098\3\2\2\2\u00a8\u009f\3\2\2\2\u00a8\u00a0\3\2\2\2\u00a9"+
		"\17\3\2\2\2\u00aa\u00af\5\36\20\2\u00ab\u00ac\7C\2\2\u00ac\u00ae\5\36"+
		"\20\2\u00ad\u00ab\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af"+
		"\u00b0\3\2\2\2\u00b0\21\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b3\7\30\2"+
		"\2\u00b3\u00b7\5\36\20\2\u00b4\u00b5\7\31\2\2\u00b5\u00b7\5\36\20\2\u00b6"+
		"\u00b2\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\23\3\2\2\2\u00b8\u00bc\5\26\f"+
		"\2\u00b9\u00bc\5\30\r\2\u00ba\u00bc\5\32\16\2\u00bb\u00b8\3\2\2\2\u00bb"+
		"\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\25\3\2\2\2\u00bd\u00be\t\2\2"+
		"\2\u00be\27\3\2\2\2\u00bf\u00c2\5\26\f\2\u00c0\u00c2\5\32\16\2\u00c1\u00bf"+
		"\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\7A\2\2\u00c4"+
		"\u00c5\7B\2\2\u00c5\31\3\2\2\2\u00c6\u00c7\7\36\2\2\u00c7\u00c8\7E\2\2"+
		"\u00c8\u00c9\5\34\17\2\u00c9\u00ca\7C\2\2\u00ca\u00cb\5\34\17\2\u00cb"+
		"\u00cc\7F\2\2\u00cc\33\3\2\2\2\u00cd\u00d1\5\26\f\2\u00ce\u00d1\5\30\r"+
		"\2\u00cf\u00d1\7\36\2\2\u00d0\u00cd\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0"+
		"\u00cf\3\2\2\2\u00d1\35\3\2\2\2\u00d2\u00d3\b\20\1\2\u00d3\u00d4\5\"\22"+
		"\2\u00d4\u00d5\5\36\20\2\u00d5\u00e2\3\2\2\2\u00d6\u00e2\5*\26\2\u00d7"+
		"\u00e2\5.\30\2\u00d8\u00e2\5\60\31\2\u00d9\u00e2\5\62\32\2\u00da\u00e2"+
		"\5:\36\2\u00db\u00e2\5&\24\2\u00dc\u00e2\5(\25\2\u00dd\u00de\7E\2\2\u00de"+
		"\u00df\5\36\20\2\u00df\u00e0\7F\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00d2\3"+
		"\2\2\2\u00e1\u00d6\3\2\2\2\u00e1\u00d7\3\2\2\2\u00e1\u00d8\3\2\2\2\u00e1"+
		"\u00d9\3\2\2\2\u00e1\u00da\3\2\2\2\u00e1\u00db\3\2\2\2\u00e1\u00dc\3\2"+
		"\2\2\u00e1\u00dd\3\2\2\2\u00e2\u00e9\3\2\2\2\u00e3\u00e4\6\20\3\3\u00e4"+
		"\u00e5\5$\23\2\u00e5\u00e6\5\36\20\2\u00e6\u00e8\3\2\2\2\u00e7\u00e3\3"+
		"\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\37\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ed\b\21\1\2\u00ed\u00ee\5\"\22"+
		"\2\u00ee\u00ef\5 \21\2\u00ef\u00fb\3\2\2\2\u00f0\u00fb\5*\26\2\u00f1\u00fb"+
		"\5.\30\2\u00f2\u00fb\5\60\31\2\u00f3\u00fb\5\62\32\2\u00f4\u00fb\5:\36"+
		"\2\u00f5\u00fb\5&\24\2\u00f6\u00f7\7E\2\2\u00f7\u00f8\5 \21\2\u00f8\u00f9"+
		"\7F\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00ec\3\2\2\2\u00fa\u00f0\3\2\2\2\u00fa"+
		"\u00f1\3\2\2\2\u00fa\u00f2\3\2\2\2\u00fa\u00f3\3\2\2\2\u00fa\u00f4\3\2"+
		"\2\2\u00fa\u00f5\3\2\2\2\u00fa\u00f6\3\2\2\2\u00fb\u0102\3\2\2\2\u00fc"+
		"\u00fd\6\21\4\3\u00fd\u00fe\5$\23\2\u00fe\u00ff\5 \21\2\u00ff\u0101\3"+
		"\2\2\2\u0100\u00fc\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103!\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0106\t\3\2\2"+
		"\u0106#\3\2\2\2\u0107\u0108\t\4\2\2\u0108%\3\2\2\2\u0109\u010d\t\5\2\2"+
		"\u010a\u010c\t\6\2\2\u010b\u010a\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b"+
		"\3\2\2\2\u010d\u010e\3\2\2\2\u010e\'\3\2\2\2\u010f\u010d\3\2\2\2\u0110"+
		"\u0111\5 \21\2\u0111\u0112\7A\2\2\u0112\u0113\5 \21\2\u0113\u0114\7B\2"+
		"\2\u0114)\3\2\2\2\u0115\u0117\5,\27\2\u0116\u0115\3\2\2\2\u0116\u0117"+
		"\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\7G\2\2\u0119+\3\2\2\2\u011a\u011b"+
		"\t\7\2\2\u011b-\3\2\2\2\u011c\u011d\t\b\2\2\u011d/\3\2\2\2\u011e\u011f"+
		"\7?\2\2\u011f\u0120\5\64\33\2\u0120\u0121\7?\2\2\u0121\61\3\2\2\2\u0122"+
		"\u0126\7>\2\2\u0123\u0125\5\64\33\2\u0124\u0123\3\2\2\2\u0125\u0128\3"+
		"\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0129\3\2\2\2\u0128"+
		"\u0126\3\2\2\2\u0129\u012a\7>\2\2\u012a\63\3\2\2\2\u012b\u012f\n\t\2\2"+
		"\u012c\u012d\7@\2\2\u012d\u012f\5\66\34\2\u012e\u012b\3\2\2\2\u012e\u012c"+
		"\3\2\2\2\u012f\65\3\2\2\2\u0130\u0131\t\n\2\2\u0131\67\3\2\2\2\u0132\u013b"+
		"\7A\2\2\u0133\u0138\5\36\20\2\u0134\u0135\7C\2\2\u0135\u0137\5\36\20\2"+
		"\u0136\u0134\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139"+
		"\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u0133\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e\7B\2\2\u013e9\3\2\2\2\u013f"+
		"\u0140\7D\2\2\u0140;\3\2\2\2\u0141\u0142\5\2\2\2\u0142\u0143\7\2\2\3\u0143"+
		"=\3\2\2\2\31BLX\u0087\u008e\u0094\u00a4\u00a8\u00af\u00b6\u00bb\u00c1"+
		"\u00d0\u00e1\u00e9\u00fa\u0102\u010d\u0116\u0126\u012e\u0138\u013b";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}