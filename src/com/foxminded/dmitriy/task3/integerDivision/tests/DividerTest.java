package com.foxminded.dmitriy.task3.integerDivision.tests;

import com.foxminded.dmitriy.task3.integerDivision.ColumnFormatter;
import com.foxminded.dmitriy.task3.integerDivision.Divider;
import com.foxminded.dmitriy.task3.integerDivision.DivisionProcessData;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DividerTest {
    private Divider divider;
    private ColumnFormatter formatter;
    private DivisionProcessData data;

    @Before
    public void setUp(){
        divider = new Divider();
        formatter = new ColumnFormatter();
        data = new DivisionProcessData();
    }

    @Test
    public void whenDivideWithOneDigitDivisor(){
        data = Divider.divide(78945,4);
        String actual = ColumnFormatter.format(data);
        String expected =   "_78945|4\n" +
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
    public void whenDivideWithTwoDigitDivisor(){
        data = Divider.divide(78945,14);
        String actual = ColumnFormatter.format(data);
        String expected =   "_78945|14\n" +
                            " 70   |----\n" +
                            " --   |5638\n" +
                            " _89\n" +
                            "  84\n" +
                            "  --\n" +
                            "  _54\n" +
                            "   42\n" +
                            "   --\n" +
                            "  _125\n" +
                            "   112\n" +
                            "   ---\n" +
                            "    13";
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenDivideWithZeroDivisor(){
        data = Divider.divide(554646,0);
        String actual = ColumnFormatter.format(data);
    }

    @Test
    public void whenDivideWithOneDigitNegativeDivisor(){
        data = Divider.divide(46654,-4);
        String actual = ColumnFormatter.format(data);
        String expected =   "_46654|-4\n" +
                            " 4    |------\n" +
                            " -    |-11663\n" +
                            " _6\n" +
                            "  4\n" +
                            "  -\n" +
                            " _26\n" +
                            "  24\n" +
                            "  --\n" +
                            "  _25\n" +
                            "   24\n" +
                            "   --\n" +
                            "   _14\n" +
                            "    12\n" +
                            "    --\n" +
                            "     2";
        assertEquals(expected, actual);
    }

    @Test
    public void whenDivideWithTwoDigitNegativeDivisor(){
        data = Divider.divide(46654,-14);
        String actual = ColumnFormatter.format(data);
        String expected =   "_46654|-14\n" +
                            " 42   |-----\n" +
                            " --   |-3332\n" +
                            " _46\n" +
                            "  42\n" +
                            "  --\n" +
                            "  _45\n" +
                            "   42\n" +
                            "   --\n" +
                            "   _34\n" +
                            "    28\n" +
                            "    --\n" +
                            "     6";
        assertEquals(expected, actual);
    }

    @Test
    public void whenDivideWitNegativeDividendAndPositiveDivisor(){
        data = Divider.divide(-48224,7);
        String actual = ColumnFormatter.format(data);
        String expected =   "_-48224|7\n" +
                            "  42   |-----\n" +
                            "  --   |-6889\n" +
                            "  _62\n" +
                            "   56\n" +
                            "   --\n" +
                            "   _62\n" +
                            "    56\n" +
                            "    --\n" +
                            "    _64\n" +
                            "     63\n" +
                            "     --\n" +
                            "      1";
        assertEquals(expected, actual);
    }

    @Test
    public void whenDivideDividendAndDivisorBothNegative(){
        data = Divider.divide(-3899,-3);
        String actual = ColumnFormatter.format(data);
        String expected =   "_-3899|-3\n" +
                            "  3   |----\n" +
                            "  -   |1299\n" +
                            "  _8\n" +
                            "   6\n" +
                            "   -\n" +
                            "  _29\n" +
                            "   27\n" +
                            "   --\n" +
                            "   _29\n" +
                            "    27\n" +
                            "    --\n" +
                            "     2";
        assertEquals(expected, actual);
    }

    @Test
    public void whenDivideTwoDigitDivisorAndDividendBothNegative(){
        data = Divider.divide(-3899,-30);
        String actual = ColumnFormatter.format(data);
        String expected =   "_-3899|-30\n" +
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
    public void whenDivideAndDivisorTheSame(){
        data = Divider.divide(10,10);
        String actual = ColumnFormatter.format(data);
        String expected =   "_10|10\n" +
                            " 10|-\n" +
                            " --|1\n" +
                            "  0";
        assertEquals(expected, actual);
    }

    @Test
    public void whenDivisorIsOne(){
        data = Divider.divide(100,1);
        String actual = ColumnFormatter.format(data);
        String expected =   "_100|1\n" +
                            " 1  |---\n" +
                            " -  |100\n" +
                            "   0";
        assertEquals(expected, actual);
    }

    @Test
    public void whenDivideAndSomeMinuendEqualsSubtrahend(){
        data = Divider.divide(42654,7);
        String actual = ColumnFormatter.format(data);
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
