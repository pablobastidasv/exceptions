package co.pablob.exception.boundary;

import co.pablob.exception.entity.SystemException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

@Provider
public class SystemExceptionMapper extends GenericExceptionMapper<SystemException> {

    private static final String DEFAULT_CODE = "SYS-000";
    private static final String DEFAULT_MESSAGE = "System error was thrown but not catch.";

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
        return INTERNAL_SERVER_ERROR;
    }

}
