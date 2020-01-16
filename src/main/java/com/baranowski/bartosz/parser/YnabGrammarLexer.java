// Generated from C:/Users/BRITENET/Desktop/YnabParser/src/main/java/com/baranowski/bartosz/parser\YnabGrammar.g4 by ANTLR 4.7.2
package com.baranowski.bartosz.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class YnabGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, DATE=2, STRING=3, CURRENCY=4, SINGLE_STRING=5, NEWLINE=6, COLON=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "DATE", "STRING", "CURRENCY", "SINGLE_STRING", "NEWLINE", "COLON"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "DATE", "STRING", "CURRENCY", "SINGLE_STRING", "NEWLINE", 
			"COLON"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public YnabGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "YnabGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\tP\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\5\2\23\n\2\3\2\6\2"+
		"\26\n\2\r\2\16\2\27\3\2\3\2\6\2\34\n\2\r\2\16\2\35\5\2 \n\2\3\3\7\3#\n"+
		"\3\f\3\16\3&\13\3\3\3\3\3\7\3*\n\3\f\3\16\3-\13\3\3\3\3\3\7\3\61\n\3\f"+
		"\3\16\3\64\13\3\3\4\3\4\7\48\n\4\f\4\16\4;\13\4\3\4\3\4\3\5\6\5@\n\5\r"+
		"\5\16\5A\3\6\3\6\7\6F\n\6\f\6\16\6I\13\6\3\6\3\6\3\7\3\7\3\b\3\b\49G\2"+
		"\t\3\3\5\4\7\5\t\6\13\7\r\b\17\t\3\2\5\3\2\62;\3\2C\\\4\2\f\f\17\17\2"+
		"Y\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\3\22\3\2\2\2\5$\3\2\2\2\7\65\3\2\2\2\t?\3\2\2\2\13C"+
		"\3\2\2\2\rL\3\2\2\2\17N\3\2\2\2\21\23\7/\2\2\22\21\3\2\2\2\22\23\3\2\2"+
		"\2\23\25\3\2\2\2\24\26\t\2\2\2\25\24\3\2\2\2\26\27\3\2\2\2\27\25\3\2\2"+
		"\2\27\30\3\2\2\2\30\37\3\2\2\2\31\33\7.\2\2\32\34\t\2\2\2\33\32\3\2\2"+
		"\2\34\35\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36 \3\2\2\2\37\31\3\2\2\2"+
		"\37 \3\2\2\2 \4\3\2\2\2!#\5\3\2\2\"!\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3"+
		"\2\2\2%\'\3\2\2\2&$\3\2\2\2\'+\7/\2\2(*\5\3\2\2)(\3\2\2\2*-\3\2\2\2+)"+
		"\3\2\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2.\62\7/\2\2/\61\5\3\2\2\60/\3\2"+
		"\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\6\3\2\2\2\64\62\3\2"+
		"\2\2\659\7$\2\2\668\13\2\2\2\67\66\3\2\2\28;\3\2\2\29:\3\2\2\29\67\3\2"+
		"\2\2:<\3\2\2\2;9\3\2\2\2<=\7$\2\2=\b\3\2\2\2>@\t\3\2\2?>\3\2\2\2@A\3\2"+
		"\2\2A?\3\2\2\2AB\3\2\2\2B\n\3\2\2\2CG\7)\2\2DF\13\2\2\2ED\3\2\2\2FI\3"+
		"\2\2\2GH\3\2\2\2GE\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\7)\2\2K\f\3\2\2\2LM\t"+
		"\4\2\2M\16\3\2\2\2NO\7=\2\2O\20\3\2\2\2\r\2\22\27\35\37$+\629AG\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}