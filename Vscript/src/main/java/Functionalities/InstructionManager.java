package Functionalities;

import java.util.HashMap;

public final class InstructionManager {
    public static final HashMap<String, InstructionType> typeMapper = new HashMap<>();

    public enum InstructionType{
        PRINT,
        MATH
    }
}
