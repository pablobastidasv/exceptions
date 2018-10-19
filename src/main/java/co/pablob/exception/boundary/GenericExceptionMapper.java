package co.pablob.exception.boundary;

import co.pablob.exception.entity.BaseException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.Optional;

import static co.pablob.exception.entity.MapperConstants.CODE;
import static co.pablob.exception.entity.MapperConstants.MESSAGE;

public abstract class GenericExceptionMapper<T extends Throwable> implements ExceptionMapper<T> {

    protected abstract String getCode();

    protected abstract String getDefaultMessage();

    protected abstract Response.Status getStatus();

    @Override
    public Response toResponse(T e) {
        final String message = Optional.ofNullable(e.getLocalizedMessage()).orElse(getDefaultMessage());
        final String code;
        if (e instanceof BaseException) {
            BaseException baseException = (BaseException) e;
            code = Optional.ofNullable(baseException.getCode()).orElse(getCode());
        } else {
            code = "EXC-000";
        }

        final JsonObject payload = Json.createObjectBuilder()
                .add(CODE, code)
                .add(MESSAGE, message)
                .build();

        return Response.status(getStatus())
                .entity(payload)
                .build();
    }

}
