package edu.bbte.bibliospringspringdata.api;

import edu.bbte.bibliospringspringdata.api.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handlerNotFoundException(NotFoundException e) {
        return e.getType().getName() + "Entity Not Found With ID: " + e.getId();
    }
}
