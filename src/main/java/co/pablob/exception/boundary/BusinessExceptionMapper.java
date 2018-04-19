package co.pablob.exception.boundary;

import java.util.Optional;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import co.pablob.exception.entity.BusinessException;

import static co.pablob.exception.control.MapperConstants.ERROR;
import static co.pablob.exception.control.MapperConstants.MESSAGE;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {

    private static final String DEFAULT_ERROR = "business_exception.";
    private static final String DEFAULT_MESSAGE = "Business error not catch was thrown.";

    @Override
    public Response toResponse(BusinessException e) {
        final String message = Optional.ofNullable(e.getLocalizedMessage())
                .orElse(DEFAULT_MESSAGE);

        JsonObject payload = Json.createObjectBuilder()
                .add(ERROR, DEFAULT_ERROR)
                .add(MESSAGE, message)
                .build();

        return Response.status(BAD_REQUEST)
                .entity(payload)
                .build();
    }

}
