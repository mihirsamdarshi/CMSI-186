public class DynamicChangeMaker {

    public static final Tuple IMPOSSIBLE = new Tuple(new int[0]);
    private int[] denominations;
    private int product;
    public Tuple[][] table;

    public DynamicChangeMaker(int[] values, int wantedChange) {
        this.denominations = values;
        this.product = wantedChange;

        if (product < 0) {
            throw new IllegalArgumentException("Please input a valid non negative integer for wanted change");
        }

        for (int i = 0; i < denominations.length; i++) {
            if (denominations[i] <= 0) {
                throw new IllegalArgumentException("Please input a valid positive integer for denomintations");
            }
            for (int j = i + 1 ; j < denominations.length; j++) {
                if (denominations[i] == denominations[j]) {
                    throw new IllegalArgumentException("You have duplicate denominations, please correct this and try again");
                }
            }
        }
        this.table = new Tuple[denominations.length][product +1];
    }

    public static boolean isImpossible(Tuple tuple) {
        if (tuple == IMPOSSIBLE) {
            return true;
        } else {
            return false;
        }
    }

    public void solveTable() {
        int rows = denominations.length;
        int columns = product;

        //initialize each row w/ the # of denominations
        for (int i = 0; i < rows; i++) {
            table[i][0] = new Tuple(rows);
        }

        for (int currentRow = 0; currentRow < rows; currentRow++) {
            for (int currentColumn = 1; currentColumn <= columns; currentColumn++) {
                Tuple t = new Tuple(rows);

                //set current row element to 1 to start off/test
                t.setElement(currentRow, 1);
                int difference = currentColumn - totalValue(t, denominations);
                if (difference > 0) {
                    t = isImpossible(table[currentRow][difference]) ? IMPOSSIBLE : t.add(table[currentRow][difference]);
                } else if (difference < 0) {
                    t = IMPOSSIBLE;
                }

                table[currentRow][currentColumn] = t;

                if (currentRow > 0) {
                    Tuple rowAbove = table[currentRow - 1][currentColumn];
                    if (isImpossible(rowAbove) == false) {
                        if (isImpossible(t) == true) {
                            table[currentRow][currentColumn] = rowAbove;
                        }  else {
                            if (t.sum() > rowAbove.sum())
                            table[currentRow][currentColumn] = rowAbove;
                        }
                    }
                }
            }
        }
    }

    public static int totalValue(Tuple tuple, int[] denominations) {
        int total = 0;
        for (int i = 0; i < tuple.length(); i++) {
            total += tuple.getElement(i) * denominations[i];
        }
        return total;
    }

    public Tuple getSolution() {
        return table[denominations.length - 1][product];
    }

    public static void main(String[] args) {
        try {
            int[] denominations = new int[args.length-1];
            int values = Integer.parseInt(args[args.length - 1]);
            for (int i = 0; i < args.length - 1; i++) {
                denominations[i] = Integer.parseInt(args[i]);
            }

            DynamicChangeMaker runningChangeMaker = new DynamicChangeMaker(denominations, values);
            runningChangeMaker.solveTable();
            Tuple change = runningChangeMaker.getSolution();

            if (change == IMPOSSIBLE) {
                System.out.println("Change cannot be created from the inputs given");
            } else {
                int coinTotal = change.sum();
                String returnVal = "";
                for (int i = 0; i < denominations.length; i++) {
                    int coinVal = change.getElement(i);
                    returnVal += coinVal + " " + denominations[i] + "-cent coins \n";
                }
                System.out.println(returnVal);
                System.out.println("Total coins: " + coinTotal);
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Please input a sequence of coin denominations as positive integers, followed by the amount of change being made as a positive integer");
        }
    }
}
