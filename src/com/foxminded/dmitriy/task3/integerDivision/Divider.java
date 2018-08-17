package com.foxminded.dmitriy.task3.integerDivision;

public class Divider {
    private static final String SPACE = " ";
    private static final String PIPE = "|";
    private static final String MINUS = "-";
    private static final String UNDERSCORE = "_";
    private static final int MAX_DECIMAL = 9;
    private static final int MULTIPLIER = 10;
    private static final int START_POSITION = 1;

    public String showDivision(int dividend, int divisor) {
        if (divisor == 0)
            throw new IllegalArgumentException("Argument divisor = '0'!");

        StringBuilder result = new StringBuilder();
        int rank = START_POSITION;
        int remainder;

        while ((dividend / divisor) > MAX_DECIMAL) {
            divisor *= MULTIPLIER;
            rank *= MULTIPLIER;
        }
        result.append(dividend / divisor);
        remainder = dividend % divisor;

        while (rank != START_POSITION) {
            divisor /= MULTIPLIER;
            rank /= MULTIPLIER;
            dividend = remainder;
            result.append(dividend / divisor);
            remainder = dividend % divisor;
        }
        result.append(" и в остатке " + remainder);
        return result.toString();
    }
}