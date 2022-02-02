public enum Denomination {

    FIVE(5.0),
    TEN(10.0),
    FIFTY(50.0),
    HUNDRED(100.0);

    private final double value;

    Denomination(double value) {
        this.value = value;
    }

    public double getValue() { return value; }
}
