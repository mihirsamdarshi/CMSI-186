public class HelloYouInputValidation {
    public static void main(String[] args) {

        if (args.length > 0) {
            System.out.println("Hello " + args[0] + "!");
        }
        else {
            System.out.println("No arguments, so Hello World!");
        }

        System.out.println("This code is outside of the if-else!");

    }
}
