import static org.junit.jupiter.api.Assertions.*;

class FunctionsTest {

    @org.junit.jupiter.api.Test
    void add() {
        assertEquals(3, Functions.add(2, 1));
    }

    @org.junit.jupiter.api.Test
    void subtract() {
        assertEquals(1, Functions.subtract(2,1));
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        assertEquals(2, Functions.multiply(2,1));
    }

    @org.junit.jupiter.api.Test
    void divide() {
        assertEquals(2,Functions.divide(2,1));
    }
}