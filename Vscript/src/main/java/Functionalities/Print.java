package Functionalities;

import java.util.Optional;

public class Print extends Instruction {
    Optional<String> param;
    public Print(InstructionManager.InstructionType instructionType, String instructionName) {
        super(instructionType, instructionName);
    }

    @Override
    public void execute() {
        System.out.println(param);
    }
}
