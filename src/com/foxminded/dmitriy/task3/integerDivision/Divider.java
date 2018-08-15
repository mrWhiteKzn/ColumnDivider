package com.foxminded.dmitriy.task3.integerDivision;

public class Divider {
    private static final String SPACE = " ";
    private static final String PIPE = "|";
    private static final String MINUS = "-";
    private static final String UNDERSCORE = "_";

    private int position;
    private StringBuilder log;
    private boolean isInfoPart = true;
    private int dividendLength;

    public int division(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Argument 'divisor' is 0!");
        }
        boolean positive = isPositiveResult(dividend, divisor);

        log = new StringBuilder();
        log.append(getFirstLine(dividend + PIPE + divisor));
        System.out.println(log);
        dividendLength = String.valueOf(dividend).length();
        position = getStartPosition(dividend);
        int result = divide(dividend, divisor);
        System.out.println(log);
        return positive ? result : -result;
    }

    private int getStartPosition(int dividend) {
        int index = 0;
        for (char c : String.valueOf(dividend).toCharArray()) {
            if (Character.isDigit(c))
                return index;
            index++;
        }
        return 0;

    }

    private String getFirstLine(String s) {
        return s + "\n";
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

        StringBuilder divTmp = new StringBuilder();
        divTmp.append(numberToDiv);
        move(divTmp);

        if (isInfoPart) {
            addBlockInfo(divTmp);
            isInfoPart = false;
        }else{
            log.append(divTmp + "\n");

            StringBuilder tmp = new StringBuilder();
            tmp.append(quotient * divisor);
            move(tmp);
            log.append(tmp + "\n");
        }
        for (int i = 1; i < charIndex; i++)
            position++;

        result.append(quotient);

        int remainder = numberToDiv % divisor;
        if (charIndex < dividendLength) {
            if (remainder != 0) {
                String subDividend = "" + remainder;
                subDividend = subDividend + String.valueOf(dividend).substring(charIndex);
                dividend = Integer.valueOf(subDividend);
                result.append(divide(dividend, divisor));
            } else {
                position++;
                result.append(divide(Integer.valueOf(String.valueOf(dividend).substring(charIndex)), divisor));
            }
        }
        return Integer.parseInt(result.toString());
    }

    private void addBlockInfo(StringBuilder tmp) {
        while (tmp.length() < dividendLength)
            tmp.append(SPACE);
        tmp.append(PIPE + MINUS + MINUS + MINUS + MINUS);
        log.append(tmp + "\n");
        isInfoPart = false;
    }

    private void move(StringBuilder log) {
        log.reverse();
        for (int i = 0; i < position; i++)
            log.append(SPACE);
        log.reverse();
    }

    private String getCloserNumberToDivisor(int dividend, int charIndex) {
        char chr = String.valueOf(dividend).charAt(charIndex);
        return Character.toString(chr);
    }

    private boolean isPositiveResult(int dividend, int divisor) {
        return ((dividend >= 0 && divisor > 0) || (dividend <= 0 && divisor < 0));
    }
}