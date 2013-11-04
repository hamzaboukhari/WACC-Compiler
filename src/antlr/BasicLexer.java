// Generated from ./BasicLexer.g4 by ANTLR 4.1

package antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BasicLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EQUALS=1, SKIP=2, READ=3, FREE=4, RETURN=5, EXIT=6, PRINT=7, PRINTLN=8, 
		IF=9, THEN=10, ELSE=11, ENDIF=12, WHILE=13, DO=14, DONE=15, BEGIN=16, 
		END=17, IS=18, SEMICOLON=19, NEWPAIR=20, CALL=21, FIRST=22, SECOND=23, 
		INT=24, BOOL=25, CHAR=26, STRING=27, PAIR=28, NOT=29, LENGTH=30, ORD=31, 
		TO_INT=32, MULTIPLY=33, DIVIDE=34, MOD=35, PLUS=36, MINUS=37, GREATER=38, 
		GREATER_EQUAL=39, LESS=40, LESS_EQUAL=41, EQUAL=42, NOT_EQUAL=43, AND=44, 
		OR=45, UNDERSCORE=46, TRUE=47, FALSE=48, DOUBLE_QUOTE=49, SINGLE_QUOTE=50, 
		BACKSLASH=51, ESCAPED_CHAR=52, OPEN_BRACKET=53, CLOSE_BRACKET=54, COMMA=55, 
		NULL=56, OPEN_PARENTHESES=57, CLOSE_PARENTHESES=58, INTEGER=59, IDENT=60, 
		WHITESPACE=61, COMMENT=62, EVERYTHING=63;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'='", "'skip'", "'read'", "'free'", "'return'", "'exit'", "'print'", 
		"'println'", "'if'", "'then'", "'else'", "'fi'", "'while'", "'do'", "'done'", 
		"'begin'", "'end'", "'is'", "';'", "'newpair'", "'call'", "'fst'", "'snd'", 
		"'int'", "'bool'", "'char'", "'string'", "'pair'", "'!'", "'len'", "'ord'", 
		"'toInt'", "'*'", "'/'", "'%'", "'+'", "'-'", "'>'", "'>='", "'<'", "'<='", 
		"'=='", "'!='", "'&&'", "'||'", "'_'", "'true'", "'false'", "'\"'", "'''", 
		"'\\'", "ESCAPED_CHAR", "'['", "']'", "','", "'null'", "'('", "')'", "INTEGER", 
		"IDENT", "WHITESPACE", "COMMENT", "EVERYTHING"
	};
	public static final String[] ruleNames = {
		"EQUALS", "SKIP", "READ", "FREE", "RETURN", "EXIT", "PRINT", "PRINTLN", 
		"IF", "THEN", "ELSE", "ENDIF", "WHILE", "DO", "DONE", "BEGIN", "END", 
		"IS", "SEMICOLON", "NEWPAIR", "CALL", "FIRST", "SECOND", "INT", "BOOL", 
		"CHAR", "STRING", "PAIR", "NOT", "LENGTH", "ORD", "TO_INT", "MULTIPLY", 
		"DIVIDE", "MOD", "PLUS", "MINUS", "GREATER", "GREATER_EQUAL", "LESS", 
		"LESS_EQUAL", "EQUAL", "NOT_EQUAL", "AND", "OR", "UNDERSCORE", "TRUE", 
		"FALSE", "NUL", "BACKSPACE", "TAB", "FORM_FEED", "NEWLINE", "CARRIAGE_RETURN", 
		"DOUBLE_QUOTE", "SINGLE_QUOTE", "BACKSLASH", "ESCAPED_CHAR", "OPEN_BRACKET", 
		"CLOSE_BRACKET", "COMMA", "NULL", "OPEN_PARENTHESES", "CLOSE_PARENTHESES", 
		"DIGIT", "LOWERCASE", "UPPERCASE", "INTEGER", "IDENT", "WHITESPACE", "COMMENT", 
		"EVERYTHING"
	};


	public BasicLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BasicLexer.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 69: WHITESPACE_action((RuleContext)_localctx, actionIndex); break;

		case 70: COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WHITESPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2A\u01ae\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3#\3#"+
		"\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,\3"+
		"-\3-\3-\3.\3.\3.\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3"+
		"\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\3"+
		"8\38\39\39\3:\3:\3;\3;\3;\3;\3;\3;\3;\3;\3;\5;\u0173\n;\3<\3<\3=\3=\3"+
		">\3>\3?\3?\3?\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\6E\u018b\nE\rE\16"+
		"E\u018c\3F\3F\3F\5F\u0192\nF\3F\3F\3F\3F\7F\u0198\nF\fF\16F\u019b\13F"+
		"\3G\6G\u019e\nG\rG\16G\u019f\3G\3G\3H\3H\7H\u01a6\nH\fH\16H\u01a9\13H"+
		"\3H\3H\3I\3I\2J\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23"+
		"\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1"+
		"\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1"+
		";\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1["+
		"/\1]\60\1_\61\1a\62\1c\2\1e\2\1g\2\1i\2\1k\2\1m\2\1o\63\1q\64\1s\65\1"+
		"u\66\1w\67\1y8\1{9\1}:\1\177;\1\u0081<\1\u0083\2\1\u0085\2\1\u0087\2\1"+
		"\u0089=\1\u008b>\1\u008d?\2\u008f@\3\u0091A\1\3\2\4\5\2\13\f\17\17\"\""+
		"\4\2\f\f\17\17\u01b4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q"+
		"\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2"+
		"\2\2\2_\3\2\2\2\2a\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2"+
		"\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2"+
		"\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2"+
		"\u0091\3\2\2\2\3\u0093\3\2\2\2\5\u0095\3\2\2\2\7\u009a\3\2\2\2\t\u009f"+
		"\3\2\2\2\13\u00a4\3\2\2\2\r\u00ab\3\2\2\2\17\u00b0\3\2\2\2\21\u00b6\3"+
		"\2\2\2\23\u00be\3\2\2\2\25\u00c1\3\2\2\2\27\u00c6\3\2\2\2\31\u00cb\3\2"+
		"\2\2\33\u00ce\3\2\2\2\35\u00d4\3\2\2\2\37\u00d7\3\2\2\2!\u00dc\3\2\2\2"+
		"#\u00e2\3\2\2\2%\u00e6\3\2\2\2\'\u00e9\3\2\2\2)\u00eb\3\2\2\2+\u00f3\3"+
		"\2\2\2-\u00f8\3\2\2\2/\u00fc\3\2\2\2\61\u0100\3\2\2\2\63\u0104\3\2\2\2"+
		"\65\u0109\3\2\2\2\67\u010e\3\2\2\29\u0115\3\2\2\2;\u011a\3\2\2\2=\u011c"+
		"\3\2\2\2?\u0120\3\2\2\2A\u0124\3\2\2\2C\u012a\3\2\2\2E\u012c\3\2\2\2G"+
		"\u012e\3\2\2\2I\u0130\3\2\2\2K\u0132\3\2\2\2M\u0134\3\2\2\2O\u0136\3\2"+
		"\2\2Q\u0139\3\2\2\2S\u013b\3\2\2\2U\u013e\3\2\2\2W\u0141\3\2\2\2Y\u0144"+
		"\3\2\2\2[\u0147\3\2\2\2]\u014a\3\2\2\2_\u014c\3\2\2\2a\u0151\3\2\2\2c"+
		"\u0157\3\2\2\2e\u0159\3\2\2\2g\u015b\3\2\2\2i\u015d\3\2\2\2k\u015f\3\2"+
		"\2\2m\u0161\3\2\2\2o\u0163\3\2\2\2q\u0165\3\2\2\2s\u0167\3\2\2\2u\u0169"+
		"\3\2\2\2w\u0174\3\2\2\2y\u0176\3\2\2\2{\u0178\3\2\2\2}\u017a\3\2\2\2\177"+
		"\u017f\3\2\2\2\u0081\u0181\3\2\2\2\u0083\u0183\3\2\2\2\u0085\u0185\3\2"+
		"\2\2\u0087\u0187\3\2\2\2\u0089\u018a\3\2\2\2\u008b\u0191\3\2\2\2\u008d"+
		"\u019d\3\2\2\2\u008f\u01a3\3\2\2\2\u0091\u01ac\3\2\2\2\u0093\u0094\7?"+
		"\2\2\u0094\4\3\2\2\2\u0095\u0096\7u\2\2\u0096\u0097\7m\2\2\u0097\u0098"+
		"\7k\2\2\u0098\u0099\7r\2\2\u0099\6\3\2\2\2\u009a\u009b\7t\2\2\u009b\u009c"+
		"\7g\2\2\u009c\u009d\7c\2\2\u009d\u009e\7f\2\2\u009e\b\3\2\2\2\u009f\u00a0"+
		"\7h\2\2\u00a0\u00a1\7t\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7g\2\2\u00a3"+
		"\n\3\2\2\2\u00a4\u00a5\7t\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\7v\2\2\u00a7"+
		"\u00a8\7w\2\2\u00a8\u00a9\7t\2\2\u00a9\u00aa\7p\2\2\u00aa\f\3\2\2\2\u00ab"+
		"\u00ac\7g\2\2\u00ac\u00ad\7z\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7v\2\2"+
		"\u00af\16\3\2\2\2\u00b0\u00b1\7r\2\2\u00b1\u00b2\7t\2\2\u00b2\u00b3\7"+
		"k\2\2\u00b3\u00b4\7p\2\2\u00b4\u00b5\7v\2\2\u00b5\20\3\2\2\2\u00b6\u00b7"+
		"\7r\2\2\u00b7\u00b8\7t\2\2\u00b8\u00b9\7k\2\2\u00b9\u00ba\7p\2\2\u00ba"+
		"\u00bb\7v\2\2\u00bb\u00bc\7n\2\2\u00bc\u00bd\7p\2\2\u00bd\22\3\2\2\2\u00be"+
		"\u00bf\7k\2\2\u00bf\u00c0\7h\2\2\u00c0\24\3\2\2\2\u00c1\u00c2\7v\2\2\u00c2"+
		"\u00c3\7j\2\2\u00c3\u00c4\7g\2\2\u00c4\u00c5\7p\2\2\u00c5\26\3\2\2\2\u00c6"+
		"\u00c7\7g\2\2\u00c7\u00c8\7n\2\2\u00c8\u00c9\7u\2\2\u00c9\u00ca\7g\2\2"+
		"\u00ca\30\3\2\2\2\u00cb\u00cc\7h\2\2\u00cc\u00cd\7k\2\2\u00cd\32\3\2\2"+
		"\2\u00ce\u00cf\7y\2\2\u00cf\u00d0\7j\2\2\u00d0\u00d1\7k\2\2\u00d1\u00d2"+
		"\7n\2\2\u00d2\u00d3\7g\2\2\u00d3\34\3\2\2\2\u00d4\u00d5\7f\2\2\u00d5\u00d6"+
		"\7q\2\2\u00d6\36\3\2\2\2\u00d7\u00d8\7f\2\2\u00d8\u00d9\7q\2\2\u00d9\u00da"+
		"\7p\2\2\u00da\u00db\7g\2\2\u00db \3\2\2\2\u00dc\u00dd\7d\2\2\u00dd\u00de"+
		"\7g\2\2\u00de\u00df\7i\2\2\u00df\u00e0\7k\2\2\u00e0\u00e1\7p\2\2\u00e1"+
		"\"\3\2\2\2\u00e2\u00e3\7g\2\2\u00e3\u00e4\7p\2\2\u00e4\u00e5\7f\2\2\u00e5"+
		"$\3\2\2\2\u00e6\u00e7\7k\2\2\u00e7\u00e8\7u\2\2\u00e8&\3\2\2\2\u00e9\u00ea"+
		"\7=\2\2\u00ea(\3\2\2\2\u00eb\u00ec\7p\2\2\u00ec\u00ed\7g\2\2\u00ed\u00ee"+
		"\7y\2\2\u00ee\u00ef\7r\2\2\u00ef\u00f0\7c\2\2\u00f0\u00f1\7k\2\2\u00f1"+
		"\u00f2\7t\2\2\u00f2*\3\2\2\2\u00f3\u00f4\7e\2\2\u00f4\u00f5\7c\2\2\u00f5"+
		"\u00f6\7n\2\2\u00f6\u00f7\7n\2\2\u00f7,\3\2\2\2\u00f8\u00f9\7h\2\2\u00f9"+
		"\u00fa\7u\2\2\u00fa\u00fb\7v\2\2\u00fb.\3\2\2\2\u00fc\u00fd\7u\2\2\u00fd"+
		"\u00fe\7p\2\2\u00fe\u00ff\7f\2\2\u00ff\60\3\2\2\2\u0100\u0101\7k\2\2\u0101"+
		"\u0102\7p\2\2\u0102\u0103\7v\2\2\u0103\62\3\2\2\2\u0104\u0105\7d\2\2\u0105"+
		"\u0106\7q\2\2\u0106\u0107\7q\2\2\u0107\u0108\7n\2\2\u0108\64\3\2\2\2\u0109"+
		"\u010a\7e\2\2\u010a\u010b\7j\2\2\u010b\u010c\7c\2\2\u010c\u010d\7t\2\2"+
		"\u010d\66\3\2\2\2\u010e\u010f\7u\2\2\u010f\u0110\7v\2\2\u0110\u0111\7"+
		"t\2\2\u0111\u0112\7k\2\2\u0112\u0113\7p\2\2\u0113\u0114\7i\2\2\u01148"+
		"\3\2\2\2\u0115\u0116\7r\2\2\u0116\u0117\7c\2\2\u0117\u0118\7k\2\2\u0118"+
		"\u0119\7t\2\2\u0119:\3\2\2\2\u011a\u011b\7#\2\2\u011b<\3\2\2\2\u011c\u011d"+
		"\7n\2\2\u011d\u011e\7g\2\2\u011e\u011f\7p\2\2\u011f>\3\2\2\2\u0120\u0121"+
		"\7q\2\2\u0121\u0122\7t\2\2\u0122\u0123\7f\2\2\u0123@\3\2\2\2\u0124\u0125"+
		"\7v\2\2\u0125\u0126\7q\2\2\u0126\u0127\7K\2\2\u0127\u0128\7p\2\2\u0128"+
		"\u0129\7v\2\2\u0129B\3\2\2\2\u012a\u012b\7,\2\2\u012bD\3\2\2\2\u012c\u012d"+
		"\7\61\2\2\u012dF\3\2\2\2\u012e\u012f\7\'\2\2\u012fH\3\2\2\2\u0130\u0131"+
		"\7-\2\2\u0131J\3\2\2\2\u0132\u0133\7/\2\2\u0133L\3\2\2\2\u0134\u0135\7"+
		"@\2\2\u0135N\3\2\2\2\u0136\u0137\7@\2\2\u0137\u0138\7?\2\2\u0138P\3\2"+
		"\2\2\u0139\u013a\7>\2\2\u013aR\3\2\2\2\u013b\u013c\7>\2\2\u013c\u013d"+
		"\7?\2\2\u013dT\3\2\2\2\u013e\u013f\7?\2\2\u013f\u0140\7?\2\2\u0140V\3"+
		"\2\2\2\u0141\u0142\7#\2\2\u0142\u0143\7?\2\2\u0143X\3\2\2\2\u0144\u0145"+
		"\7(\2\2\u0145\u0146\7(\2\2\u0146Z\3\2\2\2\u0147\u0148\7~\2\2\u0148\u0149"+
		"\7~\2\2\u0149\\\3\2\2\2\u014a\u014b\7a\2\2\u014b^\3\2\2\2\u014c\u014d"+
		"\7v\2\2\u014d\u014e\7t\2\2\u014e\u014f\7w\2\2\u014f\u0150\7g\2\2\u0150"+
		"`\3\2\2\2\u0151\u0152\7h\2\2\u0152\u0153\7c\2\2\u0153\u0154\7n\2\2\u0154"+
		"\u0155\7u\2\2\u0155\u0156\7g\2\2\u0156b\3\2\2\2\u0157\u0158\7\62\2\2\u0158"+
		"d\3\2\2\2\u0159\u015a\7d\2\2\u015af\3\2\2\2\u015b\u015c\7v\2\2\u015ch"+
		"\3\2\2\2\u015d\u015e\7h\2\2\u015ej\3\2\2\2\u015f\u0160\7p\2\2\u0160l\3"+
		"\2\2\2\u0161\u0162\7t\2\2\u0162n\3\2\2\2\u0163\u0164\7$\2\2\u0164p\3\2"+
		"\2\2\u0165\u0166\7)\2\2\u0166r\3\2\2\2\u0167\u0168\7^\2\2\u0168t\3\2\2"+
		"\2\u0169\u0172\5s:\2\u016a\u0173\5c\62\2\u016b\u0173\5e\63\2\u016c\u0173"+
		"\5g\64\2\u016d\u0173\5i\65\2\u016e\u0173\5m\67\2\u016f\u0173\5q9\2\u0170"+
		"\u0173\5o8\2\u0171\u0173\5s:\2\u0172\u016a\3\2\2\2\u0172\u016b\3\2\2\2"+
		"\u0172\u016c\3\2\2\2\u0172\u016d\3\2\2\2\u0172\u016e\3\2\2\2\u0172\u016f"+
		"\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0171\3\2\2\2\u0173v\3\2\2\2\u0174"+
		"\u0175\7]\2\2\u0175x\3\2\2\2\u0176\u0177\7_\2\2\u0177z\3\2\2\2\u0178\u0179"+
		"\7.\2\2\u0179|\3\2\2\2\u017a\u017b\7p\2\2\u017b\u017c\7w\2\2\u017c\u017d"+
		"\7n\2\2\u017d\u017e\7n\2\2\u017e~\3\2\2\2\u017f\u0180\7*\2\2\u0180\u0080"+
		"\3\2\2\2\u0181\u0182\7+\2\2\u0182\u0082\3\2\2\2\u0183\u0184\4\62;\2\u0184"+
		"\u0084\3\2\2\2\u0185\u0186\4c|\2\u0186\u0086\3\2\2\2\u0187\u0188\4C\\"+
		"\2\u0188\u0088\3\2\2\2\u0189\u018b\5\u0083B\2\u018a\u0189\3\2\2\2\u018b"+
		"\u018c\3\2\2\2\u018c\u018a\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u008a\3\2"+
		"\2\2\u018e\u0192\5]/\2\u018f\u0192\5\u0085C\2\u0190\u0192\5\u0087D\2\u0191"+
		"\u018e\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0190\3\2\2\2\u0192\u0199\3\2"+
		"\2\2\u0193\u0198\5]/\2\u0194\u0198\5\u0085C\2\u0195\u0198\5\u0087D\2\u0196"+
		"\u0198\5\u0083B\2\u0197\u0193\3\2\2\2\u0197\u0194\3\2\2\2\u0197\u0195"+
		"\3\2\2\2\u0197\u0196\3\2\2\2\u0198\u019b\3\2\2\2\u0199\u0197\3\2\2\2\u0199"+
		"\u019a\3\2\2\2\u019a\u008c\3\2\2\2\u019b\u0199\3\2\2\2\u019c\u019e\t\2"+
		"\2\2\u019d\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u019d\3\2\2\2\u019f"+
		"\u01a0\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a2\bG\2\2\u01a2\u008e\3\2"+
		"\2\2\u01a3\u01a7\7%\2\2\u01a4\u01a6\n\3\2\2\u01a5\u01a4\3\2\2\2\u01a6"+
		"\u01a9\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01aa\3\2"+
		"\2\2\u01a9\u01a7\3\2\2\2\u01aa\u01ab\bH\3\2\u01ab\u0090\3\2\2\2\u01ac"+
		"\u01ad\n\3\2\2\u01ad\u0092\3\2\2\2\n\2\u0172\u018c\u0191\u0197\u0199\u019f"+
		"\u01a7";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}