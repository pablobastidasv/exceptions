package co.pablob.exception.entity;

import javax.ejb.ApplicationException;

@ApplicationException
public class SystemException extends RuntimeException{

    public SystemException() {
    }

    public SystemException(String message) {
        super(message);
    }
}
