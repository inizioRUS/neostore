package ru.bebriki.bebriki.Errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.bebriki.bebriki.entitys.ErrorMessage;


public class WorkerNotFoundException extends Exception {
    public WorkerNotFoundException() {
        super();
    }

    public WorkerNotFoundException(String message) {
        super(message);
    }

    public WorkerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public WorkerNotFoundException(Throwable cause) {
        super(cause);
    }

    protected WorkerNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
