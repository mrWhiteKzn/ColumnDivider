package com.foxminded.dmitriy.task3.integerDivision;

public class Divider {
    private static final int MAX_DECIMAL = 9;
    private static final int MULTIPLIER = 10;
    private static final int START_POSITION = 1;

    public DivisionProcessData divide(int dividend, int divisor) {
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
        boolean minuendRequire = false;
        do {
            int digit = Character.getNumericValue(sDivResult.charAt(digitIndex++));
            int subtrahend = divisor * digit / rank;
            data.addSubtrahend(subtrahend);
            if (minuendRequire) {
                divisor /= MULTIPLIER;
                rank /= MULTIPLIER;
                int rightSpaces = sDivResult.length() - digitIndex;
                String sMinuend = String.valueOf(dividend);
                if (!sMinuend.equals("0"))
                    sMinuend = sMinuend.substring(0, sMinuend.length() - rightSpaces);
                int minuend = Integer.valueOf(sMinuend);
                data.addMinuend(minuend);
            }
            minuendRequire = true;
            dividend -= subtrahend * rank;
        } while (rank != START_POSITION);
        data.setRemainder(remainder);
        return data;
    }
}