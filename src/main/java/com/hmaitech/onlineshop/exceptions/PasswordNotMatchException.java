package com.hmaitech.onlineshop.exceptions;

public class PasswordNotMatchException extends ServiceException{
    public PasswordNotMatchException(String message) {
        super(message);
    }
}
