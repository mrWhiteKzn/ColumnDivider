package com.foxminded.dmitriy.task3.integerDivision;

public class Divider {
    private static final String SPACE = " ";
    private static final String PIPE = "|";
    private static final String MINUS = "-";
    private static final String UNDERSCORE = "_";

    private int dividend;
    private int divisor;
    private boolean secondBlockWritten;
    private int position;

    public int division(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Argument 'divisor' is 0!");
        }
        boolean positive = isPositiveResult(dividend, divisor);
        this.dividend = dividend;
        this.divisor = divisor;

        printFirstLine(dividend, divisor);
        int result = divide(dividend, divisor);
        printDetails(0, dividend % divisor);
        if (positive)
            return result;
        return -result;
    }

    private boolean isPositiveResult(int dividend, int divisor) {
        return ((dividend >= 0 && divisor > 0) || (dividend <= 0 && divisor < 0));
    }

    private int divide(int dividend, int divisor) {
        StringBuilder result = new StringBuilder();
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int numberToDiv = String.valueOf(dividend).charAt(0) - '0';
        int charIndex = 1;
        int dividendLength = String.valueOf(dividend).length();

        while (numberToDiv < divisor) {
            if (charIndex == dividendLength) break;
            numberToDiv = Integer.valueOf(String.valueOf(numberToDiv) + getCloserNumberToDivisor(dividend, charIndex));
            charIndex++;
        }

        int quotient = numberToDiv / divisor;
        result.append(quotient);
        if (numberToDiv >= divisor)
            printDetails(numberToDiv, quotient * divisor);
        int remainder = numberToDiv % divisor;
        if (charIndex < dividendLength) {
            if (remainder != 0) {
                String subDividend = "" + remainder;
                subDividend = subDividend + String.valueOf(dividend).substring(charIndex);
                dividend = Integer.valueOf(subDividend);
                result.append(divide(dividend, divisor));
            } else {
                result.append(divide(Integer.valueOf(String.valueOf(dividend).substring(charIndex)), divisor));
            }
        }
        return Integer.parseInt(result.toString());
    }

    private String getCloserNumberToDivisor(int dividend, int charIndex) {
        char chr = String.valueOf(dividend).charAt(charIndex);
        return Character.toString(chr);
    }

    private void printDetails(int numberToDiv, int dividend) {
        if (!secondBlockWritten) {
            printSecondAndThirdLine(dividend);
        } else if (numberToDiv == 0) {
            StringBuilder freeSpaces = getSpacesBeforePosition(position);
            StringBuilder remainder = new StringBuilder();
            remainder.append(freeSpaces);
            remainder.append(SPACE);
            remainder.append(dividend);
            System.out.println(remainder);
        } else {
            StringBuilder firstDigitsOut = new StringBuilder();
            StringBuilder freeSpaces = getSpacesBeforePosition(position);
            firstDigitsOut.append(freeSpaces);
            firstDigitsOut.append(UNDERSCORE);
            firstDigitsOut.append(numberToDiv);
            System.out.println(firstDigitsOut);

            StringBuilder secondDigitsOut = new StringBuilder();
            secondDigitsOut.append(freeSpaces.append(SPACE));
            secondDigitsOut.append(dividend);
            System.out.println(secondDigitsOut);

            StringBuilder delimiterString = new StringBuilder();
            delimiterString.append(freeSpaces);
            for (int i = 0; i < String.valueOf(dividend).length(); i++) {
                delimiterString.append(MINUS);
            }
            System.out.println(delimiterString);
            position++;
        }
    }

    private void printFirstLine(int dividend, int divisor) {
        String firstLineToLog = UNDERSCORE + dividend + PIPE + divisor;
        position = getStartPosition(firstLineToLog);
        System.out.println(firstLineToLog);
    }

    private void printSecondAndThirdLine(int dividend) {
        StringBuilder freeSpaces = getSpacesBeforePosition(position);
        StringBuilder secondLineOut = new StringBuilder();
        secondLineOut.append(freeSpaces);
        secondLineOut.append(dividend);
        addSpaces(secondLineOut, dividend);
        secondLineOut.append(PIPE + "‐‐‐‐‐‐");
        int index = secondLineOut.indexOf(PIPE);
        System.out.println(secondLineOut);

        StringBuilder thirdLineOut = new StringBuilder();
        thirdLineOut.append(freeSpaces);
        for (int i = 0; i < String.valueOf(dividend).length(); i++) {
            thirdLineOut.append(MINUS);
        }
        position = String.valueOf(thirdLineOut).length() - 1;
        thirdLineOut.append(getSpacesBeforePosition(index - thirdLineOut.length()));
        thirdLineOut.append(PIPE);
        thirdLineOut.append(this.dividend / this.divisor);
        System.out.println(thirdLineOut);

        secondBlockWritten = true;
    }

    private StringBuilder getSpacesBeforePosition(int position) {
        StringBuilder freeSpaces = new StringBuilder();
        for (int i = 0; i < position; i++) {
            freeSpaces.append(SPACE);
        }
        return freeSpaces;
    }

    private void addSpaces(StringBuilder stringToPrint, int subDiv) {
        int differenceInLength = String.valueOf(this.dividend).length() - String.valueOf(subDiv).length();
        for (int i = 0; i < differenceInLength; i++) {
            stringToPrint.append(SPACE);
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
}