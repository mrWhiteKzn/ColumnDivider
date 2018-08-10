package com.foxminded.dmitriy.task3.integerDivision;

public class Main {
    public static void main(String[] args) {
        Divider divider = new Divider();
        int dividend = -115;
        int divisor = 50;
        System.out.println("____________");
        System.out.println("Итоговый результат: " +divider.showDividing(dividend, divisor));
    }
}
