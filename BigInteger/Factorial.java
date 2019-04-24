public class Factorial {

    public static final BigInteger ZERO = new BigInteger("0");
    public static final BigInteger ONE = new BigInteger("1");

    public static void main(String[] args) {
        if (args.length > 1) {
            throw new UnsupportedOperationException("Please input a valid integer arguement.");
        } else {
            long longInput = Long.valueOf(args[0]);
            BigInteger factorial = new BigInteger(longInput);
            BigInteger total = factorial;
            while (!(factorial.equals(ONE))) {
                BigInteger secondNumber = factorial.difference(ONE);
                total = total.product(secondNumber);
                factorial = factorial.difference(ONE);
            }
            System.out.println(total);
        }
    }
}
