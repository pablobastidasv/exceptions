package co.pablob.exception.entity;

/**
 * Exception that can be extended by any custom exception when the code definition is needed.
 */
public abstract class BaseException extends RuntimeException{
    private String code;

    /**
     * Override this method in case of prefix is needed on the exception.
     *
     * <p>
     * If prefix is defined the final code on the response will be "prefix-code".
     * </p>
     *
     * @return the prefix that will be added to the code on message response.
     */
    protected String getPrefix(){
        return "";
    }

    public BaseException() {
    }

    /**
     * @param code Code that will be added after prefix if this exist
     * @param message The message to explain the exception cause.
     */
    public BaseException(String code, String message) {
        super(message);
        if (getPrefix().isEmpty()) {
            this.code = code;
        } else {
            this.code = getPrefix() + "-" + code;
        }
    }

    public String getCode() {
        return code;
    }
}
