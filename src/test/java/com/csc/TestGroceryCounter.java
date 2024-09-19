package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGroceryCounter {

    GroceryCounter counter;

    @BeforeEach
    void setUp() {
        counter = new GroceryCounter();
    }

    @Test
    void testInitialTotal() {
        assertEquals("$00.00", counter.total());  // Ensure two digits in the dollar part
    }

    @Test
    void testIncrementTens() {
        counter.tens();
        counter.tens();
        assertEquals("$20.00", counter.total());
    }

    @Test
    void testIncrementOnes() {
        counter.ones();
        counter.ones();
        assertEquals("$02.00", counter.total());  // Ensure leading zeros
    }

    @Test
    void testIncrementHundredths() {
        counter.hundredths();
        assertEquals("$00.01", counter.total());
    }

    @Test
    void testOverflow() {
        for (int i = 0; i < 100; i++) {
            counter.ones();
        }
        assertEquals(1, counter.number_of_overflows());
    }

    @Test
    void testClear() {
        counter.tens();
        counter.clear();
        assertEquals("$00.00", counter.total());  // Ensure leading zeros
        assertEquals(0, counter.number_of_overflows());
    }
}
