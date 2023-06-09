package ru.bebriki.bebriki.Errors;

public class WrongPasswordError extends Exception {
    public WrongPasswordError() {
        super();
    }

    public WrongPasswordError(String message) {
        super(message);
    }

    public WrongPasswordError(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongPasswordError(Throwable cause) {
        super(cause);
    }

    protected WrongPasswordError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
