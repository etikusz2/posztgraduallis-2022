public class FractionalNumbersOperation {
    private int numer, denom;

    public FractionalNumbersOperation(int numer, int denom) {
       this.numer = numer;
       this.denom = denom;
    }

    public int getNumerator() {
        return numer;
    }

    public int getDenominator() {
        return denom;
    }

    public FractionalNumbersOperation add(FractionalNumbersOperation other) {
        int n = numer * other.denom + other.numer * denom;
        int d = denom * other.denom;
        return new FractionalNumbersOperation(n, d);
    }

    public FractionalNumbersOperation sub(FractionalNumbersOperation other) {
        int n = numer * other.denom + other.numer * denom;
        int d = denom * other.denom;
        return new FractionalNumbersOperation(n, d);
    }

    public FractionalNumbersOperation multiply(FractionalNumbersOperation other) {
        int n = numer * other.numer;
        int d = denom * other.denom;
        return new FractionalNumbersOperation(n, d);
    }

    public FractionalNumbersOperation division(FractionalNumbersOperation other) {
        int n = numer * other.denom;
        int d = denom * other.numer;
        return new FractionalNumbersOperation(n, d);
    }

    public String toString() {
        return numer + " / " + denom;
    }
}
