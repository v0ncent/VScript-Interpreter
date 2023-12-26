import Exceptions.NoInstructionGivenException;
import Functionalities.Instruction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public final class Parser {
    private final Queue<String> instructions = new LinkedList<>();
    public void parse(String path) throws FileNotFoundException, NoInstructionGivenException {
        File file = null;

        try {
            file = new File(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (file == null) {
            System.out.println("Could not find the file " + path + ".");
            return;
        }

        if (!file.exists() ||
                !file.isFile() ||
                !file.getName().split("\\.")[1].equals("vscript")) {

            System.out.println("Not a valid vscript file or file does not exist!");
            return;
        }

        final Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            instructions.add(scanner.nextLine());
        }

        execute();
    }

    private void execute() throws NoInstructionGivenException {
        if (!hasInstructions()) {
            return;
        }

        int lineCount = 1;
        while(hasInstructions()) {
            String toExecute = getInstructions().poll();

            // if line we are looking at is a comment
            if (toExecute != null && toExecute.startsWith("//") || toExecute != null && toExecute.equals("")) {
                continue;
            }

            String instructionRaw = null;
            String paramBlock;
            String[] paramsRaw = null;
            Object[] params = null;

            if (toExecute != null) {
                instructionRaw = toExecute.substring(0, toExecute.indexOf("("));
                paramBlock = toExecute.substring(toExecute.indexOf("(")+1, toExecute.indexOf(")"));
                paramsRaw = paramBlock.split(Constants.PARAM_DISCRIMINATOR);
            }

            if (paramsRaw != null) {
                params = paramsRaw;
            }

            if (instructionRaw == null) {
                throw new NoInstructionGivenException("No instruction provided!", lineCount);
            }

            Instruction.InstructionType instructionType = Constants.typeMapper.get(instructionRaw);
            Instruction instruction = Instruction.executionHandler(instructionType, params);

            if (instruction == null) {
                System.out.printf("There is a syntax error or the instruction does not exist! line: %d",lineCount);
                return;
            }

            try {
                instruction.execute(params, lineCount);
            } catch (Exception e) {
                e.printStackTrace();
            }

            lineCount++;
        }

    }

    public Queue<String> getInstructions() {
        return instructions;
    }

    public boolean hasInstructions() {
        return !this.instructions.isEmpty();
    }
}
