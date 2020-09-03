package com.danieloh.tinyurl.exception;

public class TinyUrlIdNotFoundException extends RuntimeException {
    public TinyUrlIdNotFoundException() {
        super();
    }

    public TinyUrlIdNotFoundException(final String message) {
        super(message);
    }

    public TinyUrlIdNotFoundException(final Exception cause) {
        super(cause);
    }

    public TinyUrlIdNotFoundException(final String message, final Exception cause) {
        super(message, cause);
    }
}
