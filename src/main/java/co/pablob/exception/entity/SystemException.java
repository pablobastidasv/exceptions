package co.pablob.exception.entity;

import javax.json.JsonValue;

/**
 * this exception work wrapping any system related exception that must to be wrapper to not be cached.
 */
public class SystemException extends BaseException {

    /**
     * {@inheritDoc}
     */
    public SystemException(String code, String message) {
        super(code, message);
    }

    /**
     * {@inheritDoc}
     */
    public SystemException(String code, JsonValue message) {
        super(code, message);
    }

    @Override
    protected String getPrefix() {
        return "SYS";
    }
}
