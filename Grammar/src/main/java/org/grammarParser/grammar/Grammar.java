package org.grammarParser.grammar;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.grammarParser.grammar.rule.Rule;
import org.grammarParser.grammar.symbol.Epsilon;
import org.grammarParser.grammar.symbol.Nonterminal;
import org.grammarParser.grammar.symbol.Symbol;
import org.grammarParser.grammar.symbol.Terminal;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Grammar class.
 * <p> This class represents a grammar. It contains a set of nonterminals, a set of terminals, and a start symbol.</p>
 *  <ul>
 *      <li>A : b C | B d;</li>
 *      <li>B : C C | b A;</li>
 *      <li>C : c C | {e};</li>
 *  </ul>
 *  <p>Starting symbol is just first character</p>
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class Grammar {

    private final Set<Nonterminal> nonTerminals = new TreeSet<>();
    private final Set<Terminal> terminals = new TreeSet<>();
    private Nonterminal startSymbol;

    public Nonterminal getNonterminal(String name) {
        return nonTerminals.stream()
                .filter(nonterminal -> nonterminal.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public Terminal getTerminal(String name) {
        return terminals.stream()
                .filter(terminal -> terminal.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public Nonterminal addNonterminal(String name) {
        Nonterminal nonterminal = getNonterminal(name);
        if (nonterminal == null) {
            nonterminal = new Nonterminal(name);
            nonTerminals.add(nonterminal);
        }

        if (startSymbol == null) {
            startSymbol = nonterminal;
        }

        return nonterminal;
    }

    public Terminal addTerminal(String name) {
        Terminal terminal = getTerminal(name);
        if (terminal == null) {
            terminal = new Terminal(name);
            terminals.add(terminal);
        }

        return terminal;
    }

    public void addEpsilon() {
        Epsilon epsilon = new Epsilon();
        terminals.add(epsilon);
    }

    public List<Rule> getRules() {
        List<Rule> rules = new ArrayList<>();
        nonTerminals.forEach(nonterminal -> rules.addAll(nonterminal.getRules()));
        return rules;
    }

    public void dump() {
        log.debug("Terminals: {}", getTerminals());
        log.debug("Nonterminals: {}", getNonTerminals());
        log.debug("Starting nonterminal: {}", getStartSymbol());

        log.debug("Rules:");
        for (Rule rule : getRules()) {
            log.debug("- " + rule.toString());
        }
    }

    public String smarterDump(){
        return "Starting nonterminal: " + getStartSymbol() + "\n" +
                "Terminals: " + getTerminals() + "\n" +
                "Nonterminals: " + getNonTerminals() + "\n" +
                "Rules: " + getRules().stream().map(Rule::toString).reduce("", (a, b) -> a + "\n- " + b);
    }

    public Set<String> computeEmpty(){

        Set<String> empty=  nonTerminals.stream()
                .filter(nonterminal -> nonterminal.getRules().stream().anyMatch(Rule::hasEpsilon))
                .map(Nonterminal::getName)
                .collect(Collectors.toSet());


        log.debug("empty: {}", empty);

        boolean changed;

        do {
            changed = false;
            for (Nonterminal nonterminal : nonTerminals) {
                if (empty.contains(nonterminal)) {
                    continue;
                }
                log.debug("Nonterminal: {}", nonterminal);

                if (nonterminal.getRules().stream()
                        .anyMatch(rule -> rule.getRightHandSide().stream()
                                //.peek(symbol -> log.debug("Symbol: {}", symbol))
                                //.peek(symbol -> log.debug("Empty: {}", empty))
                                //.peek(symbol-> log.debug("empty contains symbol?: {}", empty.contains(symbol.getName())))
                                .allMatch(symbol -> symbol instanceof Epsilon || empty.contains(symbol.getName())))) {

                    if (empty.contains(nonterminal.getName()))
                        continue;

                    empty.add(nonterminal.getName());
                    changed = true;
                }
            }

        }while (changed);

    return empty;
    }


    public void getfirst(){
        Map<Nonterminal, Set<Terminal>> first = new HashMap<>();
        for (Nonterminal nonterminal : nonTerminals) {
            first.put(nonterminal, new HashSet<>());
        }

        boolean changed;
        do {
            changed = false;
            for (Nonterminal nonterminal : nonTerminals) {
                for (Rule rule : nonterminal.getRules()) {
                    for (Symbol<?> symbol : rule.getRightHandSide()) {
                        log.trace("Symbol: {}", symbol);

                        if (symbol instanceof Terminal terminal) {
                            log.trace("adding terminal: {} to {}", terminal, nonterminal);
                            changed |= first.get(nonterminal).add(terminal);
                            break;
                        }

                        if (symbol instanceof Nonterminal nonterminal1) {
                            //Rekurzivně vypočti množiny first všech pravých stran tohoto neterminálu.
                            //Výsledky spoj do jedné množiny.
                            //Pokud tato množina obsahuje epsilon, tak jej odeber.
                            //Výsledek přidej do množiny first.

                            log.trace("adding nonterminal: {} to {}", nonterminal1, nonterminal);
                            log.trace("First: {}", first.get(nonterminal1));
                            if (first.get(nonterminal1) == null) {
                                log.trace("First is null");
                            } else {
                                // by recursion
                                log.trace("\tFirst is not null");
                                changed |= first.get(nonterminal).addAll(first.get(nonterminal1).stream()
                                        .filter(terminal -> !(terminal instanceof Epsilon))
                                        .collect(Collectors.toSet()));
                                log.trace("\t\tFirst: {}", first.get(nonterminal));
                                if (!first.get(nonterminal1).contains(new Epsilon())) {
                                    break;
                                }
                            }

                        }

                        if (symbol instanceof Epsilon) {
                            log.trace("Epsilon");
                            changed |= first.get(nonterminal).add(new Terminal(symbol.getName())) ;
                            break;
                        }
                    }
                }
            }
        } while (changed);

        log.debug("First: {}", first);
    }



}
