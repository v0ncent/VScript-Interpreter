package Functionalities.Instructions;

import Functionalities.Instruction;
import Functionalities.InstructionManager;

public class MathInstruction extends Instruction {
    public MathInstruction(InstructionManager.InstructionType instructionType, String instructionName, Object[] params) {
        super(instructionType, instructionName, params);
    }

    @Override
    public void execute(Object[] params) {

    }

}
