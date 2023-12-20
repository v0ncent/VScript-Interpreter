package Functionalities.Instructions.MathInstructions;

import Functionalities.InstructionManager;
import Functionalities.Instructions.MathInstruction;
import Functionalities.Instructions.Params.UnparsedParam;

public class Div extends MathInstruction {
    public Div(InstructionManager.InstructionType instructionType, String instructionName, UnparsedParam unparsedParams) {
        super(instructionType, instructionName, unparsedParams);
    }
}
