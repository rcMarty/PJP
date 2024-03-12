package org.grammarParser.grammar.rule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import org.grammarParser.grammar.symbol.Epsilon;
import org.grammarParser.grammar.symbol.Nonterminal;
import org.grammarParser.grammar.symbol.Symbol;
import org.grammarParser.grammar.symbol.Terminal;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a rule in the grammar.
 * <p>A rule is a production of the form A -> α, where A is a nonterminal and α is a sequence of terminals and nonterminals.</p>
 *
 */
@Getter
@AllArgsConstructor
public class Rule {

    private Nonterminal leftHandSide;
    private final List<Symbol<?>> rightHandSide = new ArrayList<>();

    public Symbol<?> getSymbol(String name) {
        return rightHandSide.stream()
                .filter(symbol -> symbol.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public boolean hasEpsilon() {
        return rightHandSide.stream().allMatch(symbol -> symbol instanceof Epsilon);
    }

    public Terminal addTerminal(String name) {
        Terminal terminal = new Terminal(name);
        rightHandSide.add(terminal);
        return terminal;
    }

    public Nonterminal addNonterminal(String name) {
        Nonterminal nonterminal = new Nonterminal(name);
        rightHandSide.add(nonterminal);
        return nonterminal;
    }

    public Epsilon addEpsilon() {
        Epsilon epsilon = rightHandSide.stream()
                .filter(symbol -> symbol instanceof Epsilon)
                .map(symbol -> (Epsilon) symbol)
                .findFirst()
                .orElse(null);

        if (epsilon == null) {
            epsilon = new Epsilon();
            rightHandSide.add(epsilon);
        }

        return epsilon;
    }

    @Override
    public String toString() {
        return "%s -> %s".formatted(leftHandSide.getName(), rightHandSide.stream().map(Symbol::getName).reduce(Strings.EMPTY, (a, b) -> a+b));
    }
}
