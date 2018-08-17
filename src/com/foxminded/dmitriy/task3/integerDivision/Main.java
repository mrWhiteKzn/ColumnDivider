package com.foxminded.dmitriy.task3.integerDivision;

public class Main {
    public static void main(String[] args) {
        Divider divider = new Divider();
        int dividend = 1178945;
        int divisor = 4;

        String result = divider.showDivision(dividend,divisor);
        System.out.println(result);
    }
}
