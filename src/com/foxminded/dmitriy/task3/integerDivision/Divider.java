package com.foxminded.dmitriy.task3.integerDivision;

public class Divider {
    private int index = 1;
    private boolean negativeFlag = true;
    private int decimals;
    private int dividend;
    private int divisor;
    private boolean firstBlockWritten;
    private boolean secondBlockWritten;
    String stringToLevel;
    int position;

    public int showDividing(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Argument 'divisor' is 0!");
        }

        if ((dividend >= 0 && divisor > 0) || (dividend <= 0 && divisor < 0)) {
            negativeFlag = false;
        }
        printDetails(dividend);

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        this.dividend = dividend;
        this.divisor = divisor;

        if (divisor > dividend) {
            return 0;
        }
        decimals = String.valueOf(dividend).length();

        String result = foo(dividend, divisor);

        int quotient = Integer.parseInt(result);
        if (!negativeFlag)
            return quotient;
        return -quotient;
    }

    private void printDetails(int dividend) {
        if (!firstBlockWritten) {
            stringToLevel = " _" + dividend + "|" + this.divisor;
            position = getStartPosition(stringToLevel);
            System.out.println(stringToLevel);
            firstBlockWritten = true;
            return;
        }
        if (!secondBlockWritten) {
            StringBuilder stringToPrint = new StringBuilder();
            StringBuilder freeSpaces = new StringBuilder();
            for (int i = 0; i < position; i++) {
                freeSpaces.append(" ");
            }
            stringToPrint.append(dividend);
            stringToPrint.append("  |"+ "‐‐‐‐‐‐");
            System.out.println(freeSpaces.append(stringToPrint));
            System.out.print("‐");
            secondBlockWritten = true;
        }
    }

    private int getStartPosition(String stringToLevel) {
        int index = 0;
        for (char c : stringToLevel.toCharArray()) {
            if (Character.isDigit(c))
                return index;
            index++;
        }
        return 0;
    }

    private String foo(int dividend, int divisor) {
        StringBuilder result = new StringBuilder();
        char ch = String.valueOf(dividend).charAt(0);
        int numberToDiv = Integer.valueOf(String.valueOf(ch));
        int charIndex = 0;

        while (numberToDiv < divisor) {
            index++;
            charIndex++;
            numberToDiv = Integer.valueOf(String.valueOf(numberToDiv) + getCloserNumberToDivisor(dividend, charIndex));
        }

        int devisionResult = numberToDiv / divisor;
        result.append(devisionResult);
        printDetails(devisionResult * divisor);

        int remainder = numberToDiv % divisor;
        if (remainder != 0) {
            if (index < decimals) {
                String reminder = Integer.toString(remainder);                              // Остаток от деления
                String dividendSubString = String.valueOf(this.dividend).substring(index);  // Остаток от неделенных чисел
                String dividendString = reminder + dividendSubString;                       // Число для продолжения деления

                dividend = Integer.valueOf(dividendString);
                result.append(foo(dividend, divisor));
            }

        } else if (index < decimals) {
            while (index < decimals) {
                result.append(0);
                index++;
            }
        }
        return result.toString();
    }

    private String getCloserNumberToDivisor(int dividend, int charIndex) {
        char chr = String.valueOf(dividend).charAt(charIndex);
        return Character.toString(chr);
    }
}
