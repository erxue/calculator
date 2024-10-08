public class Calculator {

    public Calculator() {}

    public Number calculate(Operation o, double a, double b) {
        Number n = new Number(o.perform(a , b));
        Number.checkOverflow(n.getValue());
        return n;
    }

}

class Number {
    double value;

    public Number(double d) {
        value = d;
    }

    public double getValue() {
        return value;
    }

    public Number calculate(Operation o, double d) {
        value = o.perform(value, d);
        checkOverflow(value);
        return this;
    }

    public static void checkOverflow(double d) {
        if (d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY || d >= Double.MAX_VALUE || d <= Double.MIN_VALUE) {
            throw new ArithmeticException("Overflow occurred");
        }
    }
}