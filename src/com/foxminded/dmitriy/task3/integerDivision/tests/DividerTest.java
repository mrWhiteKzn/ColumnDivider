package com.foxminded.dmitriy.task3.integerDivision.tests;

import com.foxminded.dmitriy.task3.integerDivision.Divider;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DividerTest {
    private Divider divider;

    @Before
    public void setUp(){
        divider = new Divider();
    }

    @Test
    public void whenDivideWithOneDigitDivisor(){
        String actual = divider.showDivision(78945, 4);
        String expected =   "_78945|4\n" +
                            " 4    |-----\n" +
                            "_38   |19736\n" +
                            " 36\n" +
                            " _29\n" +
                            "  28\n" +
                            "  _14\n" +
                            "   12\n" +
                            "   _25\n" +
                            "    24\n" +
                            "     1";
        assertEquals(expected, actual);
    }

    @Test
    public void whenDivideWithTwoDigitDivisor(){
        String actual = divider.showDivision(78945, 14);
        String expected =   "_78945|14\n" +
                            " 70   |----\n" +
                            " _89  |5638\n" +
                            "  84\n" +
                            "  _54\n" +
                            "   42\n" +
                            "  _125\n" +
                            "   112\n" +
                            "    13";
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenDivideWithZeroDivisor(){
        String actual = divider.showDivision(554646, 0);
    }

    @Test
    public void whenDivideWithOneDigitNegativeDivisor(){
        String actual = divider.showDivision(46654, -4);
        String expected =   "_46654|-4\n" +
                            " 4    |------\n" +
                            " _6   |-11663\n" +
                            "  4\n" +
                            " _26\n" +
                            "  24\n" +
                            "  _25\n" +
                            "   24\n" +
                            "   _14\n" +
                            "    12\n" +
                            "     2";
        assertEquals(expected, actual);
    }

    @Test
    public void whenDivideWithTwoDigitNegativeDivisor(){
        String actual = divider.showDivision(46654, -14);
        String expected =   "_46654|-14\n" +
                            " 42   |-----\n" +
                            " _46  |-3332\n" +
                            "  42\n" +
                            "  _45\n" +
                            "   42\n" +
                            "   _34\n" +
                            "    28\n" +
                            "     6";
        assertEquals(expected, actual);
    }

    @Test
    public void whenDivideWitNegativeDividendAndPositiveDivisor(){
        String actual = divider.showDivision(-48224, 7);
        String expected =   "_-48224|7\n" +
                            "  42   |-----\n" +
                            "  _62  |-6889\n" +
                            "   56\n" +
                            "   _62\n" +
                            "    56\n" +
                            "    _64\n" +
                            "     63\n" +
                            "      1";
        assertEquals(expected, actual);
    }
}
