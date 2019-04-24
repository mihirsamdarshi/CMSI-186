public class GCD {

    public static final BigInteger ZERO = new BigInteger("0");

    public static void main(String args[]) {
        if (args.length == 2) {
            BigInteger argOne = new BigInteger(args[0]);
            BigInteger argTwo = new BigInteger(args[1]);
            System.out.println(gCD(argOne, argTwo));

        } else {
            throw new UnsupportedOperationException();
        }
    }

    //euclid's algorithims
    private static BigInteger gCD(BigInteger number1, BigInteger number2) {
        if (number2.equals(ZERO)) {
            return number1;
        }
        return gCD(number2, number1.remainder(number2));
    }

}
