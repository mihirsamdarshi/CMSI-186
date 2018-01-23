public class ReplaceThirdWords{
    public static void main(String[] args) {
        int numOfArgs = args.length;
        for(int i = 0; i < numOfArgs; i++) {
            if ((i-2) % 3 == 0) {
            System.out.print("");
            }
            else {
                System.out.print(args[i] + " ");
            }
            if ((i-2) % 3 == 0) {
            System.out.print("um ");
            }
        }
    }
}
