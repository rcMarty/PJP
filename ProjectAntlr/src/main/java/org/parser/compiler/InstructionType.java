package org.parser.compiler;

public enum InstructionType {
    ADD, SUB, MUL, DIV, MOD, UMINUS, CONCAT,
    AND, OR,
    GT, LT, EQ, NOT,
    ITOF,
    PUSH, POP, LOAD, SAVE,
    LABEL, JMP, FJMP, TJMP,
    PRINT, READ,
}
