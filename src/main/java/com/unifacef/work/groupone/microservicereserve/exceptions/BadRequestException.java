package com.unifacef.work.groupone.microservicereserve.exceptions;

public class BadRequestException extends RuntimeException{
    private static final long serialVersionUID = -3402384881877918499L;

    public BadRequestException(final String mesage){
        super(mesage);
    }
}
