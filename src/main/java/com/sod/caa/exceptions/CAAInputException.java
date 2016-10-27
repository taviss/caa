package com.sod.caa.exceptions;

public class CAAInputException extends Exception {

    public CAAInputException(String message) {
        super(message);
    }

    public CAAInputException(Throwable cause) {
        super(cause);
    }

    public CAAInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
