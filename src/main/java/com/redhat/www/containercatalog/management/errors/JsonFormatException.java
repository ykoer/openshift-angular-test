package com.redhat.www.containercatalog.management.errors;

public class JsonFormatException extends Exception {

    public JsonFormatException(String message) {
        super(message);
    }

    public JsonFormatException(String message, Throwable cause) {
        super(message, cause);
    }

}
