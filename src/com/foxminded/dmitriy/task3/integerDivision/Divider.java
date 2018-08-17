package com.foxminded.dmitriy.task3.integerDivision;

public class Divider {
    private static final String SPACE = " ";
    private static final String PIPE = "|";
    private static final String MINUS = "-";
    private static final String UNDERSCORE = "_";

    public int showDivision(int dividend, int divisor) {
        if (divisor == 0)
            throw new IllegalArgumentException("Argument divisor = '0'!");

        StringBuilder result = new StringBuilder().append(UNDERSCORE + dividend + PIPE + divisor + "\n");
        appendSecondLine(result, dividend, divisor);
        StringBuilder quotient = new StringBuilder();

        boolean positive = isPositive(dividend, divisor);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int multiplier = 1;
        int remainder = 0;

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
        System.out.println(result);
        return positive ? divResult : -divResult;
    }

    private void appendSecondLine(StringBuilder result, int dividend, int divisor) {
        int divResult = dividend / divisor;
        String sDividend = String.valueOf(dividend);
        int rightSpaces = String.valueOf(divResult).length() - 1;
        int leftSpaces = sDividend.length() - rightSpaces - String.valueOf(divisor).length();

        result.append(SPACE);
        append(result, SPACE, leftSpaces);
        result.append(divisor);
        append(result, SPACE, rightSpaces);
        result.append(PIPE);
        for (int i = 0; i < String.valueOf(divResult).length(); i++)
            result.append(MINUS);
    }

    private void append(StringBuilder log, String symbol, int length) {
        for (int i = 0; i < length; i++) log.append(symbol);
    }

    private boolean isPositive(int dividend, int divisor) {
        return ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0));
    }
}