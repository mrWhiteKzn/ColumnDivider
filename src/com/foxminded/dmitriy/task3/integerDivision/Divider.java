package com.foxminded.dmitriy.task3.integerDivision;

public class Divider {
    private static final String SPACE = " ";
    private static final String PIPE = "|";
    private static final String MINUS = "-";
    private static final String UNDERSCORE = "_";

    private int digitIndexInDividend = 1;
    private boolean positive = false;
    private int dividend;
    private int divisor;
    private int result;
    private boolean firstBlockWritten;
    private boolean secondBlockWritten;
    private String firstLineToLog;
    private int position;

    public int showDividing(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Argument 'divisor' is 0!");
        }

        if ((dividend >= 0 && divisor > 0) || (dividend <= 0 && divisor < 0)) {
            positive = true;
        }

        this.divisor = divisor;
        result = dividend / divisor;
        printDetails(dividend, dividend);   // wtf??

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        this.dividend = dividend;
        this.divisor = divisor;

        if (divisor > dividend) {
            return 0;
        }
        result = divide(dividend, divisor);
        printDetails(0, dividend % divisor);

        if (positive)
            return result;
        return -result;
    }

    private int divide(int dividend, int divisor) {
        StringBuilder result = new StringBuilder();
        char ch = String.valueOf(dividend).charAt(0);
        int numberToDiv = Integer.valueOf(String.valueOf(ch));
        int charIndex = 0;
        int currentDec = String.valueOf(dividend).length();

        while (numberToDiv < divisor) {
            digitIndexInDividend++;
            charIndex++;
            if (charIndex == currentDec) break;
            numberToDiv = Integer.valueOf(String.valueOf(numberToDiv) + getCloserNumberToDivisor(dividend, charIndex));
        }

        int divisionResult = numberToDiv / divisor;
        result.append(divisionResult);
        if (numberToDiv > divisor)
            printDetails(numberToDiv, divisionResult * divisor);

        int remainder = numberToDiv % divisor;
        if (digitIndexInDividend < currentDec) {
            if (remainder != 0) {
                String reminder = Integer.toString(remainder);
                String substringToDivide = String.valueOf(dividend).substring(digitIndexInDividend);
                String stringToDivide = reminder + substringToDivide;

                dividend = Integer.valueOf(stringToDivide);
                result.append(divide(dividend, divisor));
            } else if (charIndex < currentDec) {
                result.append(divide(Integer.valueOf(String.valueOf(dividend).substring(digitIndexInDividend)), divisor));
            }
        }
        return Integer.parseInt(result.toString());
    }

    private String getCloserNumberToDivisor(int dividend, int charIndex) {
        char chr = String.valueOf(dividend).charAt(charIndex);
        return Character.toString(chr);
    }

    private void printDetails(int numberToDiv, int dividend) {
        if (!firstBlockWritten) {
            printFirstLine(dividend);
            return;
        }
        if (!secondBlockWritten) {
            printSecondAndThirdLine(dividend);
            return;
        }

        StringBuilder freeSpaces = getSpacesBeforePosition(position);
        if (numberToDiv == 0) {
            StringBuilder remainder = new StringBuilder();
            remainder.append(freeSpaces);
            remainder.append(SPACE);
            remainder.append(dividend);
            System.out.println(remainder);
            return;
        }

        StringBuilder firstDigitsOut = new StringBuilder();
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
        movePosition();
    }

    private void printFirstLine(int dividend) {
        firstLineToLog = UNDERSCORE + dividend + PIPE + this.divisor;
        position = getStartPosition(firstLineToLog);
        System.out.println(firstLineToLog);
        firstBlockWritten = true;
    }

    private void printSecondAndThirdLine(int dividend) {
        StringBuilder freeSpaces = getSpacesBeforePosition(position);
        StringBuilder secondLineOut = new StringBuilder();
        secondLineOut.append(freeSpaces);
        secondLineOut.append(dividend);
        addSpaces(secondLineOut, dividend);
        secondLineOut.append(PIPE + "‐‐‐‐‐‐");
        int index = secondLineOut.indexOf(PIPE);
        System.out.println(secondLineOut);  //вторая строка

        StringBuilder thirdLineOut = new StringBuilder();
        thirdLineOut.append(freeSpaces);
        for (int i = 0; i < String.valueOf(dividend).length(); i++) {
            thirdLineOut.append(MINUS);
        }
        position = String.valueOf(thirdLineOut).length()-1;
        thirdLineOut.append(getSpacesBeforePosition(index - thirdLineOut.length()));
        thirdLineOut.append(PIPE);
        thirdLineOut.append(result);
        System.out.println(thirdLineOut);   // третья строка

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

    private void movePosition() {
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
}