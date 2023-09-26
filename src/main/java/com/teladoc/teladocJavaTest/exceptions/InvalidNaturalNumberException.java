package com.teladoc.teladocJavaTest.exceptions;

public class InvalidNaturalNumberException extends RuntimeException {
    public InvalidNaturalNumberException(String message, Throwable cause){
        super(message, cause);
    };
}
