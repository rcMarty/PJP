package org.grammarParser.grammar.symbol;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Just a Symbol. Thats all. can be nonterminal or terminal.
 * <p>Has a name and can be compared to others</p>
 */
@Getter
@AllArgsConstructor
public abstract class Symbol<T> implements Comparable<T> {

    private final String name;

    @Override
    public int compareTo(Object o) {
        return this.name.compareTo(((Symbol<?>) o).name);
    }

    @Override
    public String toString() {
        return name;
    }
}
