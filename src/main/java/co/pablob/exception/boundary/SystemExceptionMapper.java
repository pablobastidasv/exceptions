package co.pablob.exception.boundary;


import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import co.pablob.exception.entity.SystemException;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

@Provider
public class SystemExceptionMapper implements ExceptionMapper<SystemException> {

    @Override
    public Response toResponse(SystemException e) {
        JsonObject payload = Json.createObjectBuilder()
                .add("error", "something_happened")
                .add("message", e.getLocalizedMessage())
                .build();

        return Response.status(INTERNAL_SERVER_ERROR)
                .entity(payload)
                .build();
    }

}
