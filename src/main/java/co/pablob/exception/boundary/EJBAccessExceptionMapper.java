package co.pablob.exception.boundary;

import javax.ejb.EJBAccessException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

@Provider
public class EJBAccessExceptionMapper implements ExceptionMapper<EJBAccessException> {

    @Override
    public Response toResponse(EJBAccessException e) {
        JsonObject payload = Json.createObjectBuilder()
                .add("error", "access_not_allowed")
                .add("message", e.getLocalizedMessage())
                .build();

        return Response.status(UNAUTHORIZED)
                .entity(payload)
                .build();
    }

}
