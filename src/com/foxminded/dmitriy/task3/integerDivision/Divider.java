package com.foxminded.dmitriy.task3.integerDivision;

public class Divider {
    private int index = 1;
    private boolean negativeFlag = true;
    private int decimals;
    private int dividend;
    private int divisor;
    private int result;
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
        this.divisor = divisor;
        result = dividend / divisor;
        printDetails(dividend, dividend);

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        this.dividend = dividend;
        this.divisor = divisor;

        if (divisor > dividend) {
            return 0;
        }
        decimals = String.valueOf(dividend).length();

        String result = foo(dividend, divisor);
        printDetails(0, dividend % divisor);

        int quotient = Integer.parseInt(result);
        if (!negativeFlag)
            return quotient;
        return -quotient;
    }

    private void printDetails(int numberToDiv, int dividend) {
        if (!firstBlockWritten) {
            stringToLevel = " _" + dividend + "|" + this.divisor;
            position = getStartPosition(stringToLevel);
            System.out.println(stringToLevel);
            firstBlockWritten = true;
            return;
        }
        if (!secondBlockWritten) {
            StringBuilder freeSpaces = new StringBuilder();
            for (int i = 0; i < position; i++) {
                freeSpaces.append(" ");
            }

            StringBuilder stringToPrint = new StringBuilder();
            stringToPrint.append(dividend);
            stringToPrint.append("  |" + "‐‐‐‐‐‐");
            System.out.print(freeSpaces);
            System.out.println(stringToPrint);
            System.out.print(freeSpaces);
            for (int i = 0; i < String.valueOf(dividend).length(); i++) {
                System.out.print("‐");
            }
            System.out.print(freeSpaces);
            System.out.println(result);
            secondBlockWritten = true;
            position++;
            return;
        }

        StringBuilder freeSpaces = new StringBuilder();
        for (int i = 1; i < position; i++) {
            freeSpaces.append(" ");
        }

        if (numberToDiv == 0) {
            System.out.print(freeSpaces + " ");
            System.out.println(dividend);
            return;
        }

        System.out.print(freeSpaces);
        System.out.println("_" + numberToDiv);
        System.out.print(freeSpaces.append(" "));
        System.out.println(dividend);

        StringBuilder deletemeterString = new StringBuilder();
        deletemeterString.append(freeSpaces);
        for (int i = 0; i < String.valueOf(dividend).length(); i++) {
            deletemeterString.append("‐");
//            System.out.print("‐");
        }
        System.out.println(deletemeterString);
        movePosition();
    }

    private void movePosition() {
        for (int i = 0; i < String.valueOf(divisor).length(); i++)
            position++;
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
        printDetails(numberToDiv, devisionResult * divisor);

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
