import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void TestAdd() {
        Calculator calc = new Calculator();
        double a = 2;
        double b = 3;
        double value = calc.calculate(Operation.ADD, a, b).getValue();
        assertEquals(5, value);
        System.out.println(String.format("\nTestAdd results: %f + %f = %f", a, b, value));
    }

    @Test
    public void TestSubtract() {
        Calculator calc = new Calculator();
        double a = 5;
        double b = 1;
        double value = calc.calculate(Operation.SUBTRACT, a, b).getValue();
        assertEquals(4, value);
        System.out.println(String.format("\nTestSubtract results: %f - %f = %f", a, b, value));
    }

    @Test
    public void TestMultiply() {
        Calculator calc = new Calculator();
        double a = 2;
        double b = 3;
        double value = calc.calculate(Operation.MULTIPLY, a, b).getValue();
        assertEquals(6, value);
        System.out.println(String.format("\nTestMultiply results: %f * %f = %f", a, b, value));
    }

    @Test
    public void TestDivide() {
        Calculator calc = new Calculator();
        double a = 7;
        double b = 2;
        double value = calc.calculate(Operation.DIVIDE, a, b).getValue();
        assertEquals(3.5, value);
        System.out.println(String.format("\nTestDivide results: %f / %f = %f", a, b, value));
    }
    
    @Test
    public void TestChain() {
        Calculator calc = new Calculator();
        double a = 10, b = 1, c = 2, d = 3, e = 4;
        double value = calc.calculate(Operation.ADD, a, b).calculate(Operation.SUBTRACT, c).calculate(Operation.MULTIPLY, d).calculate(Operation.DIVIDE, e).getValue();
        assertEquals(6.75, value);
        System.out.println(String.format("\nTestChain results: (%f + %f - %f) * %f / %f = %f", a, b, c, d, e, value));
    }

    @Test
    public void TestDivideByZero() {
        Calculator calc = new Calculator();

        Exception thrown = assertThrows(
            ArithmeticException.class,
            () -> calc.calculate(Operation.DIVIDE, 10, 0),
            "Dividing by zero did not throw an exception"
        );

        assertTrue(thrown.getMessage().contains("Division by zero"));
        System.out.println(String.format("\nTestDivideByZero results: %s", thrown.getMessage()));
    }

    @Test
    public void TestChainDivideByZero() {
        Calculator calc = new Calculator();
        double a = 10;
        double b = 0;

        Exception thrown = assertThrows(
            ArithmeticException.class,
            () -> calc.calculate(Operation.DIVIDE, a, b),
            "Dividing by zero did not throw an exception"
        );

        assertTrue(thrown.getMessage().contains("Division by zero"));
        System.out.println(String.format("\nTestChainDivideByZero (%f / %f) results: %s", a, b, thrown.getMessage()));
    }

    @Test
    public void TestOverflow() {
        Calculator calc = new Calculator();
        double a = Double.MAX_VALUE, b = -Double.MAX_VALUE;

        Exception thrown = assertThrows(
            ArithmeticException.class,
            () -> calc.calculate(Operation.ADD, a, a),
            "Overflow did not throw an exception"
        );

        assertTrue(thrown.getMessage().contains("Overflow occurred"));
        System.out.println(String.format("\nTestOverflow (%f + %f) results: %s", a, a, thrown.getMessage()));

        thrown = assertThrows(
            ArithmeticException.class,
            () -> calc.calculate(Operation.SUBTRACT, b, a),
            "Overflow did not throw an exception"
        );

        assertTrue(thrown.getMessage().contains("Overflow occurred"));
        System.out.println(String.format("\nTestOverflow (%f - %f) results: %s", b, a, thrown.getMessage()));
    }
}
