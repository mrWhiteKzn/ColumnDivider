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
        int remainder;
        StringBuilder sb = new StringBuilder();
        
        // первая строка
        int divResult = dividend / divisor;
        System.out.println(UNDERSCORE + dividend + PIPE + divisor);
        //

        // service
        int didivend2 = dividend;

        while ((dividend / divisor) > MAX_DECIMAL) {
            divisor *= MULTIPLIER;
            rank *= MULTIPLIER;
        }
//        result.append(dividend / divisor);
        remainder = dividend % divisor;

        // вывод

        int dividendLen = String.valueOf(UNDERSCORE + dividend).length();
        int index = 1;
        int rightSpaces = String.valueOf(divResult).length() - index;
        int digit = Integer.valueOf(String.valueOf(divResult).charAt(0) - '0');
        int subtrahend = divisor / rank * digit;
        int leftSpaces = dividendLen - rightSpaces - String.valueOf(subtrahend).length();

        append(sb, SPACE, leftSpaces);
        sb.append(subtrahend);
        append(sb, SPACE, rightSpaces);
        sb.append(PIPE);

        for (int i = 0; i < String.valueOf(divResult).length(); i++) {
            sb.append(MINUS);
        }
        sb.append("\n");
        //
        // service
//        didivend2 -= subtrahend * rank;
        boolean first = true;

        while (rank != START_POSITION) {
            didivend2 -= subtrahend * rank;
            digit = Integer.valueOf(String.valueOf(divResult).charAt(index) - '0');
            index++;
            rightSpaces = String.valueOf(divResult).length() - index;

            divisor /= MULTIPLIER;
            rank /= MULTIPLIER;
            dividend = remainder;
//            result.append(dividend / divisor);
            remainder = dividend % divisor;

            // вывод
            String sMinuend = String.valueOf(didivend2);
            sMinuend = sMinuend.substring(0, sMinuend.length() - rightSpaces);
            leftSpaces = dividendLen - rightSpaces - sMinuend.length()-1;
            append(sb, SPACE, leftSpaces);
            sb.append(UNDERSCORE).append(sMinuend);
            append(sb,SPACE, rightSpaces);
            if(first){
                sb.append(PIPE).append(divResult);
                first = false;
            }
            sb.append("\n");

            subtrahend = divisor / rank * digit;
            int subtrahendLeftSpaces = dividendLen - rightSpaces - String.valueOf(subtrahend).length();
            append(sb, SPACE, subtrahendLeftSpaces);
            sb.append(subtrahend);
            sb.append("\n");
            //
        }

        index = dividendLen - String.valueOf(remainder).length();
        append(sb, SPACE, index);
        sb.append(remainder);
        System.out.println(sb);
        return result.toString();
    }

    private void append(StringBuilder sb, String symbol, int count) {
        for (int i = 0; i < count; i++) sb.append(symbol);
    }
}