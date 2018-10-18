package co.pablob.exception.boundary;

import java.util.Optional;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import static co.pablob.exception.control.MapperConstants.ERROR;
import static co.pablob.exception.control.MapperConstants.MESSAGE;

public abstract class GenericExceptionMapper<T extends Throwable> implements ExceptionMapper<T> {

    protected abstract String getDefaultError();

    protected abstract String getDefaultMessage();

    protected abstract Response.Status getStatus();

    @Override
    public Response toResponse(T e) {
        final String message = Optional.ofNullable(e.getLocalizedMessage()).orElse(getDefaultMessage());

        final JsonObject payload = Json.createObjectBuilder()
                .add(ERROR, getDefaultError())
                .add(MESSAGE, message)
                .build();

        return Response.status(getStatus())
                .entity(payload)
                .build();
    }

}
