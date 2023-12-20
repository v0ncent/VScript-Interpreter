package Functionalities.Instructions.MathInstructions;

import Functionalities.InstructionManager;
import Functionalities.Instructions.MathInstruction;
import Functionalities.Instructions.Params.UnparsedParam;

public class Add extends MathInstruction {

    public Add(InstructionManager.InstructionType instructionType, String instructionName, UnparsedParam unparsedParams) {
        super(instructionType, instructionName, unparsedParams);
    }
}
