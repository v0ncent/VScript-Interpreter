package Functionalities.Instructions;

import Exceptions.SyntaxException;
import Functionalities.Instruction;

public class Print extends Instruction {
    public Print(Instruction.InstructionType instructionType, String instructionName, Object[] params) {
        super(instructionType, instructionName,params);
    }

    @Override
    public void execute(Object[] params, int currentLine) throws SyntaxException {
        // print function only takes one Object parameter
        if (params.length > 1) {
            throw new SyntaxException("Multiple arguments provided in print function", currentLine);
        }

        String printStream = (String) params[0];

        if (printStream.contains("\"")) {
            printStream = printStream.replaceAll("\"", "");
        }

        String[] concatenation;

        // if concatenation is happening
        if (!printStream.contains("+")) {
            System.out.println(printStream);
            return;
        }

        concatenation = printStream.split("\\+");
        StringBuilder builder = new StringBuilder();

        for (String s : concatenation) {
            builder.append(s);
        }

        System.out.println(builder);
    }

}
