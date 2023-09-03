package com.hmaitech.onlineshop.exceptions;

public class RuntimeServiceException extends RuntimeException{

    private final String errorCode;

    public RuntimeServiceException(String errorCode) {
        this.errorCode = errorCode;
    }

    public RuntimeServiceException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public RuntimeServiceException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public RuntimeServiceException(Throwable cause, String errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public RuntimeServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}