package com.pequenosgenios.pg.services.exceptions;

public class InexistentStudentException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InexistentStudentException(String msg) {
        super(msg);
    }

    public InexistentStudentException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
