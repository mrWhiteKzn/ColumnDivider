package com.foxminded.dmitriy.task3.integerDivision;

public class Divider {
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

        int rank = START_POSITION;
        int divResult = dividend / divisor;
        int digitIndex = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int remainder = dividend % divisor;
        String sDivResult = String.valueOf(Math.abs(divResult));

        while ((dividend / divisor) > MAX_DECIMAL) {
            divisor *= MULTIPLIER;
            rank *= MULTIPLIER;
        }
        boolean addMinuend = false;
        do {
            int digit = Character.getNumericValue(sDivResult.charAt(digitIndex++));
            int subtrahend = divisor * digit / rank;
            data.addSubtrahend(subtrahend);
            if (addMinuend) {
                divisor /= MULTIPLIER;
                rank /= MULTIPLIER;
                String sMinuend = String.valueOf(dividend);
                int rightSpaces = sDivResult.length() - digitIndex;
                sMinuend = sMinuend.substring(0, sMinuend.length() - rightSpaces);
                int minuend = Integer.valueOf(sMinuend);
                data.addMinuend(minuend);
            }
            addMinuend = true;
            dividend -= subtrahend * rank;
        } while (rank != START_POSITION);
        data.setRemainder(remainder);
        return data;
    }
}