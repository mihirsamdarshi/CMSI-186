public class ReplaceThirdWords{
    public static void main(String[] args) {
        int numOfArgs = args.length;
        for(int i = 0; i < numOfArgs; i++) {
            if ((i - 1) % 3 == 0) {
                System.out.print("");
            }
        }
        for(int i = 0; i < numOfArgs; i++) {
            System.out.print(args[i] + " ");
            if ((i - 1) % 3 == 0) {
                System.out.print("um ");
            }
        }
    }
}
