package com.dxctraining.usermgt.exceptions;

public class UnAuthorizedException extends RuntimeException{
    public UnAuthorizedException(String msg){
        super(msg);
    }
}
