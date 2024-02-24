package edu.bbte.bibliospring.backend.web;

import edu.bbte.bibliospring.backend.service.ServiceException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public String handleServiceException(ServiceException e, Model model) {
        model.addAttribute("error", "Service error: " + e.getMessage());
        return "error";
    }
}

