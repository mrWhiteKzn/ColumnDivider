package com.foxminded.dmitriy.task3.integerDivision;

public class Main {
    public static void main(String[] args) {
        DivisionProcessData divisionProcessData = Divider.divide(42654, 7);
        String result = ColumnFormatter.format(divisionProcessData);
        System.out.println(result);
    }
}
