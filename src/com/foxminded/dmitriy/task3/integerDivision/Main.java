package com.foxminded.dmitriy.task3.integerDivision;

public class Main {
    public static void main(String[] args) {
        DivisionData divisionData = Divider.divide(42654,7);
        String result = ColumnFormatter.format(divisionData);
        System.out.println(result);
    }
}
