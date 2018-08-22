package com.foxminded.dmitriy.task3.integerDivision;

public class ColumnFormatter {
    private static final char SPACE_CHAR = ' ';
    private static final char MINUS = '-';
    private static final String PIPE = "|";
    private static final String UNDERSCORE = "_";
    private static final int START_POSITION = 0;

    public String format(DivisionProcessData data) {
        StringBuilder result = new StringBuilder();
        boolean infoPart = true;
        int index = START_POSITION;
        int dividendLen = String.valueOf(UNDERSCORE + data.getDividend()).length();
        int resultLen = String.valueOf(Math.abs(data.getResult())).length();

        while (!data.getSubtrahendList().isEmpty()) {
            int subtrahend = data.getSubtrahendList().removeLast();
            int rightSpaces = resultLen - ++index;
            int leftSpaces = dividendLen - rightSpaces - String.valueOf(subtrahend).length();
            if (infoPart) {
                result.append(getFirstLine(data.getDividend(), data.getDivisor()));
                result.append(getSecondLine(leftSpaces, subtrahend, rightSpaces));
                result.append(getDelimiters(String.valueOf(data.getResult()).length())).append("\n");
                result.append(getThirdLine(leftSpaces, String.valueOf(subtrahend).length(), rightSpaces));
                result.append(PIPE).append(data.getResult());
                infoPart = false;
            } else {
                int minuend = data.getMinuendList().removeLast();
                if ((minuend >= subtrahend && subtrahend != 0)) {
                    result.append("\n").append(getMinuendLine(minuend, rightSpaces, dividendLen));
                    result.append("\n").append(getSubtrahendLine(subtrahend, rightSpaces, dividendLen));
                }
            }
        }
        result.append(getReminderLine(data.getRemainder(), dividendLen));
        return result.toString();
    }

    private String getReminderLine(int remainder, int dividendLen) {
        return "\n".concat(join(dividendLen - String.valueOf(remainder).length())).concat(String.valueOf(remainder));
    }

    private String getSubtrahendLine(int subtrahend, int rightSpaces, int dividendLen) {
        int subtrahendLeftSpaces = dividendLen - rightSpaces - String.valueOf(subtrahend).length();
        return join(subtrahendLeftSpaces).concat(String.valueOf(subtrahend)).concat("\n")
                .concat(join(subtrahendLeftSpaces).concat(getDelimiters(String.valueOf(subtrahend).length())));
    }

    private String getMinuendLine(int minuend, int rightSpaces, int dividendLen) {
        int leftSpaces = dividendLen - rightSpaces - String.valueOf(minuend).length() - UNDERSCORE.length();
        return join(leftSpaces).concat(UNDERSCORE).concat(String.valueOf(minuend));
    }

    private String getThirdLine(int leftSpaces, int length, int rightSpaces) {
        return join(leftSpaces).concat(getDelimiters(length)).concat(join(rightSpaces));
    }

    private String getSecondLine(int leftSpaces, int subtrahend, int rightSpaces) {
        return join(leftSpaces).concat(String.valueOf(subtrahend)).concat(join(rightSpaces)).concat(PIPE);
    }

    private String getFirstLine(int dividend, int divisor) {
        return UNDERSCORE + dividend + PIPE + divisor + "\n";
    }

    private String getDelimiters(int count) {
        return new String(new char[count]).replace('\0', MINUS);
    }

    private String join(int count) {
        return new String(new char[count]).replace('\0', SPACE_CHAR);
    }
}