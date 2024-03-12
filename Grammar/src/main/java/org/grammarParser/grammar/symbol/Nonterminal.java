package org.grammarParser.grammar.symbol;

import lombok.Getter;
import org.grammarParser.grammar.rule.Rule;

import java.util.ArrayList;
import java.util.List;

/**
 * Nonterminal symbol.
 * Elsewise big letter
 * <p>>A< : b C | B d;</p>
 *
 * <p>Has a rules in it (things that can be changed to)</p>
 */
@Getter
public class Nonterminal extends Symbol<Nonterminal> {

    private final List<Rule> rules = new ArrayList<>();
    public Nonterminal(String name) {
        super(name);
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    @Override
    public String toString() {
        return getName();
    }
}
