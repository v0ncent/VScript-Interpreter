package Functionalities;

import Functionalities.Instructions.MathInstruction;
import Functionalities.Instructions.Print;

import java.util.HashMap;

public final class InstructionManager {
    public static final HashMap<String, InstructionType> typeMapper = new HashMap<>();

    public enum InstructionType {
        PRINT,
        MATH
    }

    public static Instruction executionHandler(InstructionType instructionType, String[] params) {
        switch (instructionType) {
            case PRINT -> {
                return new Print(instructionType, "print", params);
            }
            case MATH -> {
                return new MathInstruction(instructionType, "mathinstruction", params);
            }
            default -> {
                return null;
            }
        }

    }
}
