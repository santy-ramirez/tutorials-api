package com.santi.tutorial.exepcion;

public class NotFoundTutorialException extends RuntimeException{
    public NotFoundTutorialException(String message){
        super(message);
    }
}
