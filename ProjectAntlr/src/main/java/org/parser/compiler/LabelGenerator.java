package org.parser.compiler;
public class LabelGenerator {
    private static int labelCounter = 0;

    public static String getLabel(String labelName) {
        return labelName + "_" + labelCounter++;
    }
}
