package com.example.demo.exception;

import org.hibernate.boot.MappingException;
import org.hibernate.boot.jaxb.Origin;

public class CURDMappingException extends RuntimeException {
    public CURDMappingException(String message){
        super(message);
    }
}
