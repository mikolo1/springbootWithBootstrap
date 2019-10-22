package mikolo.hellospringboot.controller;

import mikolo.hellospringboot.exception.EntityNotFoundException;
import mikolo.hellospringboot.model.DtoError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

   @ResponseStatus(HttpStatus.NOT_FOUND)
   @ExceptionHandler(EntityNotFoundException.class)
    public DtoError handleEntityNotFoundException(EntityNotFoundException e) {
        DtoError error = new DtoError();
        error.setExceptionClass(e.getClass().getCanonicalName());
        error.setMessage(e.getMessage());
        return error;
    }
}
