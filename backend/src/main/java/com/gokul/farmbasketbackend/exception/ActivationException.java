package com.gokul.farmbasketbackend.exception;

import lombok.Getter;

@Getter
public class ActivationException extends RuntimeException{
    private final String ActException;


    public ActivationException(String actException) {
        ActException = actException;
    }
}
