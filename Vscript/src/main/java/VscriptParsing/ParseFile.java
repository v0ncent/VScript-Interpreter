package VscriptParsing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class ParseFile {
    public static void parse(String path, String... flags) throws FileNotFoundException {
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

        }

    }
}
