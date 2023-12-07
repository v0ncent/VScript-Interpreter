public class Handler {

    public static void handle(String[] args) throws Exception {
        switch (args[0]) {
            case "vscript" -> {
                if (args.length < 2) throw new Exception("No arguments given!");
                final Parser parser = new Parser();
                parser.parse(args[1]);
            }

            case "auth" -> System.out.println(Main.config.getAuth());

            case "version" -> System.out.println(Main.config.getVersion());

            default -> System.out.println("Command not found.");
        }

    }

}
