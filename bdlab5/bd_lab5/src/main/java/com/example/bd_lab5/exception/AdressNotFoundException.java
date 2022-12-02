package com.example.bd_lab5.exception;

public class AdressNotFoundException extends RuntimeException{
    public AdressNotFoundException(Integer id){
        super("Could not find adress with" + id + " id");
    }
}
