package com.foxminded.dmitriy.task3.integerDivision;

public class Main {
    public static void main(String[] args) {
        Divider divider = new Divider();
        int dividend = 1234;
        int divisor = 2;

        int result = divider.showDivision(dividend,divisor);
        System.out.println(result);
    }
}
