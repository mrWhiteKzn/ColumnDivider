package com.foxminded.dmitriy.task3.integerDivision;

public class Main {
    public static void main(String[] args) {
        Divider divider = new Divider();
        ColumnFormatter formatter = new ColumnFormatter();

        DivisionProcessData divisionProcessData = divider.divide(111111, 1);
        String result = formatter.format(divisionProcessData);

        System.out.println(result);
    }
}
