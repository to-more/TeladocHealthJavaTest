package com.teladoc.teladocJavaTest.exceptions;

public class InvalidNegativeNumberException extends RuntimeException {
    public InvalidNegativeNumberException(String message){
        super(message);
    };
}
