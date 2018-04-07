package co.pablob.exception.boundary;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import co.pablob.exception.entity.BusinessException;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {

    @Override
    public Response toResponse(BusinessException e) {
        JsonObject payload = Json.createObjectBuilder()
                .add("error", "business_exception")
                .add("message", e.getLocalizedMessage())
                .build();

        return Response.status(BAD_REQUEST)
                .entity(payload)
                .build();
    }

}
