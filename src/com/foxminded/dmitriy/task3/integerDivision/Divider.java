package com.foxminded.dmitriy.task3.integerDivision;

public class Divider {
    private int index = 0;
    private boolean negativeFlag = true;

    public int showDividing(int dividend, int divisor) {
        if ((dividend >= 0 && divisor > 0) || (dividend <= 0 && divisor < 0)) {
            negativeFlag = false;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if (divisor > dividend) {
            return 0;
        }

        String result = foo(dividend, divisor);

        int quotient = Integer.parseInt(result);
        if (!negativeFlag)
            return quotient;
        return -quotient;
    }

    private String foo(int dividend, int divisor) {
        StringBuilder result = new StringBuilder();
        int decimals = String.valueOf(dividend).length();
        int currentDiv = 0;
        int charIndex = 0;

        while (currentDiv < divisor) {
            index++;
            currentDiv = Integer.valueOf(String.valueOf(currentDiv) + String.valueOf(getNextNumber(dividend, charIndex)));
            charIndex++;
        }

        int devisionResult = currentDiv / divisor;
        int remainder = currentDiv % divisor;
        result.append(devisionResult);

        if (remainder != 0) {
            if(index<decimals){
                char chr = String.valueOf(remainder).charAt(0);
                String dividendSubString = String.valueOf(dividend).substring(index);
                String dividendString = String.valueOf(chr) + dividendSubString;
                dividend = Integer.valueOf(dividendString);
                result.append(foo(dividend, divisor));
            }

        } else if (index < decimals) {
            System.out.println(index + " " + decimals);
            while (index < decimals) {
                result.append(0);
                index++;
            }
        }
        return result.toString();
    }

    private int getNextNumber(int dividend, int charIndex) {
        char chr = String.valueOf(dividend).charAt(charIndex);
        return Character.getNumericValue(chr);
    }
}
