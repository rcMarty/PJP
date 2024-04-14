package org.parser.compiler;

import lombok.Builder;
import lombok.Getter;
import org.parser.logging.AnsiiColors;
import org.parser.types.Types;

@Builder
@Getter
public class Instruction {
    private InstructionType instruction;
    private Types type;
    private Object args;


    @Override
    public String toString() {
        return AnsiiColors.ANSI_YELLOW + instruction.toString().toLowerCase() + AnsiiColors.ANSI_RESET + " "
                + (args == null ? "" : args)
                + " " + AnsiiColors.ANSI_BLUE + (type == null ? "" : type) + AnsiiColors.ANSI_RESET;
    }

    public String toInstructions() {

        if (instruction == InstructionType.LOAD) {
            type = null;
        }

        return instruction.toString().toLowerCase() +
                (type == null ? "" : " " + type.name().charAt(0)) +
                (args == null ? "" : " " + args);
    }
}

