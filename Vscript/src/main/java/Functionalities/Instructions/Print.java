package Functionalities.Instructions;

import Functionalities.Instruction;
import Functionalities.InstructionManager;
import Functionalities.Instructions.Params.UnparsedParam;

public class Print extends Instruction {
    public Print(InstructionManager.InstructionType instructionType, String instructionName, UnparsedParam unparsedParams) {
        super(instructionType, instructionName,unparsedParams);
    }

    @Override
    public void execute(String[] parsedParams) {
        if (getUnparsedParams() == null) {
            System.out.println();
            return;
        }

        // one parameter instruction to print given parameter to console, so grab first element
        System.out.println();
    }

    @Override
    protected String[] parseParams(UnparsedParam params) {
        if (params.isParsed()) {
            return params.getParsedParams();
        }



        return params.getParsedParams();
    }
}
