package com.foxminded.dmitriy.task3.integerDivision.tests;

import com.foxminded.dmitriy.task3.integerDivision.ColumnFormatter;
import com.foxminded.dmitriy.task3.integerDivision.DivisionProcessData;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColumnFormatterTest {

    private DivisionProcessData data;
    private ColumnFormatter formatter;

    @Before
    public void setup() {
        data = new DivisionProcessData();
        formatter = new ColumnFormatter();
    }

    @Test
    public void whenFormatWithPositiveData() {
        data.setDividend(78945);
        data.setDivisor(4);
        data.setRemainder(1);
        data.setResult(19736);

        data.addMinuend(38);
        data.addMinuend(29);
        data.addMinuend(14);
        data.addMinuend(25);

        data.addSubtrahend(4);
        data.addSubtrahend(36);
        data.addSubtrahend(28);
        data.addSubtrahend(12);
        data.addSubtrahend(24);

        String actual = formatter.format(data);
        String expected = "_78945|4\n" +
                " 4    |-----\n" +
                " -    |19736\n" +
                "_38\n" +
                " 36\n" +
                " --\n" +
                " _29\n" +
                "  28\n" +
                "  --\n" +
                "  _14\n" +
                "   12\n" +
                "   --\n" +
                "   _25\n" +
                "    24\n" +
                "    --\n" +
                "     1";
        assertEquals(expected, actual);
    }

    @Test
    public void whenFormatWithNegativeData() {
        data.setDividend(-78945);
        data.setDivisor(-4);
        data.setRemainder(1);
        data.setResult(19736);

        data.addMinuend(38);
        data.addMinuend(29);
        data.addMinuend(14);
        data.addMinuend(25);

        data.addSubtrahend(4);
        data.addSubtrahend(36);
        data.addSubtrahend(28);
        data.addSubtrahend(12);
        data.addSubtrahend(24);

        String actual = formatter.format(data);
        String expected = "_-78945|-4\n" +
                "  4    |-----\n" +
                "  -    |19736\n" +
                " _38\n" +
                "  36\n" +
                "  --\n" +
                "  _29\n" +
                "   28\n" +
                "   --\n" +
                "   _14\n" +
                "    12\n" +
                "    --\n" +
                "    _25\n" +
                "     24\n" +
                "     --\n" +
                "      1";
        assertEquals(expected, actual);
    }

    @Test
    public void whenFormatNegativeDataWithDivisorHasTwoDigits() {
        data.setDividend(-3899);
        data.setDivisor(-30);
        data.setRemainder(29);
        data.setResult(129);

        data.addMinuend(89);
        data.addMinuend(299);

        data.addSubtrahend(30);
        data.addSubtrahend(60);
        data.addSubtrahend(270);

        String actual = formatter.format(data);
        String expected = "_-3899|-30\n" +
                "  30  |---\n" +
                "  --  |129\n" +
                "  _89\n" +
                "   60\n" +
                "   --\n" +
                "  _299\n" +
                "   270\n" +
                "   ---\n" +
                "    29";
        assertEquals(expected, actual);
    }

    @Test
    public void whenFormatWhereDividendEqualsDivisor() {
        data.setDividend(10);
        data.setDivisor(10);
        data.setRemainder(0);
        data.setResult(1);

        data.addSubtrahend(10);

        String actual = formatter.format(data);
        String expected = "_10|10\n" +
                " 10|-\n" +
                " --|1\n" +
                "  0";
        assertEquals(expected, actual);
    }

    @Test
    public void whenDivideAndSomeMinuendEqualsSubtrahend() {
        data.setDividend(42654);
        data.setDivisor(7);
        data.setResult(6093);
        data.setRemainder(3);

        data.addMinuend(6);
        data.addMinuend(65);
        data.addMinuend(24);

        data.addSubtrahend(42);
        data.addSubtrahend(0);
        data.addSubtrahend(63);
        data.addSubtrahend(21);

        String actual = formatter.format(data);
        String expected =   "_42654|7\n" +
                            " 42   |----\n" +
                            " --   |6093\n" +
                            "  _65\n" +
                            "   63\n" +
                            "   --\n" +
                            "   _24\n" +
                            "    21\n" +
                            "    --\n" +
                            "     3";
        assertEquals(expected, actual);
    }
}