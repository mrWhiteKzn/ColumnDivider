package com.foxminded.dmitriy.task3.integerDivision;

public class Divider {
    private static final String SPACE = " ";
    private static final String PIPE = "|";
    private static final String MINUS = "-";
    private static final String UNDERSCORE = "_";

    public int showDivision(int dividend, int divisor) {
        checkDivisor(divisor);

        int quotient = dividend / divisor;
        int remainder = dividend % divisor;
        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);
        int absQuotient = Math.abs(quotient);
        int dividendLength = String.valueOf(dividend).length();
        String sQuotient = String.valueOf(absQuotient);
        String sRemainder = String.valueOf(remainder);

        StringBuilder log = new StringBuilder();
        if (absDividend < absDivisor) {
            printResult(log, dividend, divisor);
        }
        log.append(UNDERSCORE + dividend + PIPE + divisor + "\n");
        boolean isBlockInfo = true;
        int decimals = getDecimals(sQuotient.length());
        int tempDiv = absDividend;
        int index;

        for (index = 1; index <= sQuotient.length(); index++, isBlockInfo = false, decimals /= 10) {
            int rightSpaces = sQuotient.length() - index;
            int digit = Integer.parseInt(sQuotient.substring(index - 1, index));
            int subtrahend = digit * absDivisor;
            if (digit != 0) {
                String sSubtrahend = String.valueOf(subtrahend);
                String sMinuend;
                if (isBlockInfo) {
                    sMinuend = "";
                } else {
                    sMinuend = String.valueOf(tempDiv);
                    sMinuend = sMinuend.substring(0, sMinuend.length() - rightSpaces);
                }
                int minuendLeftSpaces = isBlockInfo ? 0 : dividendLength - rightSpaces - sMinuend.length();
                if (!isBlockInfo) {
                    log.append(formSecondLine(minuendLeftSpaces, sMinuend, rightSpaces));
                }

                int subtrahendLeftSpaces = dividendLength - rightSpaces - sSubtrahend.length();
                log.append(formSubtrahendLine(subtrahendLeftSpaces, subtrahend, rightSpaces));

                if (isBlockInfo) {
                    log.append(PIPE);
                    append(log, MINUS, dividendLength);
                }
                log.append("\n");
                log.append(SPACE);
                append(log, SPACE, minuendLeftSpaces);

                int tempDivLength = String.valueOf(tempDiv).length();
                int limit = isBlockInfo ? tempDivLength - rightSpaces : sMinuend.length();
                append(log, MINUS, limit);
                append(log, SPACE, rightSpaces);

                if (isBlockInfo) {
                    if (dividend < 0)
                        log.append(SPACE);
                    log.append(PIPE).append(quotient);
                }
                log.append('\n');
            }
            tempDiv -= subtrahend * decimals;
        }
        index = dividendLength - sRemainder.length();
        log.append(formRemainder(sRemainder, index));
        System.out.println(log);
        return quotient;
    }

    private void checkDivisor(int divisor) {
        if (divisor == 0)
            throw new IllegalArgumentException("Argument 'divisor' is 0!");
    }

    private StringBuilder formRemainder(String sRemainder, int index) {
        StringBuilder line = new StringBuilder();
        line.append(SPACE);
        append(line, SPACE, index);
        line.append(sRemainder);
        return line;
    }

    private StringBuilder formSubtrahendLine(int subtrahendLeftSpaces, int subtrahend, int rightSpaces) {
        StringBuilder line = new StringBuilder();
        append(line, SPACE, subtrahendLeftSpaces);
        line.append(SPACE).append(subtrahend);
        append(line, SPACE, rightSpaces);
        return line;
    }

    private StringBuilder formSecondLine(int minuendLeftSpaces, String sMinuend, int rightSpaces) {
        StringBuilder line = new StringBuilder();
        append(line, SPACE, minuendLeftSpaces);
        line.append(UNDERSCORE);
        line.append(sMinuend);
        append(line, SPACE, rightSpaces);
        line.append("\n");
        return line;
    }

    private int getDecimals(int length) {
        int decimals = 1;
        for (int i = 1; i < length; i++) {
            decimals *= 10;
        }
        return decimals;
    }

    private void printResult(StringBuilder log, int dividend, int divisor) {
        String sDividend = String.valueOf(dividend);
        String sDivisor = String.valueOf(divisor);
        log.append(sDividend + PIPE + divisor + "\n");
        append(log, SPACE, sDividend.length() - 1);
        log.append(0 + PIPE);
        append(log, MINUS, sDivisor.length());
        log.append("\n");
        append(log, MINUS, sDividend.length());
        log.append(PIPE + 0 + "\n");
        log.append(SPACE + dividend);
        System.out.println(log);
    }

    private void append(StringBuilder log, String delimiter, int length) {
        for (int i = 0; i < length; i++)
            log.append(delimiter);
    }
}