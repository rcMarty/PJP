package org.parser;

import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr4.projexpr.ProjExprLexer;
import org.antlr4.projexpr.ProjExprParser;
import org.parser.compiler.CompilerVisitor;
import org.parser.errors.AntlrErrorListener;
import org.parser.typecheck.TypeCheckVisitor;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class Main {

    public static void main(String[] args) {

        String filename = "parsingtesting.txt";
        CharStream input = null;


        try {
            InputStream file = Main.class.getClassLoader().getResourceAsStream(filename);
            if (file == null) {
                log.error("File {} not found", filename);
                return;
            }
            input = CharStreams.fromStream(file);
        } catch (IOException e) {
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
        if (parser.getNumberOfSyntaxErrors() > 0) {
            log.error("Syntax errors found");
            for (String error : errorListener.getErrors()) {
                log.error(error);
            }
            return;
        }

        log.info("End parsing {}", tree.toStringTree(parser));


        //TODO implement typechecking
        // visitor nebo listener

        TypeCheckVisitor typecheck = new TypeCheckVisitor();
        typecheck.visit(tree);
        typecheck.getErrorLogger().getErrors().forEach(log::error);
        log.info("End typechecking");

        if (!typecheck.getErrorLogger().getErrors().isEmpty()) {
            return;
        }
        CompilerVisitor compiler = new CompilerVisitor();
        log.debug("instructions: \n{}", compiler.visit(tree));

        log.info("generated code: \n{}", compiler.getInstructions(compiler.visit(tree)));

        log.info("End compiling");


    }
}