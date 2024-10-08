public enum Operation {
    ADD {
        @Override
        double perform(double a, double b) {
            return a + b;
        }
    },
    SUBTRACT {
        @Override
        double perform(double a, double b) {
            return a - b;
        }
    },
    MULTIPLY {
        @Override
        double perform(double a, double b) {
            return a * b;
        }
    },
    DIVIDE {
        @Override
        double perform(double a, double b) {
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return a / b;
        }
    };

    abstract double perform(double a, double b);
};