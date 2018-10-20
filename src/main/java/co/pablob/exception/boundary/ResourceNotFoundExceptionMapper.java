package co.pablob.exception.boundary;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import co.pablob.exception.entity.ResourceNotFoundException;

@Provider
public class ResourceNotFoundExceptionMapper extends GenericExceptionMapper<ResourceNotFoundException>{

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getCode() {
        return "BEX-404";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getDefaultMessage() {
        return "Resource not found";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Response.Status getStatus() {
        return Response.Status.NOT_FOUND;
    }
}
