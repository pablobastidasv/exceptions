package co.pablob.exception.entity;

public abstract class BaseException extends RuntimeException{
    private String code;

    public BaseException() {
    }

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
