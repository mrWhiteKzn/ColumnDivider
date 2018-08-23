package com.foxminded.dmitriy.task3.integerDivision.tests;

import com.foxminded.dmitriy.task3.integerDivision.Divider;
import com.foxminded.dmitriy.task3.integerDivision.DivisionProcessData;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;


public class DividerTest {
    private Divider divider;
    private DivisionProcessData expected;
    private DivisionProcessData actual;

    @Before
    public void setUp() {
        divider = new Divider();
        expected = new DivisionProcessData();
        actual = new DivisionProcessData();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenDivideWithZeroDivisor() {
        expected = divider.divide(554646, 0);
    }

    @Test
    public void whenDivideWithAllNegativeNumbers() {
        actual = divider.divide(-664664, -15);

        expected.setDividend(-664664);
        expected.setDivisor(-15);
        expected.setResult(44310);
        expected.addMinuend(64);
        expected.addMinuend(46);
        expected.addMinuend(16);
        expected.addMinuend(14);

        expected.addSubtrahend(60);
        expected.addSubtrahend(60);
        expected.addSubtrahend(45);
        expected.addSubtrahend(15);
        expected.addSubtrahend(0);
        expected.setRemainder(14);

        assertThat(expected, samePropertyValuesAs(actual));
    }

    @Test
    public void whenDivideWithAllPositiveNumbers() {
        actual = divider.divide(4949994, 32);

        expected.setDividend(4949994);
        expected.setDivisor(32);
        expected.setResult(154687);
        expected.addMinuend(174);
        expected.addMinuend(149);
        expected.addMinuend(219);
        expected.addMinuend(279);
        expected.addMinuend(234);

        expected.addSubtrahend(32);
        expected.addSubtrahend(160);
        expected.addSubtrahend(128);
        expected.addSubtrahend(192);
        expected.addSubtrahend(256);
        expected.addSubtrahend(224);
        expected.setRemainder(10);

        assertThat(expected, samePropertyValuesAs(actual));
    }

    @Test
    public void whenDivideWhereDividendLessThenDivisor() {
        actual = divider.divide(123, 1234);

        expected.setDividend(123);
        expected.setDivisor(1234);
        expected.setResult(0);

        expected.addSubtrahend(0);
        expected.setRemainder(123);

        assertThat(expected, samePropertyValuesAs(actual));
    }

    @Test
    public void whenDivideAndDivisorIsNegative() {
        actual = divider.divide(664664, -15);

        expected.setDividend(664664);
        expected.setDivisor(-15);
        expected.setResult(-44310);
        expected.addMinuend(64);
        expected.addMinuend(46);
        expected.addMinuend(16);
        expected.addMinuend(14);

        expected.addSubtrahend(60);
        expected.addSubtrahend(60);
        expected.addSubtrahend(45);
        expected.addSubtrahend(15);
        expected.addSubtrahend(0);
        expected.setRemainder(14);

        assertThat(expected, samePropertyValuesAs(actual));
    }

    @Test
    public void whenDivideAndDividendIsNegative() {
        actual = divider.divide(-664664, 15);

        expected.setDividend(-664664);
        expected.setDivisor(15);
        expected.setResult(-44310);
        expected.addMinuend(64);
        expected.addMinuend(46);
        expected.addMinuend(16);
        expected.addMinuend(14);

        expected.addSubtrahend(60);
        expected.addSubtrahend(60);
        expected.addSubtrahend(45);
        expected.addSubtrahend(15);
        expected.addSubtrahend(0);
        expected.setRemainder(14);

        assertThat(expected, samePropertyValuesAs(actual));
    }
}
