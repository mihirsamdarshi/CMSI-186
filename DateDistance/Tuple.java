public class Tuple {

    private int[] values;

    public Tuple (int k) {
        this.values = new int[k];
        for (int i = 0; i < k; i++) {
            values[i] = 0;
        }
    }

    public Tuple (int[] data) {
        this.values = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            values[i] = data[i];
        }
    } // Constructs a tuple from the provided array data.

    public int length() {
        return this.values.length;
    }

    public int getElement (int i) {
        if (i < 0 || i > this.length() - 1) {
            throw new IllegalArgumentException();
        } else {
            return this.values[i];
        }
    }

    public void setElement (int i, int value) {
        if (i < 0 || i > this.length() - 1) {
            throw new IllegalArgumentException();
        } else {
            this.values[i] = value;
        }
    }

    public static Tuple makeTupleFromData (int[] data) {
        return new Tuple(data);
    }

    public Tuple add (Tuple t) {
        if (t.values.length != this.length()) {
            throw new IllegalArgumentException();
        }
        Tuple temp = new Tuple(this.length());
        for (int i = 0; i < this.length(); i++) {
            int tempVal = this.getElement(i) + t.getElement(i);
            temp.setElement(i, tempVal);
        }
        return temp;
    }

    public int sum() {
        int output = 0;
        for (int i = 0; i < this.length(); i++) {
            output += this.values[i];
        }
        return output;
    } // Returns the sum of the elements in this tuple.

    public Tuple clone() {
        Tuple temp = new Tuple(this.length());
        for (int i = 0; i < this.length(); i++) {
            int tempVal = this.getElement(i);
            temp.setElement(i, tempVal);
        }
        return temp;
    }

    public String toString() {
        String output = "[";
        for (int i = 0; i < this.length(); i++) {
            output += getElement(i);
            if (i != this.length() - 1) {
                output += ",";
            }
        }
        output += "]";
        return output;
    } // Returns the string that denotes this tuple, e.g., [2,-1,0,5].

    public boolean equals (Object obj) {
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
        Tuple comparator = (Tuple)obj;
        return (this.toString().equals(comparator.toString()));
    } // Returns true if obj is a tuple which has the same length and same elements in the same order as this tuple.
}
