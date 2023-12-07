package VscriptParsingAndExecution;

import Functionalities.InstructionManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public final class Parser {
    private final Queue<String> instructions = new LinkedList<>();
    public void parse(String path, String... flags) throws FileNotFoundException {
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

        execute(flags);
    }

    private void execute(String... flags) {
        if (!hasInstructions()) {
            return;
        }

        while(hasInstructions()) {
            String toExecute = getInstructions().poll();

            // need to poll what instruction is then handle the logic for it / need to parse parameters from instructions and pass them to instruction instances
            InstructionManager.InstructionType instructionType = InstructionManager.typeMapper.get(toExecute);
        }

    }

    public Queue<String> getInstructions() {
        return instructions;
    }

    public boolean hasInstructions() {
        return this.instructions.isEmpty();
    }
}
