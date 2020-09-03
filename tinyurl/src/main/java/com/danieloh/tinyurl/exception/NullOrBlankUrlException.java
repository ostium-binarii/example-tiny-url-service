package com.danieloh.tinyurl.exception;


public class NullOrBlankUrlException extends RuntimeException {
    public NullOrBlankUrlException() {
        super();
    }

    public NullOrBlankUrlException(final String message) {
        super(message);
    }

    public NullOrBlankUrlException(final Exception cause) {
        super(cause);
    }

    public NullOrBlankUrlException(final String message, final Exception cause) {
        super(message, cause);
    }
}
