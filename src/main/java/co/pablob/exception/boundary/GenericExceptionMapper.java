package co.pablob.exception.boundary;

import java.util.Optional;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import co.pablob.exception.entity.BaseException;

/**
 * Utility class to wrap the logic behind an ExceptionMapper making easy to create any new ExceptionMapper
 * when it will be needed.
 *
 * @param <T> The exception class will be Wrapper
 */
public abstract class GenericExceptionMapper<T extends Throwable> implements ExceptionMapper<T> {

    private static final String CODE = "code";
    private static final String MESSAGE = "message";

    /**
     * A return code should be provided to be added on response message
     *
     * @return The code of the error
     */
    protected abstract String getCode();

    /**
     * A default message in case of {@link Throwable#getLocalizedMessage()} returns {@code null}.
     */
    protected abstract String getDefaultMessage();

    /**
     * Http Status to {@link Response}
     */
    protected abstract Response.Status getStatus();

    /**
     * {@inheritDoc}
     */
    @Override
    public Response toResponse(T e) {
        final JsonValue message = obtainMessage(e);
        final String code = obtainCode(e);

        final JsonObject payload = Json.createObjectBuilder()
                .add(CODE, code)
                .add(MESSAGE, message)
                .build();

        return Response.status(getStatus())
                .entity(payload)
                .build();
    }

    private JsonValue obtainMessage(T e) {
        if(e instanceof BaseException){
            BaseException exception = (BaseException) e;
            return exception.getJsonValue();
        } else {
            return Json.createObjectBuilder()
                    .add("msg", e.getLocalizedMessage())
                    .build()
                    .get("msg");
        }
    }

    /**
     * The code that will be added to the response.
     *
     * <p>
     * If Exception extends {@link BaseException} the message will be the returned by
     * {@link GenericExceptionMapper#getCode()} in case not, the code will be "EXC-000".
     * </p>
     *
     */
    private String obtainCode(T e) {
        if (e instanceof BaseException) {
            BaseException baseException = (BaseException) e;
            return Optional.ofNullable(baseException.getCode()).orElse(getCode());
        } else {
            return "EXC-000";
        }
    }

}
