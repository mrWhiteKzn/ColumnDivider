package com.foxminded.dmitriy.task3.integerDivision;

public class Divider {
    private static final char SPACE_CHAR = ' ';
    private static final char MINUS = '-';
    private static final String PIPE = "|";
    private static final String UNDERSCORE = "_";
    private static final int MAX_DECIMAL = 9;
    private static final int MULTIPLIER = 10;
    private static final int START_POSITION = 1;

    public String showDivision(int dividend, int divisor) {
        if (divisor == 0)
            throw new IllegalArgumentException("Argument divisor = '0'!");

        StringBuilder result = new StringBuilder();
        int rank = START_POSITION;
        int divResult = dividend / divisor;
        int tmpDividend = dividend;
        int remainder;
        boolean first = true;
        String sDivResult = String.valueOf(divResult);
        result.append(getFirstLine(dividend, divisor));

        while ((dividend / divisor) > MAX_DECIMAL) {
            divisor *= MULTIPLIER;
            rank *= MULTIPLIER;
        }
        remainder = dividend % divisor;

        int dividendLen = String.valueOf(UNDERSCORE + dividend).length();
        int index = 1;
        int rightSpaces = sDivResult.length() - index;
        int digit = sDivResult.charAt(0) - '0';
        int subtrahend = divisor / rank * digit;
        int leftSpaces = dividendLen - rightSpaces - String.valueOf(subtrahend).length();
        result.append(getSecondLine(leftSpaces, subtrahend, rightSpaces).concat(getDelimiters(sDivResult.length())));

        while (rank != START_POSITION) {
            tmpDividend -= subtrahend * rank;
            digit = sDivResult.charAt(index) - '0';
            rightSpaces = sDivResult.length() - ++index;

            divisor /= MULTIPLIER;
            rank /= MULTIPLIER;
            dividend = remainder;
            remainder = dividend % divisor;
            result.append(getMinuendLine(tmpDividend, rightSpaces, dividendLen));

            if (first) {
                result.append(join(rightSpaces)).append(PIPE).append(divResult);
                first = false;
            }
            subtrahend = divisor / rank * digit;
            result.append("\n" + getSubtrahendLine(subtrahend, dividendLen, rightSpaces));
        }
        result.append(getRemainderLine(remainder, dividendLen));
        return result.toString();
    }

    private String getFirstLine(int dividend, int divisor) {
        return UNDERSCORE + dividend + PIPE + divisor + "\n";
    }

    private String getSecondLine(int leftSpaces, int subtrahend, int rightSpaces) {
        return join(leftSpaces).concat(String.valueOf(subtrahend)).concat(join(rightSpaces)).concat(PIPE);
    }

    private String getDelimiters(int count) {
        return new String(new char[count]).replace('\0', MINUS).concat("\n");
    }

    private String getSubtrahendLine(int subtrahend, int dividendLen, int rightSpaces) {
        int subtrahendLeftSpaces = dividendLen - rightSpaces - String.valueOf(subtrahend).length();
        return join(subtrahendLeftSpaces).concat(String.valueOf(subtrahend)).concat("\n");
    }

    private String getMinuendLine(int tmpDividend, int rightSpaces, int dividendLen) {
        String sMinuend = String.valueOf(tmpDividend);
        sMinuend = sMinuend.substring(0, sMinuend.length() - rightSpaces);
        int leftSpaces = dividendLen - rightSpaces - sMinuend.length() - 1;
        return join(leftSpaces).concat(UNDERSCORE).concat(sMinuend);
    }

    private String getRemainderLine(int remainder, int dividendLen) {
        int leftSpaces = dividendLen - String.valueOf(remainder).length();
        return join(leftSpaces).concat(String.valueOf(remainder));
    }

    private String join(int count) {
        return new String(new char[count]).replace('\0', SPACE_CHAR);
    }
}