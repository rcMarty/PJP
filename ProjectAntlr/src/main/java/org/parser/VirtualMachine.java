package org.parser;
import lombok.extern.slf4j.Slf4j;
import org.parser.compiler.Instruction;
import org.parser.compiler.InstructionType;

import java.util.*;
import java.util.stream.IntStream;

@Slf4j
public class VirtualMachine {
    private final Stack<Object> stack = new Stack<>();
    private final Map<String, Object> variables = new HashMap<>();
    private final Map<String, Integer> labels = new HashMap<>();
    private final List<Instruction> instructions;
    private int pc = 0;

    public VirtualMachine(List<Instruction> instructions) {
        this.instructions = instructions;

        for (int i = 0; i < instructions.size(); i++) {
            Instruction instruction = instructions.get(i);
            if (instruction.getInstruction() == InstructionType.LABEL) {
                labels.put((String) instruction.getArgs(), i);
            }
        }

    }

    public String run() {
        StringBuilder output = new StringBuilder();
        for (pc = 0; pc < instructions.size(); pc++) {
            Instruction instruction = instructions.get(pc);
            switch (instruction.getInstruction()) {
                case ADD -> add(instruction);
                case SUB -> sub(instruction);
                case MUL -> mul(instruction);
                case DIV -> div(instruction);
                case MOD -> mod(instruction);
                case UMINUS -> uminus(instruction);
                case CONCAT -> concat(instruction);
                case AND -> and(instruction);
                case OR -> or(instruction);
                case GT -> gt(instruction);
                case LT -> lt(instruction);
                case EQ -> eq(instruction);
                case NOT -> not(instruction);
                case ITOF -> itof(instruction);
                case PUSH -> push(instruction);
                case POP -> pop(instruction);
                case LOAD -> load(instruction);
                case SAVE -> save(instruction);
                case LABEL -> label(instruction);
                case JMP -> jmp(instruction);
                case FJMP -> fjmp(instruction);
                case TJMP -> tjmp(instruction);
                case PRINT -> output.append(print(instruction)).append("\n");
                case READ -> read(instruction);
            }

        }
        return output.toString();
    }

    private void add(Instruction instruction) {
        Object a = stack.pop();
        Object b = stack.pop();
        switch (instruction.getType()) {
            case INT -> stack.push((int) a + (int) b);
            case FLOAT -> stack.push((float) a + (float) b);
        }
    }

    private void sub(Instruction instruction) {
        Object a = stack.pop();
        Object b = stack.pop();
        switch (instruction.getType()) {
            case INT -> stack.push((int) a - (int) b);
            case FLOAT -> stack.push((float) a - (float) b);
        }
    }

    private void mul(Instruction instruction) {
        Object a = stack.pop();
        Object b = stack.pop();
        switch (instruction.getType()) {
            case INT -> stack.push((int) a * (int) b);
            case FLOAT -> stack.push((float) a * (float) b);
        }
    }

    private void div(Instruction instruction) {
        Object a = stack.pop();
        Object b = stack.pop();
        switch (instruction.getType()) {
            case INT -> stack.push((int) a / (int) b);
            case FLOAT -> stack.push((float) a / (float) b);
        }
    }

    private void mod(Instruction instruction) {
        Object a = stack.pop();
        Object b = stack.pop();
        stack.push((int) a % (int) b);
    }

    private void uminus(Instruction instruction) {
        Object a = stack.pop();
        switch (instruction.getType()) {
            case INT -> stack.push(-(int) a);
            case FLOAT -> stack.push(-(float) a);
        }
    }

    private void concat(Instruction instruction) {
        Object a = stack.pop();
        Object b = stack.pop();
        stack.push(a.toString() + b.toString());
    }

    private void and(Instruction instruction) {
        Object a = stack.pop();
        Object b = stack.pop();
        stack.push((boolean) a && (boolean) b);
    }

    private void or(Instruction instruction) {
        Object a = stack.pop();
        Object b = stack.pop();
        stack.push((boolean) a || (boolean) b);
    }

    private void gt(Instruction instruction) {
        Object a = stack.pop();
        Object b = stack.pop();
        switch (instruction.getType()) {
            case INT -> stack.push((int) a < (int) b);
            case FLOAT -> stack.push((float) a < (float) b);
        }
    }

    private void lt(Instruction instruction) {
        Object a = stack.pop();
        Object b = stack.pop();
        switch (instruction.getType()) {
            case INT -> stack.push((int) a > (int) b);
            case FLOAT -> stack.push((float) a > (float) b);
        }
    }

    private void eq(Instruction instruction) {
        Object a = stack.pop();
        Object b = stack.pop();
        stack.push(a.equals(b)); //TODO revisit if it works
    }

    private void not(Instruction instruction) {
        Object a = stack.pop();
        stack.push(!(boolean) a);
    }

    private void itof(Instruction instruction) {
        Object a = stack.pop();
        stack.push((float) (int) a);
    }

    private void push(Instruction instruction) {
        stack.push(instruction.getArgs());
    }

    private void pop(Instruction instruction) {
        stack.pop();
    }

    private void load(Instruction instruction) {
        stack.push(variables.get((String) instruction.getArgs()));
    }

    private void save(Instruction instruction) {
        variables.put((String) instruction.getArgs(), stack.pop());
    }

    private void label(Instruction instruction) {
        // do nothing
    }

    private void jmp(Instruction instruction) {
        pc = labels.get((String) instruction.getArgs());
    }

    private void fjmp(Instruction instruction) {
        if (!(boolean) stack.pop()) {
            pc = labels.get((String) instruction.getArgs());
        }
    }
    private void tjmp(Instruction instruction) {
        if ((boolean) stack.pop()) {
            pc = labels.get((String) instruction.getArgs());
        }
    }

    private String print(Instruction instruction) {
        StringBuilder output = new StringBuilder();
        for (int i : IntStream.range(0, (int) instruction.getArgs()).toArray()) {
            output.append(stack.pop()).append(" ");
        }
        return output.toString();
    }

    private void read(Instruction instruction) {
        boolean success = false;
        log.info("Enter value of type {}", instruction.getType());
        while(!success) {
            try {
                Scanner scanner = new Scanner(System.in);
                String a = scanner.nextLine();
                switch (instruction.getType()) {
                    case INT -> stack.push(Integer.parseInt(a));
                    case FLOAT -> stack.push(Float.parseFloat(a));
                    case BOOL -> stack.push(Boolean.parseBoolean(a));
                    case STRING -> stack.push(a);
                }
                success = true;
            } catch (Exception e) {
                log.error("Invalid input, try again");
            }
        }
    }


}
