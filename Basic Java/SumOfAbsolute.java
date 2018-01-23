public class SumOfAbsolute{
    public static void main(String[] args) {
        int sum = 0;
        int numOfArgs = args.length;
        int[] parsedNum = new int[args.length];
        for (int i = 0; i < numOfArgs; i++) {
            try {
                parsedNum[i] = Integer.parseInt(args[i]);
            }
            catch (NumberFormatException nfe) {
            };
        }
        for (int i = 0; i < numOfArgs; i++) {
            if (parsedNum[i] < 0) {
                parsedNum[i] *= -1;
            }
            }
        for(int i = 0; i < numOfArgs; i++) {
            sum += parsedNum[i];
        }
        System.out.println(sum);
    }
}
