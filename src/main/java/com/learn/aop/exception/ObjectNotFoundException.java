package com.learn.aop.exception;

public class ObjectNotFoundException extends Exception {
    private static String message = "ID not found. Specify ID of object to be deleted.";

    public ObjectNotFoundException() {
        super(message);
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
