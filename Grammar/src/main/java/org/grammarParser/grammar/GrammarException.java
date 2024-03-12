package org.grammarParser.grammar;

import lombok.Getter;

@Getter
public class GrammarException extends Exception {

    private final int lineNumber;

    public GrammarException(String message, int lineNumber) {
        super(message);
        this.lineNumber = lineNumber;
    }
}
