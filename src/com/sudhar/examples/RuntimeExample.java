package com.sudhar.examples;

public class RuntimeExample {

    public static void main(final String[] args) {

        try {

            if (true) {
                throw new CustomRuntimeException("custom runtime message");
            } else {
                throw new CustomException("custom message");
            }
        } catch (CustomException  e) {
            System.out.println(e.getMessage());
        }
    }
}

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

class CustomRuntimeException extends RuntimeException {
    public CustomRuntimeException(String message) {
        super(message);
    }
}
