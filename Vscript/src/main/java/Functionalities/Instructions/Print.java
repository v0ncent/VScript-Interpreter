package Functionalities.Instructions;

import Functionalities.Instruction;
import Functionalities.InstructionManager;

import java.util.Optional;

public class Print extends Instruction {
    public Print(InstructionManager.InstructionType instructionType, String instructionName) {
        super(instructionType, instructionName);
    }

    @Override
    public void execute() {
        System.out.println();
    }
}
