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
    public void whenDevideOneSymbolNumber(){
        int actual = divider.showDividing(5,5);
        int expected = 1;
        assertEquals(expected,actual);
    }

    @Test
    public void whenDevidePositiveNumbers(){
        int actual = divider.showDividing(115,5);
        int expected = 23;
        assertEquals(expected,actual);
    }

    @Test
    public void whenDevideAllNegative(){
        int actual = divider.showDividing(-115,-5);
        int expected = 23;
        assertEquals(expected,actual);
    }

    @Test
    public void whenDevideWithNegativeDividend(){
        int actual = divider.showDividing(-115,5);
        int expected = -23;
        assertEquals(expected,actual);
    }

    @Test
    public void whenDevideWithNegativeDivisor(){
        int actual = divider.showDividing(115,-5);
        int expected = -23;
        assertEquals(expected,actual);
    }

    @Test
    public void whenDevideWithDivisorLessThanDividend(){
        int actual = divider.showDividing(5,9);
        int expected = 0;
        assertEquals(expected,actual);
    }

    @Test
    public void whenDevideWithDivisorConsistsMoreThanOneCharacter(){
        int actual = divider.showDividing(115,50);
        int expected = 2;
        assertEquals(expected,actual);
    }

    @Test
    public void whenDevideWithDivisorConsistsMoreThanTwoCharacter(){
        int actual = divider.showDividing(1150,100);
        int expected = 11;
        assertEquals(expected,actual);
    }
}
