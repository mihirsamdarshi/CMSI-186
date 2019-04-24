public class Fibonacci {

    public static final BigInteger ZERO = new BigInteger("0");
    public static final BigInteger ONE = new BigInteger("1");

    public static void main(String args[]) {
        if (args.length == 1) {
            int fibonacciMax = Integer.parseInt(args[0]);
            System.out.println(fibonacci(fibonacciMax));
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public static BigInteger fibonacci(int number) {

        if (number <= 1) {
            return ZERO;
        }

        BigInteger x = ONE;
        BigInteger y = ZERO;
        BigInteger z;
        for (int i = 1; i < number; i++) {
            z = x.sum(y);
            y = x;
            x = z;
        }
        return x;
    }
}
