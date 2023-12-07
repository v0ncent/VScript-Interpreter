package Functionalities.Instructions;

import Functionalities.Instruction;
import Functionalities.InstructionManager;

public class Print extends Instruction {
    public Print(InstructionManager.InstructionType instructionType, String instructionName, String unparsedParams) {
        super(instructionType, instructionName,unparsedParams);
    }

    @Override
    public void execute() {
        if (getUnparsedParams() == null) {
            System.out.println();
            return;
        }

        // one parameter instruction to print given parameter to console, so grab first element
        System.out.println(this.parseParams(this.getUnparsedParams())[0]);
    }

    @Override
    public String[] parseParams(String params) {
        return new String[0];
    }
}
