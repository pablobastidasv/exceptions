package co.pablob.exception.boundary;

import javax.ejb.EJBAccessException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

@Provider
public class EJBAccessExceptionMapper extends GenericExceptionMapper<EJBAccessException> {

    private static final String DEFAULT_ERROR = "access_not_allowed";
    private static final String DEFAULT_MESSAGE = "User does not have right to do this operation.";

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
        return UNAUTHORIZED;
    }

}
