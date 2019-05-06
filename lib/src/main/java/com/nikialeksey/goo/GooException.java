package com.nikialeksey.goo;

public class GooException extends Exception {
    public GooException(final String message) {
        super(message);
    }

    public GooException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
