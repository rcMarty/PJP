package org.parser.errors;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.parser.logging.AnsiiColors;

import java.util.ArrayList;
import java.util.List;

public class TypeErrorLogger {

    private static TypeErrorLogger instance;
    private final List<String> errors = new ArrayList<>();
    private final List<String> assignErrors = new ArrayList<>();
    private final List<String> typeErrors = new ArrayList<>();
    private final List<String> conditionErrors = new ArrayList<>();

    public static TypeErrorLogger getInstance() {
        if (instance == null) {
            instance = new TypeErrorLogger();
        }
        return instance;
    }

    private static String formatError(ParserRuleContext ctx, Token token, String error, Object... args) {
        int lineNum = ctx.getStart().getLine();
        int charPos = token != null ? token.getCharPositionInLine() : ctx.getStart().getCharPositionInLine();

        String line = ctx.getStart().getInputStream().toString().split("\n")[lineNum - 1];
        String message = error.formatted(args);

        return """
                error at line %d:%d -> %s
                 - statement: %s%s%s
                              %s%s%s
                """.formatted(lineNum, charPos, message, AnsiiColors.ANSI_YELLOW, line, AnsiiColors.ANSI_RESET, AnsiiColors.ANSI_GREEN, " ".repeat(charPos) + "^", AnsiiColors.ANSI_RESET);
    }

    @Deprecated
    public void addError(String error) {
        addError(error, null);
    }

    @Deprecated
    public void addError(String error, ErrorType type) {
        switch (type) {
            case ASSIGN -> assignErrors.add(error);
            case TYPE -> typeErrors.add(error);
            case CONDITION -> conditionErrors.add(error);
            case null -> errors.add(error);
        }
    }

    public void addError(ParserRuleContext ctx, Token token, String error, ErrorType type) {
        switch (type) {
            case ASSIGN -> assignErrors.add(formatError(ctx, token, error));
            case TYPE -> typeErrors.add(formatError(ctx, token, error));
            case CONDITION -> conditionErrors.add(formatError(ctx, token, error));
            case null -> errors.add(formatError(ctx, token, error));
        }
    }

    public List<String> getErrors() {
        List<String> allErrors = new ArrayList<>();
        for (String error : assignErrors) {
            allErrors.add(formatError(AnsiiColors.ANSI_GREEN + "[ASSIGN ERROR]" + AnsiiColors.ANSI_RESET, error));
        }
        for (String error : typeErrors) {
            allErrors.add(formatError(AnsiiColors.ANSI_CYAN + "[TYPE ERROR]" + AnsiiColors.ANSI_RESET, error));
        }
        for (String error : conditionErrors) {
            allErrors.add(formatError(AnsiiColors.ANSI_PURPLE + "[CONDITION ERROR]" + AnsiiColors.ANSI_RESET, error));
        }
        for (String error : errors) {
            allErrors.add(formatError(AnsiiColors.ANSI_RED + "[ERROR]" + AnsiiColors.ANSI_RESET, error));
        }
        return allErrors;
    }

    private String formatError(String errorType, String errorMessage) {
        return String.format("\n\t\t\t\t\t %s\n\t\t\t\t\t %s", errorType, errorMessage.replace("\n", "\n\t\t\t\t\t "));
    }

    public enum ErrorType {
        ASSIGN, TYPE, CONDITION
    }


}
