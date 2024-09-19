package com.csc;

public class GroceryCounter {
    // Variables to track each digit and the overflow count
    private int tens;
    private int ones;
    private int tenths;
    private int hundredths;
    private int overflowCount;

    // Constructor initializes the counter to 0000 and the overflow count to 0
    public GroceryCounter() {
        this.tens = 0;
        this.ones = 0;
        this.tenths = 0;
        this.hundredths = 0;
        this.overflowCount = 0;
    }

    // Method to increment the tens place
    public void tens() {
        tens++;
        checkOverflow();
    }

    // Method to increment the ones place
    public void ones() {
        ones++;
        checkOverflow();
    }

    // Method to increment the tenths place
    public void tenths() {
        tenths++;
        checkOverflow();
    }

    // Method to increment the hundredths place
    public void hundredths() {
        hundredths++;
        checkOverflow();
    }

    // Method to check for overflow and reset digits accordingly
    private void checkOverflow() {
        if (hundredths >= 10) {
            hundredths = 0;
            tenths++;
        }
        if (tenths >= 10) {
            tenths = 0;
            ones++;
        }
        if (ones >= 10) {
            ones = 0;
            tens++;
        }
        if (tens >= 10) {
            tens = 0;
            overflowCount++;
        }
    }

    // Method to return the total amount as a formatted string
    public String total() {
        return String.format("$%02d.%02d", (tens * 10) + ones, (tenths * 10) + hundredths);
    }

    // Method to return the number of overflows
    public int number_of_overflows() {
        return overflowCount;
    }

    // Method to clear the counter and reset the overflow count
    public void clear() {
        this.tens = 0;
        this.ones = 0;
        this.tenths = 0;
        this.hundredths = 0;
        this.overflowCount = 0;
    }
}
