package Functionalities.Instructions;

import Functionalities.Instruction;
import Functionalities.InstructionManager;

public class MathInstruction extends Instruction {
    public MathInstruction(InstructionManager.InstructionType instructionType, String instructionName, String[] params) {
        super(instructionType, instructionName, params);
    }

    @Override
    public void execute(String[] params) {

    }

}
