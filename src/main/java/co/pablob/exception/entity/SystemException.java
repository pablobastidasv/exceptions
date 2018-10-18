package co.pablob.exception.entity;

public class SystemException extends RuntimeException {

    public SystemException() {
    }

    public SystemException(String message, Throwable e) {
        super(message, e);
    }

    public SystemException(String message) {
        super(message);
    }
}
