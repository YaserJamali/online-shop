package com.hmaitech.onlineshop.exceptions;


import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

@ControllerAdvice
public class RestExceptionHandler {


    private static Properties property = new Properties();
    private static final Logger LOGGER= LoggerFactory.getLogger(RestExceptionHandler.class);


    @PostConstruct
    public void init(){
        try {
            property.load(new FileReader("src/main/resources/exceptions_fa_IR.properties",StandardCharsets.UTF_8) );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> handleException(ServiceException exception) {
        ExceptionResponse value = new ExceptionResponse();
        value.setError(true);
        LOGGER.error("System Has Exception",exception);

        switch (exception.getErrorCode()) {
            case "default": {
                value.setMessage(property.getProperty("default"));
                break;
            }
        }

//
//        if (serviceException instanceof IllegalArgumentException ){
//            value.setMessage("داده وروردی اشتباه است");
//        }
//        if (serviceException instanceof FatalBeanException){
//            value.setMessage("این یوزر وجود ندارد");
//        }
//        if (serviceException instanceof MethodArgumentTypeMismatchException){
//            value.setMessage("نوع داده ورودی اشتباه است");
//        }
//        if(serviceException instanceof MissingServletRequestParameterException){
//            value.setMessage("داده ای برای عملیات داده نشده است");
//        }


        return ResponseEntity.badRequest().body(value);
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> handleException(RuntimeException runtimeException) {
        LOGGER.error("System Has Runtime Exception",runtimeException);
        ExceptionResponse value = new ExceptionResponse();
        value.setError(true);

        value.setMessage(property.getProperty("unknown"));

        return ResponseEntity.badRequest().body(value);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> handleException(MethodArgumentNotValidException exception) {
        LOGGER.error("System Has Validation Exception",exception);
        ExceptionResponse value = new ExceptionResponse();
        value.setError(true);
        FieldError fieldError = exception.getBindingResult().getFieldError();

        String message = "Error In Field '" + fieldError.getField() + "' " + fieldError.getDefaultMessage();
        value.setMessage(message);

        return ResponseEntity.badRequest().body(value);
    }

}