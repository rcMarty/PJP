// Generated from /home/rc_marty/6_Semestr/PJP/PjojectAntlr/src/main/antlr4/grammars/Lab7Expr.g4 by ANTLR 4.13.1
package org.antlr4.Lab7;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class Lab7ExprLexer extends Lexer {
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, ID = 8, INT = 9, OCT = 10,
            HEXA = 11, WS = 12;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\u0004\u0000\fI\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001" +
                    "\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004" +
                    "\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007" +
                    "\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b" +
                    "\u0007\u000b\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002" +
                    "\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005" +
                    "\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0004\u0007)\b\u0007" +
                    "\u000b\u0007\f\u0007*\u0001\b\u0001\b\u0005\b/\b\b\n\b\f\b2\t\b\u0001" +
                    "\t\u0001\t\u0005\t6\b\t\n\t\f\t9\t\t\u0001\n\u0001\n\u0001\n\u0001\n\u0004" +
                    "\n?\b\n\u000b\n\f\n@\u0001\u000b\u0004\u000bD\b\u000b\u000b\u000b\f\u000b" +
                    "E\u0001\u000b\u0001\u000b\u0000\u0000\f\u0001\u0001\u0003\u0002\u0005" +
                    "\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n" +
                    "\u0015\u000b\u0017\f\u0001\u0000\u0006\u0002\u0000AZaz\u0001\u000019\u0001" +
                    "\u000009\u0001\u000007\u0003\u000009AFaf\u0003\u0000\t\n\r\r  M\u0000" +
                    "\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000" +
                    "\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000" +
                    "\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r" +
                    "\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011" +
                    "\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015" +
                    "\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0001\u0019" +
                    "\u0001\u0000\u0000\u0000\u0003\u001b\u0001\u0000\u0000\u0000\u0005\u001d" +
                    "\u0001\u0000\u0000\u0000\u0007\u001f\u0001\u0000\u0000\u0000\t!\u0001" +
                    "\u0000\u0000\u0000\u000b#\u0001\u0000\u0000\u0000\r%\u0001\u0000\u0000" +
                    "\u0000\u000f(\u0001\u0000\u0000\u0000\u0011,\u0001\u0000\u0000\u0000\u0013" +
                    "3\u0001\u0000\u0000\u0000\u0015:\u0001\u0000\u0000\u0000\u0017C\u0001" +
                    "\u0000\u0000\u0000\u0019\u001a\u0005;\u0000\u0000\u001a\u0002\u0001\u0000" +
                    "\u0000\u0000\u001b\u001c\u0005*\u0000\u0000\u001c\u0004\u0001\u0000\u0000" +
                    "\u0000\u001d\u001e\u0005/\u0000\u0000\u001e\u0006\u0001\u0000\u0000\u0000" +
                    "\u001f \u0005+\u0000\u0000 \b\u0001\u0000\u0000\u0000!\"\u0005-\u0000" +
                    "\u0000\"\n\u0001\u0000\u0000\u0000#$\u0005(\u0000\u0000$\f\u0001\u0000" +
                    "\u0000\u0000%&\u0005)\u0000\u0000&\u000e\u0001\u0000\u0000\u0000\')\u0007" +
                    "\u0000\u0000\u0000(\'\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000" +
                    "*(\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+\u0010\u0001\u0000" +
                    "\u0000\u0000,0\u0007\u0001\u0000\u0000-/\u0007\u0002\u0000\u0000.-\u0001" +
                    "\u0000\u0000\u0000/2\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u0000" +
                    "01\u0001\u0000\u0000\u00001\u0012\u0001\u0000\u0000\u000020\u0001\u0000" +
                    "\u0000\u000037\u00050\u0000\u000046\u0007\u0003\u0000\u000054\u0001\u0000" +
                    "\u0000\u000069\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000078\u0001" +
                    "\u0000\u0000\u00008\u0014\u0001\u0000\u0000\u000097\u0001\u0000\u0000" +
                    "\u0000:;\u00050\u0000\u0000;<\u0005x\u0000\u0000<>\u0001\u0000\u0000\u0000" +
                    "=?\u0007\u0004\u0000\u0000>=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000" +
                    "\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000A\u0016\u0001" +
                    "\u0000\u0000\u0000BD\u0007\u0005\u0000\u0000CB\u0001\u0000\u0000\u0000" +
                    "DE\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000" +
                    "\u0000FG\u0001\u0000\u0000\u0000GH\u0006\u000b\u0000\u0000H\u0018\u0001" +
                    "\u0000\u0000\u0000\u0006\u0000*07@E\u0001\u0006\u0000\u0000";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };
    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    static {
        RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
    }

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

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public Lab7ExprLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private static String[] makeRuleNames() {
        return new String[]{
                "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "ID", "INT",
                "OCT", "HEXA", "WS"
        };
    }

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "';'", "'*'", "'/'", "'+'", "'-'", "'('", "')'"
        };
    }

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, "ID", "INT", "OCT", "HEXA",
                "WS"
        };
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

    @Override
    public String getGrammarFileName() {
        return "Lab7Expr.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }
}