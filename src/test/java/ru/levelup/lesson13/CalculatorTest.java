package ru.levelup.lesson13;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest{

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(100, calculator.multiply(10, 10));
        Assert.assertEquals(-100, calculator.multiply(10, -10));
        Assert.assertEquals(63, calculator.multiply(9, 7));
        Assert.assertEquals(99, calculator.multiply(9, 11));
    }
}
