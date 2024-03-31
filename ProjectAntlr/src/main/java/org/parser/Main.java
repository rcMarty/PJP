package org.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
//import org.antlr4.Lab7.*;
import org.antlr4.projexpr.*;

import lombok.extern.slf4j.Slf4j;
import org.parser.errors.AntlrErrorListener;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class Main {

    public static void main(String[] args) {

        String filename = "input.txt";
        CharStream input = null;



        try {
            InputStream file = Main.class.getClassLoader().getResourceAsStream(""+filename);
            if (file == null) {
                log.error("File {} not found", filename);
                return;
            }
            input = CharStreams.fromStream(file);
        }catch (IOException e) {
            log.error("File {} not found", filename);
        }


        var lexer = new ProjExprLexer(input);
        var tokens = new CommonTokenStream(lexer);
        var parser = new ProjExprParser(tokens);

        AntlrErrorListener errorListener = new AntlrErrorListener();
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);



        log.info("Start parsing");
        var tree = parser.prog();
        if (parser.getNumberOfSyntaxErrors() > 0 ) {
            log.error("Syntax errors found");
            for (String error : errorListener.getErrors()) {
                log.error(error);
            }
            return;
        }

        log.info("End parsing {}", tree.toStringTree(parser));
        

    }
}