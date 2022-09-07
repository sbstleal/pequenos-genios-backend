package com.pequenosgenios.pg.services.exceptions;

public class EmailAlredyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EmailAlredyExistsException(String msg) {
        super(msg);
    }

    public EmailAlredyExistsException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
