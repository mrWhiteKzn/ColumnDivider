package com.foxminded.dmitriy.task3.integerDivision;

public class Divider {
    private static final String SPACE = " ";
    private static final String PIPE = "|";
    private static final String MINUS = "-";
    private static final String UNDERSCORE = "_";

    public int showDivision(int dividend, int divisor) {
        if (divisor == 0)
            throw new IllegalArgumentException("Argument divisor = '0'!");

        StringBuilder quotient = new StringBuilder();
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int multiplier = 1;
        int remainder;

        while ((dividend / divisor) > 9) {
            divisor *= 10;
            multiplier *= 10;
        }
        remainder = dividend % divisor;
        quotient.append(dividend / divisor);

        while (multiplier != 1) {
            dividend = remainder;
            divisor /= 10;
            multiplier /= 10;
            quotient.append(dividend / divisor);
            remainder = dividend % divisor;
        }
        int divResult = Integer.valueOf(quotient.toString());
        return divResult;
    }


}