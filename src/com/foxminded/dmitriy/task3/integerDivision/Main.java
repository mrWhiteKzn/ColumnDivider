package com.foxminded.dmitriy.task3.integerDivision;

public class Main {
    public static void main(String[] args) {
        DivisionProcessData divisionProcessData = Divider.divide(100,1);
        String result = ColumnFormatter.format(divisionProcessData);
        System.out.println(result);
    }
}
