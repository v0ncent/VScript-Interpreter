package Functionalities.Instructions.MathInstructions;

import Functionalities.InstructionManager;
import Functionalities.Instructions.MathInstruction;

public class Add extends MathInstruction {

    public Add(InstructionManager.InstructionType instructionType, String instructionName, String unparsedParams) {
        super(instructionType, instructionName, unparsedParams);
    }
}