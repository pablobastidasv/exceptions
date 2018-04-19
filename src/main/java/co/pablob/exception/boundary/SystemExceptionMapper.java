package co.pablob.exception.boundary;


import java.util.Optional;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import co.pablob.exception.entity.SystemException;

import static co.pablob.exception.control.MapperConstants.ERROR;
import static co.pablob.exception.control.MapperConstants.MESSAGE;
import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

@Provider
public class SystemExceptionMapper implements ExceptionMapper<SystemException> {

    private static final String DEFAULT_ERROR = "system_exception";
    private static final String DEFAULT_MESSAGE = "System error was thrown but not catch.";

    @Override
    public Response toResponse(SystemException e) {
        String message = Optional.ofNullable(e.getLocalizedMessage())
                                .orElse(DEFAULT_MESSAGE);
        JsonObject payload = Json.createObjectBuilder()
                .add(ERROR, DEFAULT_ERROR)
                .add(MESSAGE, message)
                .build();

        return Response.status(INTERNAL_SERVER_ERROR)
                .entity(payload)
                .build();
    }

}
