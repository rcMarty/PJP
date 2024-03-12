package org.grammarParser.grammar;

import lombok.extern.slf4j.Slf4j;
import org.grammarParser.grammar.rule.Rule;
import org.grammarParser.grammar.symbol.Nonterminal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GrammarReader {

    // {Input grammar}
    // A : b C | B d;
    // B : C C | b A;
    // C : c C | {e};

    private final List<String> lines = new ArrayList<>();
    private int currentLine = 0;

    public GrammarReader(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            reader.close();
        } catch (IOException e) {
            log.error("Error reading file: {}", filePath, e);
        }
    }

    private void error(String msg) throws GrammarException {
        throw new GrammarException(msg, currentLine);
    }

    public Grammar read() throws GrammarException, IOException {
        Grammar grammar = new Grammar();

        while (currentLine < lines.size()) {
            String line = lines.get(currentLine);
            currentLine++;

            log.info("Parsing line: '{}' ({})", line, currentLine);

            // remove comments
            line = line.replaceAll("\\{[^}]*}", "");
            line = line.strip();

            if (line.isEmpty()) {
                log.info(" - Line empty: Skipping...");
                continue;
            }

            String[] sides = line.split(":");
            if (sides.length != 2) {
                error("Invalid line: " + line);
                continue;
            }

            // left hand side
            String leftHandSide = sides[0].trim();
            Nonterminal left = grammar.addNonterminal(leftHandSide);

            // right hand side
            String[] rightHandSide = sides[1].split("\\|");

            for (String rhs : rightHandSide) {
                rhs = rhs.trim();

                // replace last semicolon
                if (rhs.endsWith(";")) {
                    rhs = rhs.substring(0, rhs.length() - 1);
                }

                log.info(" - Parsing rule: '{}'", rhs);

                // rule
                Rule rule = new Rule(left);

                for (String symbol : rhs.split(" ")) {
                    symbol = symbol.trim();

                    if (symbol.isEmpty()) {
                        rule.addEpsilon();
                    } else if (Character.isLowerCase(symbol.charAt(0))) {
                        rule.addTerminal(symbol);
                        grammar.addTerminal(symbol);
                    } else {
                        rule.addNonterminal(symbol);
                        grammar.addNonterminal(symbol);
                    }
                }

                left.addRule(rule);
            }
        }

        log.info("Grammar read successfully\n");
        return grammar;
    }
}
