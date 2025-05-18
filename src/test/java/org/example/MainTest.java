package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MainTest {
    private static final Logger log = LoggerFactory.getLogger(MainTest.class);

    @BeforeEach
    void setUp() {}

    @AfterEach
    void tearDown() {}

    @Test
    void testMain() {
        log.info("Testing main method");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out, true, StandardCharsets.UTF_8));
        Main.main(new String[] {});
        String output = out.toString(StandardCharsets.UTF_8);
        System.setOut(System.out); // reset to original System.out
        String[] expectedLines = {
            "Hello world!",
            "Iteration: 1",
            "Iteration: 2",
            "Iteration: 3",
            "Iteration: 4",
            "Iteration: 5",
            "End of loop"
        };
        for (String expectedLine : expectedLines) {
            assertTrue(output.contains(expectedLine), "Output should contain: " + expectedLine);
        }
        log.info("main method test passed");
    }

    @Test
    void testAdd() {
        log.info("Testing add method");
        assertEquals(5, Main.add(2, 3), "2 + 3 should equal 5");
        assertEquals(0, Main.add(-1, 1), "-1 + 1 should equal 0");
        assertEquals(-2, Main.add(-1, -1), "-1 + -1 should equal -2");
        assertEquals(0, Main.add(0, 0), "0 + 0 should equal 0");
        assertEquals(10, Main.add(5, 5), "5 + 5 should equal 10");
        log.info("add method test passed");
    }
}
