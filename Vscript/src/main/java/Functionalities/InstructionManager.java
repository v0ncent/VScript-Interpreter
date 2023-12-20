package Functionalities;

import Functionalities.Instructions.MathInstruction;
import Functionalities.Instructions.Params.UnparsedParam;
import Functionalities.Instructions.Print;

import java.util.HashMap;

public final class InstructionManager {
    public static final HashMap<String, InstructionType> typeMapper = new HashMap<>();

    public enum InstructionType {
        PRINT,
        MATH
    }

    public static Instruction executionHandler(InstructionType instructionType, UnparsedParam unparsedParams) {
        if (unparsedParams == null) {

        }

        switch (instructionType) {
            case PRINT -> {
                return new Print(instructionType, "print", unparsedParams);
            }
            case MATH -> {
                return new MathInstruction(instructionType, "mathinstruction", unparsedParams);
            }
            default -> {
                return null;
            }
        }

    }
}
