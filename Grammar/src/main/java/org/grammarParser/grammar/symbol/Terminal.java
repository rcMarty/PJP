package org.grammarParser.grammar.symbol;

/**
 * Terminal symbol.
 * Elsewise small letter
 * <p>A : >b< C | B d ;</p>
 *
 */
public class Terminal extends Symbol<Terminal> {

    public Terminal(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return getName();
    }
}
