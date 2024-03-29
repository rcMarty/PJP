package org.grammarParser;

import lombok.extern.slf4j.Slf4j;
import org.grammarParser.grammar.Grammar;
import org.grammarParser.grammar.GrammarException;
import org.grammarParser.grammar.GrammarReader;

import java.io.IOException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Grammar grammar;

        try {
            GrammarReader inp = new GrammarReader(args[0]);
            grammar = inp.read();
        } catch (GrammarException e) {
            System.err.println("Error(" + e.getLineNumber() + ") " + e.getMessage());
            return;
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            return;
        }

        log.info(grammar.smarterDump());

        log.info("nonterminals which can be empty {}", grammar.computeEmpty());

        grammar.getFirst();

        // GrammarOps go = new GrammarOps(grammar);
        //
        // /* first step, computing nonterminals that can generate empty word */
        // for (Nonterminal nt : go.getEmptyNonterminals()) {
        // System.out.print(nt.getName() + " ");
        // }
        // System.out.println();
    }
}