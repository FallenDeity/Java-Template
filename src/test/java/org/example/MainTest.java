package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void add() {
        log.info("Testing add method");
        assertEquals(5, Main.add(2, 3), "2 + 3 should equal 5");
        assertEquals(0, Main.add(-1, 1), "-1 + 1 should equal 0");
        assertEquals(-2, Main.add(-1, -1), "-1 + -1 should equal -2");
        assertEquals(0, Main.add(0, 0), "0 + 0 should equal 0");
        assertEquals(10, Main.add(5, 5), "5 + 5 should equal 10");
        log.info("add method test passed");
    }
}
