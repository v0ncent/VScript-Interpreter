package Functionalities.Instructions.MathInstructions;

import Functionalities.InstructionManager;
import Functionalities.Instructions.MathInstruction;
import Functionalities.Instructions.Params.UnparsedParam;

public class Sub extends MathInstruction {
    public Sub(InstructionManager.InstructionType instructionType, String instructionName, UnparsedParam unparsedParams) {
        super(instructionType, instructionName, unparsedParams);
    }
}
