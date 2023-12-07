package Functionalities.Instructions;

import Functionalities.Instruction;
import Functionalities.InstructionManager;
import Functionalities.Instructions.Params.UnparsedParam;

public class MathInstruction extends Instruction {
    public MathInstruction(InstructionManager.InstructionType instructionType, String instructionName, UnparsedParam unparsedParams) {
        super(instructionType, instructionName, unparsedParams);
    }

    @Override
    public void execute(String[] parsedParams) {

    }

    @Override
    protected String[] parseParams(UnparsedParam params) {
        return params.getParsedParams();
    }
}
