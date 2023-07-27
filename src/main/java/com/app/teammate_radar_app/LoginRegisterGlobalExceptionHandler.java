package com.app.teammate_radar_app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class LoginRegisterGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(
            ResourceNotFoundException ex) {

        List<String> details = new ArrayList<String>();
        details.add(ex.getMessage());

        LoginRegisterErrorHandler err = new LoginRegisterErrorHandler(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                "Resource Not Found" , (org.hibernate.mapping.List) details);

        return ResponseEntityBuilder.build(err);
    }
}