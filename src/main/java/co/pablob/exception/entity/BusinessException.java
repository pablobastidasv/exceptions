package co.pablob.exception.entity;

import javax.ejb.ApplicationException;

@ApplicationException
public class BusinessException extends RuntimeException{

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }
}
