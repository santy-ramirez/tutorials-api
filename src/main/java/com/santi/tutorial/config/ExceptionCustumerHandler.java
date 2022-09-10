package com.santi.tutorial.config;

import com.santi.tutorial.exepcion.NotFoundTutorialException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionCustumerHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundTutorialException.class)
    public ResponseEntity<Object> handlerExceptionTutorialForIdNotFound(NotFoundTutorialException ex,
                                                                        WebRequest request){
        Map<String,String> errors = new HashMap<>();
        errors.put("error: ","have errors");
        errors.put("message: ", ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.ACCEPTED);
    };
}
