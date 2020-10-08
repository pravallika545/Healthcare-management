package com.dxc.gateway.exceptions;

public class IncorrectCredentialsException extends RuntimeException {
    public IncorrectCredentialsException(String msg) {
        super(msg);
    }
}
