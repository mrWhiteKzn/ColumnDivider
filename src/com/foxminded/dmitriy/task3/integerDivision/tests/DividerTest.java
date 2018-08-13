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
    public void whenDivideOneCharacterNumber(){
        int actual = divider.showDividing(5,5);
        int expected = 1;
        assertEquals(expected,actual);
    }

    @Test
    public void whenDivideWithPositiveNumbers(){
        int actual = divider.showDividing(115,5);
        int expected = 23;
        assertEquals(expected,actual);
    }

    @Test
    public void whenDivideWithNegativeNumbers(){
        int actual = divider.showDividing(-115,-5);
        int expected = 23;
        assertEquals(expected,actual);
    }

    @Test
    public void whenDivideWithNegativeDividend(){
        int actual = divider.showDividing(-115,5);
        int expected = -23;
        assertEquals(expected,actual);
    }

    @Test
    public void whenDivideWithNegativeDivisor(){
        int actual = divider.showDividing(115,-5);
        int expected = -23;
        assertEquals(expected,actual);
    }

    @Test
    public void whenDivideWithDividendLessThanDivisor(){
        int actual = divider.showDividing(5,9);
        int expected = 0;
        assertEquals(expected,actual);
    }

    @Test
    public void whenDivideWithDivisorConsistsTwoCharacter(){
        int actual = divider.showDividing(115,50);
        int expected = 2;
        assertEquals(expected,actual);
    }

    @Test
    public void whenDivideWithDivisorConsistsThreeCharacter(){
        int actual = divider.showDividing(1150,100);
        int expected = 11;
        assertEquals(expected,actual);
    }

    @Test
    public void whenDivideWithDivisorConsistsFourCharacterAndDividendIsNegative(){
        int actual = divider.showDividing(-11500,1001);
        int expected = -11;
        assertEquals(expected,actual);
    }

    @Test
    public void whenDivideWithDivisorConsistsFiveCharacterAndDividendIsLessAndBothNegative(){
        int actual = divider.showDividing(-1001,-10001);
        int expected = 0;
        assertEquals(expected,actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenDivideByZero(){
        int actual = divider.showDividing(144, 0);
    }

    @Test
    public void whenDivideWhereDivisorIsEvenNumber(){
        int actual = divider.showDividing(533, 2);
        int expected = 266;
        assertEquals(expected, actual);
    }

    @Test
    public void whenDivideWhereDivisorIsOddNumber(){
        int actual = divider.showDividing(533, 3);
        int expected = 177;
        assertEquals(expected, actual);
    }
}
