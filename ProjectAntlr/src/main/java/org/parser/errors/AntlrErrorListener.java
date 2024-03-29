package org.parser.errors;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.List;
import java.util.ArrayList;

public class AntlrErrorListener implements ANTLRErrorListener {

    private final List<String> errors = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        errors.add("[SYNTAX ERROR]\t" + "line " + line + ":" + charPositionInLine + " " + msg);
    }

    @Override
    public void reportAmbiguity(org.antlr.v4.runtime.Parser recognizer, org.antlr.v4.runtime.dfa.DFA dfa, int startIndex, int stopIndex, boolean exact, java.util.BitSet ambigAlts, org.antlr.v4.runtime.atn.ATNConfigSet configs) {
        errors.add("[AMBIGUITY]\t" + "line " + recognizer.getContext().start.getLine() + ":" + recognizer.getContext().start.getCharPositionInLine() + " " + "Ambiguity found");
    }

    @Override
    public void reportAttemptingFullContext(org.antlr.v4.runtime.Parser recognizer, org.antlr.v4.runtime.dfa.DFA dfa, int startIndex, int stopIndex, java.util.BitSet conflictingAlts, org.antlr.v4.runtime.atn.ATNConfigSet configs) {
        errors.add("[FULL CONTEXT]\t" + "line " + recognizer.getContext().start.getLine() + ":" + recognizer.getContext().start.getCharPositionInLine() + " " + "Attempting full context");
    }

    @Override
    public void reportContextSensitivity(org.antlr.v4.runtime.Parser recognizer, org.antlr.v4.runtime.dfa.DFA dfa, int startIndex, int stopIndex, int prediction, org.antlr.v4.runtime.atn.ATNConfigSet configs) {
        errors.add("[CONTEXT SENSITIVITY]\t" + "line " + recognizer.getContext().start.getLine() + ":" + recognizer.getContext().start.getCharPositionInLine() + " " + "Context sensitivity found");
    }

    public List<String> getErrors() {
        return errors;
    }

}
