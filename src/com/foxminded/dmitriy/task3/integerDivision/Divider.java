package com.foxminded.dmitriy.task3.integerDivision;

public class Divider {
    private static final String SPACE = " ";
    private static final String PIPE = "|";
    private static final String MINUS = "-";
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
        result.append(getFirstLine(dividend, divisor));

        while ((dividend / divisor) > MAX_DECIMAL) {
            divisor *= MULTIPLIER;
            rank *= MULTIPLIER;
        }
        remainder = dividend % divisor;

        int dividendLen = String.valueOf(UNDERSCORE + dividend).length();
        int index = 1;
        int rightSpaces = String.valueOf(divResult).length() - index;
        int digit = Integer.valueOf(String.valueOf(divResult).charAt(0) - '0');
        int subtrahend = divisor / rank * digit;
        int leftSpaces = dividendLen - rightSpaces - String.valueOf(subtrahend).length();

        StringBuilder secondLine = getSecondLine(leftSpaces, subtrahend, rightSpaces);
        secondLine.append(getDelimiters(String.valueOf(divResult).length()));
        result.append(secondLine);

        while (rank != START_POSITION) {
            tmpDividend -= subtrahend * rank;
            digit = Integer.valueOf(String.valueOf(divResult).charAt(index) - '0');
            index++;
            rightSpaces = String.valueOf(divResult).length() - index;

            divisor /= MULTIPLIER;
            rank /= MULTIPLIER;
            dividend = remainder;
            remainder = dividend % divisor;
            result.append(getMinuendLine(tmpDividend, rightSpaces, dividendLen));

            if (first) {
                result.append(PIPE).append(divResult);
                first = false;
            }
            subtrahend = divisor / rank * digit;
            result.append(getSubtrahendLine(subtrahend, dividendLen, rightSpaces));
        }
        result.append(getRemainderLine(remainder, dividendLen));
        return result.toString();
    }

    private String getFirstLine(int dividend, int divisor) {
        return UNDERSCORE + dividend + PIPE + divisor + "\n";
    }

    private StringBuilder getSecondLine(int leftSpaces, int subtrahend, int rightSpaces) {
        StringBuilder secondLine = new StringBuilder();
        append(secondLine, SPACE, leftSpaces);
        secondLine.append(subtrahend);
        append(secondLine, SPACE, rightSpaces);
        secondLine.append(PIPE);
        return secondLine;
    }

    private StringBuilder getDelimiters(int count) {
        StringBuilder delimiters = new StringBuilder();
        append(delimiters, MINUS, count);
        return delimiters.append("\n");
    }

    private StringBuilder getSubtrahendLine(int subtrahend, int dividendLen, int rightSpaces) {
        StringBuilder subtrahendLine = new StringBuilder().append("\n");
        int subtrahendLeftSpaces = dividendLen - rightSpaces - String.valueOf(subtrahend).length();
        append(subtrahendLine, SPACE, subtrahendLeftSpaces);
        subtrahendLine.append(subtrahend);
        subtrahendLine.append("\n");
        return subtrahendLine;
    }

    private StringBuilder getMinuendLine(int tmpDividend, int rightSpaces, int dividendLen) {
        StringBuilder minuendLine = new StringBuilder();
        String sMinuend = String.valueOf(tmpDividend);
        sMinuend = sMinuend.substring(0, sMinuend.length() - rightSpaces);
        int leftSpaces = dividendLen - rightSpaces - sMinuend.length() - 1;
        append(minuendLine, SPACE, leftSpaces);
        minuendLine.append(UNDERSCORE).append(sMinuend);
        append(minuendLine, SPACE, rightSpaces);
        return minuendLine;
    }

    private StringBuilder getRemainderLine(int remainder, int dividendLen) {
        StringBuilder remainderLine = new StringBuilder();
        int index = dividendLen - String.valueOf(remainder).length();
        append(remainderLine, SPACE, index);
        remainderLine.append(remainder);
        return remainderLine;
    }

    private void append(StringBuilder sb, String delimiter, int count) {
        for (int i = 0; i < count; i++) sb.append(delimiter);
    }
}