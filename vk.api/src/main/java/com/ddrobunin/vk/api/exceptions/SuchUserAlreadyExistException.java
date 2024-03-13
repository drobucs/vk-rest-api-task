package com.ddrobunin.vk.api.exceptions;

public class SuchUserAlreadyExistException extends RuntimeException {
    public SuchUserAlreadyExistException(String message) {
        super(message);
    }
}
