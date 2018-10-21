package co.pablob.exception.entity;

public class ResourceNotFoundException extends BaseException{

    /**
     * {@inheritDoc}
     */
    public ResourceNotFoundException(String code, String message) {
        super(code, message);
    }

    @Override
    protected String getPrefix() {
        return "BEX";
    }
}