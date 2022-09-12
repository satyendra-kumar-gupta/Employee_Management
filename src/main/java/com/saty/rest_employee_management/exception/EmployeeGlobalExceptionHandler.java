package com.saty.rest_employee_management.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.jws.WebResult;
import java.util.Date;

@RestController
@ControllerAdvice
public class EmployeeGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
        EmployeeExceptionResponse exceptionResponse = new EmployeeExceptionResponse(ex.getMessage(),
                request.getDescription(false),new Date());
         return new ResponseEntity<Object>(exceptionResponse, HttpStatus.ACCEPTED);
    }

    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException(Exception ex, WebRequest request){
        EmployeeExceptionResponse exceptionResponse = new EmployeeExceptionResponse(ex.getMessage(),
                request.getDescription(false),new Date());
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request){
        EmployeeExceptionResponse exceptionResponse = new EmployeeExceptionResponse("Invalid Input",
                ex.getBindingResult().toString(), new Date());
    return new ResponseEntity<Object>(exceptionResponse,HttpStatus.ACCEPTED.BAD_REQUEST);
    }
}
