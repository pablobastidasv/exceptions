package co.pablob.exception.boundary;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Provider
public class NotFoundExceptionMapper extends GenericExceptionMapper<NotFoundException> {
    private static final String DEFAULT_MESSAGE = "Resource was not found";
    private static final String DEFAULT_ERROR = "resource_not_found";

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
        return NOT_FOUND;
    }
}
