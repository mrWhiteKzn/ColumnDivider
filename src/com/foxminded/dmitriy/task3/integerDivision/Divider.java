package com.foxminded.dmitriy.task3.integerDivision;

public class Divider {
    private static final char SPACE_CHAR = ' ';
    private static final char MINUS = '-';
    private static final String PIPE = "|";
    private static final String UNDERSCORE = "_";
    private static final int MAX_DECIMAL = 9;
    private static final int MULTIPLIER = 10;
    private static final int START_POSITION = 1;

    public static DivisionProcessData divide(int dividend, int divisor) {
        if (divisor == 0)
            throw new IllegalArgumentException("Argument divisor = '0'!");

        DivisionProcessData data = new DivisionProcessData();
        data.setDividend(dividend);
        data.setDivisor(divisor);
        data.setResult(dividend / divisor);

        StringBuilder result = new StringBuilder();
        int rank = START_POSITION;
        int divResult = dividend / divisor;
        int remainder = dividend % divisor;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        String sDivResult = String.valueOf(Math.abs(divResult));

        while ((dividend / divisor) > MAX_DECIMAL) {
            divisor *= MULTIPLIER;
            rank *= MULTIPLIER;
        }
        int index = 1;
        int digit = Character.getNumericValue(sDivResult.charAt(0));
        int subtrahend = divisor / rank * digit;

        data.addSubtrahend(subtrahend);
        data.addMinuend(0);

        int rightSpaces;
        result.append(PIPE).append(divResult);

        while (rank != START_POSITION) {
            dividend -= subtrahend * rank;
            digit = Character.getNumericValue(sDivResult.charAt(index));
            rightSpaces = sDivResult.length() - ++index;
            divisor /= MULTIPLIER;
            rank /= MULTIPLIER;
            remainder = dividend % divisor;
            subtrahend = divisor / rank * digit;
            String sMinuend = String.valueOf(dividend);
            sMinuend = sMinuend.substring(0, sMinuend.length() - rightSpaces);
            int minuend = Integer.parseInt(sMinuend);

            data.addSubtrahend(subtrahend);
            data.addMinuend(minuend);
        }
        data.setRemainder(remainder);
        return data;
    }
}