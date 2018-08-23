package com.foxminded.dmitriy.task3.integerDivision;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DivisionProcessData that = (DivisionProcessData) o;
        return getDividend() == that.getDividend() &&
                getDivisor() == that.getDivisor() &&
                getResult() == that.getResult() &&
                getRemainder() == that.getRemainder() &&
                Objects.equals(getMinuendList(), that.getMinuendList()) &&
                Objects.equals(getSubtrahendList(), that.getSubtrahendList());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getDividend(), getDivisor(), getResult(), getRemainder(), getMinuendList(), getSubtrahendList());
    }
}
