package com.foxminded.dmitriy.task3.integerDivision;

public class Divider {
    private static final String SPACE = " ";
    private static final String PIPE = "|";
    private static final String MINUS = "-";
    private static final String UNDERSCORE = "_";

    public int showDivision(int dividend, int divisor) {
        if (divisor == 0)
            throw new IllegalArgumentException("Argument 'divisor' is 0!");
        boolean positive = isPositive(dividend, divisor);

        int quotient = dividend / divisor;
        int remainder = dividend % divisor;
        String sQuotient = String.valueOf(quotient);
        String sRemainder = String.valueOf(remainder);
        String sDividend = UNDERSCORE + String.valueOf(dividend);
        String sDivisor = String.valueOf(divisor);

        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);

        StringBuilder log = new StringBuilder();
        if (absDividend < absDivisor) {
            log.append(sDividend + PIPE + divisor + "\n");
            append(log, SPACE, sDividend.length() - 1);
            log.append(0 + PIPE);
            append(log, MINUS, sDivisor.length());
            log.append("\n");
            append(log, MINUS, sDividend.length());
            log.append(PIPE + 0 + "\n");
            log.append(SPACE + dividend);
            System.out.println(log);
        }

        return positive ? 0 : -0;
    }

    private void append(StringBuilder log, String delimiter, int length) {
        for (int i = 0; i < length; i++)
            log.append(delimiter);
    }

    private boolean isPositive(int dividend, int divisor) {
        return ((dividend >= 0 && divisor > 0) || (dividend < 0 && divisor < 0));
    }
}