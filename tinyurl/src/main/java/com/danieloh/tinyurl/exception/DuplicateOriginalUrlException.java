package com.danieloh.tinyurl.exception;


public class DuplicateOriginalUrlException extends RuntimeException {
    public DuplicateOriginalUrlException() {
        super();
    }

    public DuplicateOriginalUrlException(final String message) {
        super(message);
    }

    public DuplicateOriginalUrlException(final Exception cause) {
        super(cause);
    }

    public DuplicateOriginalUrlException(final String message, final Exception cause) {
        super(message, cause);
    }
}