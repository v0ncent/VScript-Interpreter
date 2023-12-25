import Functionalities.Instruction;

import java.util.HashMap;

public final class Constants {
    public static final HashMap<String, Instruction.InstructionType> typeMapper = new HashMap<>();
    static {
        typeMapper.put("print", Instruction.InstructionType.PRINT);
        typeMapper.put("add", Instruction.InstructionType.MATH);
        typeMapper.put("div", Instruction.InstructionType.MATH);
        typeMapper.put("mul", Instruction.InstructionType.MATH);
        typeMapper.put("sub", Instruction.InstructionType.MATH);
    }

    private Constants(){}

    public static final String PARAM_DISCRIMINATOR = ",";
}
