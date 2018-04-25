package co.pablob.exception.boundary;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import co.pablob.exception.entity.SystemException;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

@Provider
public class SystemExceptionMapper extends GenericExceptionMapper<SystemException> {

    private static final String DEFAULT_ERROR = "system_exception";
    private static final String DEFAULT_MESSAGE = "System error was thrown but not catch.";

    @Override
    protected String getDefaultError() {
        return DEFAULT_ERROR;
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
