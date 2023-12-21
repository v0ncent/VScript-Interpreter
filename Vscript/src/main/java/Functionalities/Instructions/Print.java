package Functionalities.Instructions;

import Functionalities.Instruction;
import Functionalities.InstructionManager;

import java.util.Arrays;

public class Print extends Instruction {
    public Print(InstructionManager.InstructionType instructionType, String instructionName, String[] params) {
        super(instructionType, instructionName,params);
    }

    @Override
    public void execute(String[] params) {
        if (params == null) {
            System.out.println();
            return;
        }

        // one parameter instruction to print given parameter to console, so grab first element
        System.out.println(Arrays.toString(params));
    }

}
