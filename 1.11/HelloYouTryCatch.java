public class HelloYouTryCatch {
    public static void main(String[] args) {
        try {
            System.out.println("Hello " + args[0] + "!");
        }
        catch (Exception e) {
            System.out.println("No arguments, So Hello World!");
        }

        System.out.println("This code is outside of the try catch!");

    }
}
