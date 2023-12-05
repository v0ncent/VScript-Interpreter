import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Config config = null;

    static {
        // parse config file before running interpreter
        JSONParser parser = new JSONParser();
        try {
            final JSONObject parsedConfigFile = (JSONObject) parser.parse(new FileReader("config.json"));

            config = new Config(
                    parsedConfigFile.get("version").toString(),
                    parsedConfigFile.get("auth").toString()
            );

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void run() {
        final Scanner listener = new Scanner(System.in);
        final String[] args = listener.nextLine().split(" ");

        Handler.handle(args);
    }

    public static void main(String[] args) {
        // print out fancy stuff
        System.out.println("""
                                            _..._                                                \s
                                         .-'_..._''.                                             \s
                .----.     .----.      .' .'      '.\\        .--._________   _...._              \s
                 \\    \\   /    /      / .'                   |__|\\        |.'      '-.           \s
                  '   '. /'   /      . '             .-,.--. .--. \\        .'```'.    '.     .|  \s
                  |    |'    /       | |             |  .-. ||  |  \\      |       \\     \\  .' |_ \s
                  |    ||    |    _  | |             | |  | ||  |   |     |        |    |.'     |\s
                  '.   `'   .'  .' | . '             | |  | ||  |   |      \\      /    .'--.  .-'\s
                   \\        /  .   | /\\ '.          .| |  '- |  |   |     |\\`'-.-'   .'    |  |  \s
                    \\      / .'.'| |// '. `._____.-'/| |     |__|   |     | '-....-'`      |  |  \s
                     '----'.'.'.-'  /    `-.______ / | |           .'     '.               |  '.'\s
                           .'   \\_.'              `  |_|         '-----------'             |   / \s
                                                                                           `'-'  \s"""
                .indent(1)
        );
        System.out.printf("By %s version %s",config.getAuth(),config.getVersion());

        // run interpreter
        while(true) {

            try {
                run();
            } catch (Exception e) {
                e.printStackTrace();
                run();
            }
        }

    }

}
