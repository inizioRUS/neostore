package ru.bebriki.bebriki.Errors;

public class GoodNotFoundException extends Exception {
    public GoodNotFoundException() {
        super();
    }

    public GoodNotFoundException(String message) {
        super(message);
    }

    public GoodNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoodNotFoundException(Throwable cause) {
        super(cause);
    }

    protected GoodNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
