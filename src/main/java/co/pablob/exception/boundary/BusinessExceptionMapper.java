package co.pablob.exception.boundary;

import co.pablob.exception.entity.BusinessException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

/**
 *
 */
@Provider
public class BusinessExceptionMapper extends GenericExceptionMapper<BusinessException> {

    private static final String DEFAULT_CODE = "BEX-000";
    private static final String DEFAULT_MESSAGE = "Business error not catch was thrown.";

    @Override
    protected String getCode() {
        return DEFAULT_CODE;
    }

    @Override
    protected String getDefaultMessage() {
        return DEFAULT_MESSAGE;
    }

    @Override
    protected Response.Status getStatus() {
        return BAD_REQUEST;
    }
}
