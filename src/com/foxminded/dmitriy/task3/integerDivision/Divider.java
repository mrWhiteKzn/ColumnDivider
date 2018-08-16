package com.foxminded.dmitriy.task3.integerDivision;

public class Divider {
    private static final String SPACE = " ";
    private static final String PIPE = "|";
    private static final String MINUS = "-";
    private static final String UNDERSCORE = "_";

    public int showDivision(int dividend, int divisor) {
        if (divisor == 0)
            throw new IllegalArgumentException("Argument 'divisor' is 0!");

        int quotient = dividend / divisor;
        int remainder = dividend % divisor;

        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);
        int absQuotient = Math.abs(quotient);

        String sQuotient = String.valueOf(absQuotient);
        String sRemainder = String.valueOf(remainder);
        String sDividend = UNDERSCORE + String.valueOf(dividend);
        String sDivisor = String.valueOf(divisor);
        int dividendLength = String.valueOf(dividend).length();

        StringBuilder log = new StringBuilder();
        if (absDividend < absDivisor) {
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

        log.append(UNDERSCORE + dividend + PIPE + divisor + "\n");
        boolean isBlockInfo = true;
        int multiplicand = 1;
        int tempDiv = absDividend;
        int index;

        for (index = 1; index < sQuotient.length(); index++) {
            multiplicand *= 10;
        }
        for (index = 1; index <= sQuotient.length(); index++, isBlockInfo = false, multiplicand /= 10) {
            int rightSpaces = sQuotient.length() - index; // ?
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
                    log.append(SPACE);
                    append(log, SPACE, minuendLeftSpaces);
                    log.append(sMinuend);
                    append(log, SPACE, rightSpaces);
                    log.append("\n");
                }

                int subtrahendLeftSpaces = dividendLength - rightSpaces - sSubtrahend.length();
                append(log, SPACE, subtrahendLeftSpaces);
                log.append(MINUS).append(subtrahend);
                append(log, SPACE, rightSpaces);
                if (isBlockInfo) {
                    log.append(PIPE + "--");
                    append(log, MINUS, dividendLength);
                }
                log.append("\n");

                log.append(SPACE);
                append(log, SPACE, minuendLeftSpaces);

                int tempDivLength = String.valueOf(Math.abs(tempDiv)).length();
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
            tempDiv -= subtrahend * multiplicand;
        }

        log.append(SPACE);
        index = dividendLength - sRemainder.length();
        append(log, SPACE, index);
        log.append(sRemainder);
        System.out.println(log);

        return quotient;
    }

    private void append(StringBuilder log, String delimiter, int length) {
        for (int i = 0; i < length; i++)
            log.append(delimiter);
    }
}