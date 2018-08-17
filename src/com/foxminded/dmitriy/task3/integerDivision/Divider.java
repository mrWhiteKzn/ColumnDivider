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

        result.append(formFirstLine(dividend, divisor));

        while ((dividend / divisor) > MAX_DECIMAL) {
            divisor *= MULTIPLIER;
            rank *= MULTIPLIER;
        }
        remainder = dividend % divisor;

        // вывод
        int dividendLen = String.valueOf(UNDERSCORE + dividend).length();
        int index = 1;
        int rightSpaces = String.valueOf(divResult).length() - index;
        int digit = Integer.valueOf(String.valueOf(divResult).charAt(0) - '0');
        int subtrahend = divisor / rank * digit;
        int leftSpaces = dividendLen - rightSpaces - String.valueOf(subtrahend).length();

        append(result, SPACE, leftSpaces);
        result.append(subtrahend);
        append(result, SPACE, rightSpaces);
        result.append(PIPE);

        for (int i = 0; i < String.valueOf(divResult).length(); i++) {
            result.append(MINUS);
        }
        result.append("\n");

        while (rank != START_POSITION) {
            tmpDividend -= subtrahend * rank;
            digit = Integer.valueOf(String.valueOf(divResult).charAt(index) - '0');
            index++;
            rightSpaces = String.valueOf(divResult).length() - index;

            divisor /= MULTIPLIER;
            rank /= MULTIPLIER;
            dividend = remainder;
            remainder = dividend % divisor;

            // вывод
            String sMinuend = String.valueOf(tmpDividend);
            sMinuend = sMinuend.substring(0, sMinuend.length() - rightSpaces);
            leftSpaces = dividendLen - rightSpaces - sMinuend.length()-1;
            append(result, SPACE, leftSpaces);
            result.append(UNDERSCORE).append(sMinuend);
            append(result,SPACE, rightSpaces);
            if(first){
                result.append(PIPE).append(divResult);
                first = false;
            }
            result.append("\n");

            subtrahend = divisor / rank * digit;
            int subtrahendLeftSpaces = dividendLen - rightSpaces - String.valueOf(subtrahend).length();
            append(result, SPACE, subtrahendLeftSpaces);
            result.append(subtrahend);
            result.append("\n");
            //
        }

        index = dividendLen - String.valueOf(remainder).length();
        append(result, SPACE, index);
        result.append(remainder);
        return result.toString();
    }

    private String formFirstLine(int dividend, int divisor) {
        return UNDERSCORE + dividend + PIPE + divisor + "\n";
    }

    private void append(StringBuilder sb, String symbol, int count) {
        for (int i = 0; i < count; i++) sb.append(symbol);
    }
}