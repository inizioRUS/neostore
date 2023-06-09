package ru.bebriki.bebriki.Errors;

public class AchievementNotFoundException extends Exception {
    public AchievementNotFoundException() {
        super();
    }

    public AchievementNotFoundException(String message) {
        super(message);
    }

    public AchievementNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AchievementNotFoundException(Throwable cause) {
        super(cause);
    }

    protected AchievementNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
