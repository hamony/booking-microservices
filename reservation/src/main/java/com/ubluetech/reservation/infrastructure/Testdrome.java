package com.ubluetech.reservation.infrastructure;

public class Testdrome {
    public static class TextInput {
        StringBuilder builder = new StringBuilder();
        public void add(char c) {
            builder.append(c);
        }
        
        public String getValue() {
            return builder.toString();
        }
    }

    public static class NumericInput extends TextInput {
        @Override
        public void add(char c) {
            if (Character.isDigit(c)) {
                super.add(c);
            }
        }
    }

    public static void main(String[] args) {
        NumericInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}
