package co.pablob.exception.entity;

import javax.json.JsonValue;

public class ResourceNotFoundException extends BaseException{

    /**
     * {@inheritDoc}
     */
    public ResourceNotFoundException(String code, String message) {
        super(code, message);
    }

    /**
     * {@inheritDoc}
     */
    public ResourceNotFoundException(String code, JsonValue message) {
        super(code, message);
    }

    @Override
    protected String getPrefix() {
        return "BEX";
    }
}
