package com.foxminded.dmitriy.task3.integerDivision;

public class Divider {
    private static final String SPACE = " ";
    private static final String PIPE = "|";
    private static final String MINUS = "-";
    private static final String UNDERSCORE = "_";

    public int showDivision(int dividend, int divisor) {
        if (divisor == 0)
            throw new IllegalArgumentException("Argument divisor = '0'!");

        StringBuilder sbResult = new StringBuilder();
        StringBuilder log = new StringBuilder().append(UNDERSCORE + dividend + PIPE + divisor + "\n");
        appendSecondLine(log, dividend, divisor);

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
        sbResult.append(dividend / divisor);

        while (multiplier != 1) {
            dividend = remainder;
            divisor /= 10;
            multiplier /= 10;
            sbResult.append(dividend / divisor);
            remainder = dividend % divisor;
        }
        int result = Integer.valueOf(sbResult.toString());
        System.out.println(log);
        return positive ? result : -result;
    }

    private void appendSecondLine(StringBuilder log, int dividend, int divisor) {
        int result = dividend / divisor;
        String sDividend = String.valueOf(dividend);
        int rightSpaces = String.valueOf(result).length() - 1;
        int leftSpaces = sDividend.length() - rightSpaces - String.valueOf(divisor).length();

        log.append(SPACE);
        append(log, SPACE, leftSpaces);
        log.append(divisor);
        append(log, SPACE, rightSpaces);
        log.append(PIPE);
        for (int i = 0; i < String.valueOf(result).length(); i++)
            log.append(MINUS);
    }

    private void append(StringBuilder log, String symbol, int length) {
        for (int i = 0; i < length; i++) log.append(symbol);
    }

    private boolean isPositive(int dividend, int divisor) {
        return ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0));
    }
}