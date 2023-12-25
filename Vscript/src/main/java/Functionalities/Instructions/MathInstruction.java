package Functionalities.Instructions;

import Functionalities.Instruction;

public class MathInstruction extends Instruction {
    public MathInstruction(Instruction.InstructionType instructionType, String instructionName, Object[] params) {
        super(instructionType, instructionName, params);
    }

    @Override
    public void execute(Object[] params, int currentLineCount) {

    }

}
