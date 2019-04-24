public class BigInteger {
    //TODO: remainder NEGATIVE NUMBERS

//Class-wide vars
    private byte sign;
    private int[] values;

//Constants
    public static final BigInteger ZERO = new BigInteger("0");
    public static final BigInteger ONE = new BigInteger("1");
    public static final BigInteger NEGATIVE_ONE = new BigInteger("-1");
    public static final BigInteger TWO = new BigInteger("2");
    public static final BigInteger FIVE = new BigInteger("5");
    public static final BigInteger TEN = new BigInteger("10");

//Constructor
    public BigInteger(String val) {
        try {
            if (val.length() > 0) {
                removeExtraneousCharacters(val);
                determineSign(val);
                val = removeZeroes(val);
                createArray(val);
            }
        } catch (java.lang.UnsupportedOperationException e) {
             System.out.println("Please input a valid large number.");
        }
    }

    public BigInteger(long val) {
        if (val > 0) {
            sign = 1;
        } else if (val < 0) {
            sign = -1;
        } else if (val == 0) {
            sign = 0;
        } else {
            throw new UnsupportedOperationException();
        }
        String convertString = String.valueOf(val);
        convertString = removeZeroes(convertString);
        createArray(convertString);
    }

//All methods used in Constructor
    public String removeExtraneousCharacters(String val) {
        val = val.trim();
        val = val.replaceAll("[^\\d-]", "");
        if (val.length() == 0) {
            throw new UnsupportedOperationException();
        }
        return val;
    }

    public String determineSign(String val) {
        if (val.substring(0,1).equals("-")) {
            sign = -1;
            val = val.substring(1);
        } else if (val.length() == 1 && val.substring(0,1).equals("0")) {
            sign = 0;
        } else {
            sign = 1;
        }
        return val;
    }

    public String removeZeroes(String val) {

        while(val.length() > 1 && val.charAt(0) == '0') {
            val = val.substring(1);
        }
        return val;
    }

    public void createArray(String val) {

        val = val.replaceAll("\\D+","");

        int length = val.length();
        this.values = new int[length];

        for(int i = 0; i < length; i++) {
            try {
            this.values[(length - 1) - i] = java.lang.Character.getNumericValue(val.charAt(i));
            } catch (UnsupportedOperationException uoe) {
                System.out.println("input a number");
            }
        }
    }

//All Arithmetic Methods
    public BigInteger sum(BigInteger val) {

        BigInteger bigger;
        BigInteger smaller;

        if (this.compareMagnitude(val) == 1) {
            bigger = this;
            smaller = val;
        } else if (this.equals(val.additiveInverse())) {
            return ZERO;
        } else {
            bigger = val;
            smaller = this;
        }

        if (bigger.sign == 1 && smaller.sign == -1) {
            smaller.abs();
            BigInteger tempBigInt = bigger.difference(smaller);
            return tempBigInt;
        } else if (bigger.sign == -1 && smaller.sign == 1) {
            bigger.abs();
            BigInteger tempBigInt = bigger.difference(smaller);
            return tempBigInt.additiveInverse();
        }

        int biggerLength = bigger.values.length;
        int smallerLength = smaller.values.length;
        StringBuilder tempString = new StringBuilder(); //from: https://stackoverflow.com/questions/5884353/insert-a-character-in-a-string-at-a-certain-position

        boolean carry = false;
        for (int i = 0; i < biggerLength; i++) {
            int tempNum = bigger.values[i];
            if (i < smallerLength) {
                tempNum += smaller.values[i];
            }
            if (carry == true) {
                tempNum += 1;
                carry = false;
            }
            if (tempNum > 9) {
                carry = true;
            }
            tempString.insert(0, tempNum % 10);
        }
        if (carry == true) {
            tempString.insert(0, 1);
        }
        BigInteger tempBigInt = new BigInteger(tempString.toString());
        if (bigger.sign == -1 && smaller.sign == -1) {
            return tempBigInt.additiveInverse();
        }
        return tempBigInt;
    }

    public BigInteger difference(BigInteger val) {

        BigInteger bigger;
        BigInteger smaller;

        if (this.equals(ZERO)) {
            val.opposite();
            return val;
        }

        if (this.sign == -1 || val.sign == -1) {
            if (this.sign == 1 && val.sign == -1) {
                val.abs();
                BigInteger tempBigInt = this.sum(val);
                return tempBigInt;
            } else if (this.sign == -1 && val.sign == 1) {
                this.abs();
                BigInteger tempBigInt = this.sum(val);
                return tempBigInt.additiveInverse();
            } else {
                this.abs();
                val.abs();
                BigInteger tempBigInt = val.difference(this);
                return tempBigInt;
            }
        }

        boolean setNegative = false;
        if (this.compareWith(val) == 1) {
            bigger = this;
            smaller = val;
        } else if (this.compareWith(val) == -1) {
            bigger = val;
            smaller = this;
            setNegative = true;
        } else {
            return ZERO;
        }

        int biggerLength = bigger.values.length;
        int smallerLength = smaller.values.length;
        StringBuilder tempString = new StringBuilder(); //from: https://stackoverflow.com/questions/5884353/insert-a-character-in-a-string-at-a-certain-position

        boolean borrow = false;
        for (int i = 0; i < biggerLength; i++) {
            int tempNum = bigger.values[i];
            if (borrow == true) {
                tempNum -= 1;
                borrow = false;
            }
            if (i < smallerLength) {
                tempNum -= smaller.values[i];
            }
            if (tempNum < 0) {
                borrow = true;
                tempNum += 10;
            }
            tempString.insert(0, tempNum % 10);
        }
        BigInteger tempBigInt = new BigInteger(tempString.toString());
        if (setNegative == true) {
            return tempBigInt.additiveInverse();
        }
        return tempBigInt;
    }

    public BigInteger product(BigInteger val) {

        boolean setNegative = false;
        if (this.sign == -1 || val.sign == -1) {
            if (this.sign != -1) {
                setNegative = true;
            }
            if (val.sign != -1) {
                setNegative = true;
            }
        }

        if (this.equals(ZERO) || val.equals(ZERO)) {
            return ZERO;
        } else if (this.equals(ONE)) {
            return val;
        } else if (val.equals(ONE)) {
            return this;
        } else if (val.equals(NEGATIVE_ONE)) {
            return this.additiveInverse();
        } else if (this.equals(NEGATIVE_ONE)) {
            return val.additiveInverse();
        } else if (val.equals(TWO)) {
            return this.duplicate();
        } else if (this.equals(TWO)) {
            return val.duplicate();
        }

        BigInteger bigger;
        BigInteger smaller;

        if (this.compareWith(val) == 1) {
            bigger = this;
            smaller = val;
        } else {
            bigger = val;
            smaller = this;
        }

        bigger.abs();
        smaller.abs();

        BigInteger aggregate = ZERO;

        if (smaller.values[0] % 2 != 0) {
            aggregate = bigger;
        }

        while (smaller.compareWith(ONE) != 0) {
            bigger = bigger.duplicate();
            smaller = smaller.halve();
            if (smaller.values[0] % 2 != 0) {
                aggregate = aggregate.sum(bigger);
            }
        }
        if (setNegative == true) {
            return aggregate.additiveInverse();
        }
        return aggregate;
    }

    public BigInteger quotient(BigInteger val) {

        if (val.equals(ZERO)) {
            throw new UnsupportedOperationException("Can't divide by zero");
        } else if (val.equals(ONE)) {
            return this;
        }

        boolean setNegative = false;
        if (this.sign == -1 || val.sign == -1) {
            if (this.sign != -1) {
                setNegative = true;
            }
            if (val.sign != -1) {
                setNegative = true;
            }
        }

        BigInteger dividend = this;
        BigInteger divisor = val;
        BigInteger tempDivisor = val;

        dividend.abs();
        divisor.abs();

        BigInteger result = ONE;

        if (val.equals(TWO)) {
            return this.halve();
        } else if (this.compareWith(val) == -1) {
            return ZERO;
        }  else if (this.difference(val).compareWith(val) == -1) {
            return ONE;
        } else {
            while (tempDivisor.product(TEN).compareWith(dividend) == -1) {
                tempDivisor = tempDivisor.product(TEN);
                result = result.product(TEN);
            }
            BigInteger remainderDivision = dividend.difference(tempDivisor);
            result = result.sum(remainderDivision.quotient(divisor));
            if (setNegative == true) {
                return result.additiveInverse();
            }
            return result;
        }
    }

    public BigInteger remainder(BigInteger val) {
        BigInteger quotient = this.quotient(val);
        BigInteger quotientValProduct = quotient.product(val);
        BigInteger result = this.difference(quotientValProduct);
        return result;
    }

//other Arithmetic methods
    public BigInteger halve() {
        StringBuilder tempString = new StringBuilder();
        int bigIntLength = this.values.length;
        int carry = 0;
        for (int i = bigIntLength - 1; i >= 0; i--) {
            int tempNum = this.values[i] / 2;
            tempNum += carry;
                if (this.values[i] % 2 == 1) {
                    carry = 5;
                } else {
                    carry = 0;
                }
                tempString.insert(tempString.length(), tempNum);
            }
        return new BigInteger(tempString.toString());
    }

    public BigInteger duplicate() {
        BigInteger doubledVal = this;
        doubledVal = doubledVal.sum(this);
        return doubledVal;
    }

//tostring method
    public String toString() {
        String output = "";
        for(int value: values) { //from: https://www.cis.upenn.edu/~matuszek/General/JavaSyntax/enhanced-for-loops.html
            output = value + output;
        }

        switch(sign) {
            case 1: output = "" + output;
            break;
            case -1: output = "-" + output;
            break;
            case 0: output = "" + output;
            break;
        }
        return output;
    }

//comparative methods
    public int compareWith(BigInteger val) {
        if (this.equals(val)) {
            return 0;
        }
        if (val.sign == -1 && this.sign == 1) {
            return 1;
        } else if (val.sign == 1 && this.sign == -1) {
            return -1;
        }
        if (this.values.length < val.values.length) {
            return -1;
        } else if (this.values.length > val.values.length) {
            return 1;
        }

        if (this.sign == 1) {
            int stringLength = val.values.length;
            for (int i = (stringLength - 1); i >= 0; i--) {
                if (this.values[i] > val.values[i]) {
                    return 1;
                } else if (this.values[i] < val.values[i]) {
                    return -1;
                }
            }
        } else if (this.sign == -1) {
            int stringLength = val.values.length;
            for (int i = (stringLength - 1); i >= 0; i--) {
                if (this.values[i] > val.values[i]) {
                    return -1;
                } else if (this.values[i] < val.values[i]) {
                    return 1;
                }
            }
        }
        return 1;
    }

    public int compareMagnitude(BigInteger val) {
        if (val.values.length < this.values.length) {
            return 1;
        } else if (val.values.length > this.values.length) {
            return -1;
        } else if (val.values.length == this.values.length) {
            int stringLength = val.values.length;
            for (int i = (stringLength - 1); i >= 0; i--) {
                if (this.values[i] > val.values[i]) {
                    return 1;
                } else if (this.values[i] < val.values[i]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        if (obj.toString().length() != this.toString().length()) {
            return false;
        }
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        BigInteger comparator = (BigInteger)obj;
        return (this.toString().equals(comparator.toString()));
    }

    public static BigInteger valueOf(long val) {
        BigInteger longBigInt = new BigInteger(val);
        return longBigInt;
    }


//sign setter/getter methods
    public void setSign(byte sign) {
            this.sign = sign;
    }

    public void opposite() {
        if (this.sign == 1) {
            this.sign = -1;
        } else if (this.sign == -1) {
            this.sign = 1;
        } else {
            this.sign = 0;
        }
    }

    public void abs() {
        this.sign = 1;
    }

    public BigInteger additiveInverse() {
        BigInteger val = new BigInteger(this.toString());
        val.opposite();
        return val;
    }
}
