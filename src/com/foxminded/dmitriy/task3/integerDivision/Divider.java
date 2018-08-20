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
        int remainder = dividend % divisor;
        int dividendLen = String.valueOf(UNDERSCORE + dividend).length();
        result.append(getFirstLine(dividend, divisor));
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
        int rightSpaces = sDivResult.length() - index;
        int leftSpaces = dividendLen - rightSpaces - String.valueOf(subtrahend).length();
        result.append(getSecondLine(leftSpaces, subtrahend, rightSpaces));
        result.append(getDelimiters(String.valueOf(divResult).length())).append("\n");
        result.append(getThirdLine(leftSpaces, String.valueOf(subtrahend).length(), rightSpaces));
        result.append(PIPE).append(divResult);

        while (rank != START_POSITION) {
            dividend -= subtrahend * rank;
            digit = Character.getNumericValue(sDivResult.charAt(index));
            rightSpaces = sDivResult.length() - ++index;
            divisor /= MULTIPLIER;
            rank /= MULTIPLIER;
            remainder = dividend % divisor;
            subtrahend = divisor / rank * digit;
            if (dividend > divisor) {
                result.append("\n").append(getMinuendLine(dividend, rightSpaces, dividendLen));
                result.append("\n" + getSubtrahendLine(subtrahend, dividendLen, rightSpaces));
            }
        }
        result.append("\n").append(getRemainderLine(remainder, dividendLen));
        return result.toString();
    }

    private String getFirstLine(int dividend, int divisor) {
        return UNDERSCORE + dividend + PIPE + divisor + "\n";
    }

    private String getSecondLine(int leftSpaces, int subtrahend, int rightSpaces) {
        return join(leftSpaces).concat(String.valueOf(subtrahend)).concat(join(rightSpaces)).concat(PIPE);
    }

    private String getThirdLine(int leftSpaces, int length, int rightSpaces) {
        return join(leftSpaces).concat(getDelimiters(length)).concat(join(rightSpaces));
    }

    private String getDelimiters(int count) {
        return new String(new char[count]).replace('\0', MINUS);
    }

    private String getSubtrahendLine(int subtrahend, int dividendLen, int rightSpaces) {
        int subtrahendLeftSpaces = dividendLen - rightSpaces - String.valueOf(subtrahend).length();
        return join(subtrahendLeftSpaces).concat(String.valueOf(subtrahend)).concat("\n")
                .concat(join(subtrahendLeftSpaces).concat(getDelimiters(String.valueOf(subtrahend).length())));
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