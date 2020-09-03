package com.danieloh.tinyurl.exception;


public class DuplicateTinyUrlIdException extends RuntimeException {
    public DuplicateTinyUrlIdException() {
        super();
    }

    public DuplicateTinyUrlIdException(final String message) {
        super(message);
    }

    public DuplicateTinyUrlIdException(final Exception cause) {
        super(cause);
    }

    public DuplicateTinyUrlIdException(final String message, final Exception cause) {
        super(message, cause);
    }
}
