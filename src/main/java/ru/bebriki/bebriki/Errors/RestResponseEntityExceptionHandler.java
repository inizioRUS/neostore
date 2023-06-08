package ru.bebriki.bebriki.Errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.bebriki.bebriki.entitys.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(GoodNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(GoodNotFoundException departmentNotFoundException, WebRequest webRequest) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, departmentNotFoundException.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
