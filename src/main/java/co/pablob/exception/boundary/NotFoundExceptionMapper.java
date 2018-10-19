package co.pablob.exception.boundary;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Provider
public class NotFoundExceptionMapper extends GenericExceptionMapper<NotFoundException> {
    private static final String DEFAULT_CODE = "BEX-404";
    private static final String DEFAULT_MESSAGE = "Resource not found";

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
        return NOT_FOUND;
    }
}
