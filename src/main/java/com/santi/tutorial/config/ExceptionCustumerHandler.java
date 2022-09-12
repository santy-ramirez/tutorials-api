package com.santi.tutorial.config;

import com.santi.tutorial.exepcion.NotFoundTutorialException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionCustumerHandler extends ResponseEntityExceptionHandler {

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                               HttpHeaders headers,
                                                               HttpStatus status,
                                                               WebRequest request) {
        ApiError error = new ApiError();
        error.setStatus(status);
        error.setMensaje("Validation Error");
        error.setCantidadDeErrores(ex.getErrorCount());
        List<ApiSubError> subErrors = ex.getBindingResult().getFieldErrors().stream().map(fieldError -> new ApiSubError(fieldError.getField(),fieldError.getDefaultMessage())).collect(Collectors.toList());
        error.setSubError(subErrors);
        return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundTutorialException.class)
    public ResponseEntity<Object> handlerExceptionTutorialForIdNotFound(NotFoundTutorialException ex,
                                                                        WebRequest request){
        Map<String,String> errors = new HashMap<>();
        errors.put("error: ","have errors");
        errors.put("message: ", ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    };
}
