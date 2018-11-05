package co.pablob.exception.entity;

import javax.json.JsonValue;

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

    /**
     * {@inheritDoc}
     */
    public BusinessException(String code, JsonValue message) {
        super(code, message);
    }


    @Override
    protected String getPrefix() {
        return "BEX";
    }
}
