package com.github.ankurpapneja4.bookkeeper.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(){
        super("Not Found");
    }
}
