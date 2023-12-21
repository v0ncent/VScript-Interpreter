import Functionalities.Instruction;
import Functionalities.InstructionManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public final class Parser {
    private final Queue<String> instructions = new LinkedList<>();
    public void parse(String path) throws FileNotFoundException {
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

    private void execute() {
        if (!hasInstructions()) {
            return;
        }

        int lineCount = 1;
        while(hasInstructions()) {
            String toExecute = getInstructions().poll();
            String paramBlock;
            String[] params = null;

            if (toExecute != null) {
                paramBlock = toExecute.substring(toExecute.indexOf("(")+1, toExecute.indexOf(")"));
                params = paramBlock.split(Constants.PARAM_DISCRIMINATOR);
            }

            System.out.println(Arrays.toString(params));

            InstructionManager.InstructionType instructionType = InstructionManager.typeMapper.get(toExecute);
            Instruction instruction = InstructionManager.executionHandler(instructionType, params);

            if (instruction == null) {
                System.out.printf("There is a syntax error or the instruction does not exist! line: %d",lineCount);
                return;
            }

            try {
                instruction.execute(params);
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
