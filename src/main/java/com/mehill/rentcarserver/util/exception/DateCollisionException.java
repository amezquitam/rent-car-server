package com.mehill.rentcarserver.util.exception;

public class DateCollisionException extends RuntimeException {
    public DateCollisionException(String message) {
        super(message);
    }
}
