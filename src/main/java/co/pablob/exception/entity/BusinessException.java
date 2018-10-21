package co.pablob.exception.entity;

/**
 * this exception work wrapping any business related exception.
 */
public class BusinessException extends BaseException {

    /**
     * {@inheritDoc}
     */
    public BusinessException(String code, String message) {
        super(code, message);
    }

    @Override
    protected String getPrefix() {
        return "BEX";
    }
}
