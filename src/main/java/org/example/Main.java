package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Main class for the application. */
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    /**
     * Main method to run the application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        log.info("Hello world!");

        for (int i = 1; i <= 5; i++) {
            log.info("Iteration: {}", i);
        }
        log.info("End of loop");
    }

    /**
     * Adds two integers.
     *
     * @param a first integer
     * @param b second integer
     * @return sum of a and b
     */
    public static int add(int a, int b) {
        log.trace("Adding {} and {}", a, b);
        return a + b;
    }
}
