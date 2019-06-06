import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    private Human testDummy = new Human("TD", "none", 21);
    private OutputStream outSpy;

    @BeforeEach
    void setUp() {
        outSpy = new ByteArrayOutputStream();
        PrintStream printSpy = new PrintStream(outSpy);
        System.setOut(printSpy);
    }

    @AfterEach
    void breakDown() {
        PrintStream originalOut = System.out;
        System.setOut(originalOut);
    }

    @Test
    void isAdult() {
        assert (testDummy.isAdult());
    }

    @Test
    void getName() {
        assertEquals ("TD", testDummy.getName());
    }

    @Test
    void thumbsUp() {
        setUp();
        testDummy.thumbsUp();
        assertEquals("\uD83D\uDC4D\r\n", outSpy.toString());
        breakDown();
    }

    @Test
    void eat() {
        setUp();
        testDummy.eat();
        assertEquals("Om nom nom...\r\n", outSpy.toString());
        breakDown();
    }

    @Test
    void sleep() {
        setUp();
        testDummy.sleep();
        assertEquals("Zzzzzz...\r\n", outSpy.toString());
        breakDown();
    }

    @Test
    void move() {
        setUp();
        testDummy.move();
        assertEquals("Walking...\r\n", outSpy.toString());
        breakDown();
    }

    @Test
    void sound() {
        setUp();
        testDummy.sound();
        assertEquals("Hi, my name is TD\r\n", outSpy.toString());
        breakDown();
    }

    @Test
    void getBusy() {
        setUp();
        testDummy.getBusy();
        assertEquals("Bow chicka wow wow...\r\n", outSpy.toString());
        breakDown();
    }

    @Test
    void getGender() {
        assertEquals("none", testDummy.getGender());
    }

    @Test
    void getAge() {
        assertEquals(21, testDummy.getAge());
    }

}