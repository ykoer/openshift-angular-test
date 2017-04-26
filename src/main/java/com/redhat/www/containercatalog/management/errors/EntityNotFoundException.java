package com.redhat.www.containercatalog.management.errors;

public class EntityNotFoundException extends Exception {


    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
