package Functionalities.Instructions;

import Functionalities.Instruction;
import Functionalities.InstructionManager;

public class MathInstruction extends Instruction {
    public MathInstruction(InstructionManager.InstructionType instructionType, String instructionName, String unparsedParams) {
        super(instructionType, instructionName, unparsedParams);
    }

    @Override
    public void execute() {

    }

    @Override
    protected String[] parseParams(String params) {
        return new String[0];
    }
}
