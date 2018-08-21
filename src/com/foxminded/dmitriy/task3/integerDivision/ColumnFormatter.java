package com.foxminded.dmitriy.task3.integerDivision;

public class ColumnFormatter {
    private static final char SPACE_CHAR = ' ';
    private static final char MINUS = '-';
    private static final String PIPE = "|";
    private static final String UNDERSCORE = "_";

    public static String format(DivisionData data) {
        boolean first = true;
        int index = 1;
        int rightSpaces;
        int leftSpaces = 1;
        int dividendLen = String.valueOf(UNDERSCORE + data.getDividend()).length();
        int resultLen = String.valueOf(Math.abs(data.getResult())).length();
        StringBuilder result = new StringBuilder();

        result.append(getFirstLine(data.getDividend(), data.getDivisor()));
        while (!data.getSubtrahendList().isEmpty()) {
            int subtrahend = data.getSubtrahendList().removeLast();
            rightSpaces = resultLen - index++;
            leftSpaces = dividendLen - rightSpaces - String.valueOf(subtrahend).length();
            result.append(join(leftSpaces));
            if (first) {
                result.append(subtrahend);
                result.append(join(rightSpaces));
                result.append(PIPE);
                result.append(getDelimiters(String.valueOf(data.getResult()).length()));
                first = false;
            } else {
                result.append(data.getMinuendList().removeLast().toString().concat("\n"));
                result.append(join(leftSpaces));
                result.append(subtrahend).append("\n");
            }
            result.append(join(leftSpaces)).append(getDelimiters(String.valueOf(subtrahend).length()));
        }

        result.append(join(++leftSpaces));
        result.append(data.getRemainder());
        return result.toString();
    }

    private static String getFirstLine(int dividend, int divisor) {
        return UNDERSCORE + dividend + PIPE + divisor + "\n";
    }

    private static String getDelimiters(int count) {
        return new String(new char[count]).replace('\0', MINUS).concat("\n");
    }

    private static String join(int count) {
        return new String(new char[count]).replace('\0', SPACE_CHAR);
    }
}
