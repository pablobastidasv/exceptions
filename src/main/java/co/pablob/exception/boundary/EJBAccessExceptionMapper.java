package co.pablob.exception.boundary;

import javax.ejb.EJBAccessException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static co.pablob.exception.control.MapperConstants.ERROR;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

@Provider
public class EJBAccessExceptionMapper implements ExceptionMapper<EJBAccessException> {

    private static final String DEFAULT_ERROR = "access_not_allowed";

    @Override
    public Response toResponse(EJBAccessException e) {
        JsonObject payload = Json.createObjectBuilder()
                .add(ERROR, DEFAULT_ERROR)
                .build();

        return Response.status(UNAUTHORIZED)
                .entity(payload)
                .build();
    }

}
