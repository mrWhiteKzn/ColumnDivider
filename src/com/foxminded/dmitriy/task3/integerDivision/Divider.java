package com.foxminded.dmitriy.task3.integerDivision;

public class Divider {
    private static final String SPACE = " ";
    private static final String PIPE = "|";
    private static final String MINUS = "-";
    private static final String UNDERSCORE = "_";

    public String showDivision(int dividend, int divisor) {
        if (divisor == 0)
            throw new IllegalArgumentException("Argument divisor = '0'!");

        StringBuilder result = new StringBuilder();
        int multiplier = 1;
        int remainder;

        while ((dividend / divisor) > 9) {
            divisor *= 10;
            multiplier *= 10;
        }
        result.append(dividend / divisor);
        remainder = dividend % divisor;

        while (multiplier != 1) {
            divisor /= 10;
            multiplier /= 10;
            dividend = remainder;
            result.append(dividend / divisor);
            remainder = dividend % divisor;
        }
        return result.toString();
    }
}