package com.danieloh.tinyurl.exception;


public class MalformedUrlException extends RuntimeException {
    public MalformedUrlException() {
        super();
    }

    public MalformedUrlException(final String message) {
        super(message);
    }

    public MalformedUrlException(final Exception cause) {
        super(cause);
    }

    public MalformedUrlException(final String message, final Exception cause) {
        super(message, cause);
    }

}
