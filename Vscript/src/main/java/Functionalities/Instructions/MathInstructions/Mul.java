package Functionalities.Instructions.MathInstructions;

import Functionalities.InstructionManager;
import Functionalities.Instructions.MathInstruction;
import Functionalities.Instructions.Params.UnparsedParam;

public class Mul extends MathInstruction {
    public Mul(InstructionManager.InstructionType instructionType, String instructionName, UnparsedParam unparsedParams) {
        super(instructionType, instructionName, unparsedParams);
    }
}
