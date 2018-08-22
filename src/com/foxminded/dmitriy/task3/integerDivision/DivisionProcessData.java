package com.foxminded.dmitriy.task3.integerDivision;

import java.util.Deque;
import java.util.LinkedList;

public class DivisionProcessData {
    private int dividend;
    private int divisor;
    private int result;
    private int remainder;
    private Deque<Integer> minuendList;
    private Deque<Integer> subtrahendList;

    public DivisionProcessData() {
        this.minuendList = new LinkedList<>();
        this.subtrahendList = new LinkedList<>();
    }

    public void addMinuend(int minuend){
        minuendList.offerFirst(minuend);
    }

    public void addSubtrahend(int subtrahend){
        subtrahendList.offerFirst(subtrahend);
    }

    public int getDividend() {
        return dividend;
    }

    public void setDividend(int dividend) {
        this.dividend = dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getRemainder() {
        return remainder;
    }

    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }

    public Deque<Integer> getMinuendList() {
        return minuendList;
    }

    public Deque<Integer> getSubtrahendList() {
        return subtrahendList;
    }
}
