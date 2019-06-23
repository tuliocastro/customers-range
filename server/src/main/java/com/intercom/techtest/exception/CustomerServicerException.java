package com.intercom.techtest.exception;

public class CustomerServicerException extends Exception {

    public CustomerServicerException() {
    }

    public CustomerServicerException(String message) {
        super(message);
    }

    public CustomerServicerException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerServicerException(Throwable cause) {
        super(cause);
    }

    public CustomerServicerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
