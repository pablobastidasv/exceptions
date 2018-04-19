package co.pablob.exception.boundary;

import com.mongodb.ErrorCategory;
import com.mongodb.MongoWriteException;
import com.mongodb.WriteError;

import java.util.Optional;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static co.pablob.exception.control.MapperConstants.ERROR;
import static co.pablob.exception.control.MapperConstants.MESSAGE;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

@Provider
public class MongoWriteExceptionMapper implements ExceptionMapper<MongoWriteException> {
    private static final String DEFAULT_ERROR = "mongo_writer_error";
    private static final String DEFAULT_MESSAGE = "Error doing write operation in mongo database";

    @Override
    public Response toResponse(MongoWriteException e) {


        final Optional<ErrorCategory> category = Optional.ofNullable(e.getError())
                .map(WriteError::getCategory);

        final String error = category
                .map(ErrorCategory::name)
                .map(String::toLowerCase)
                .orElse(DEFAULT_ERROR);

        final String message = Optional.ofNullable(e.getLocalizedMessage()).orElse(DEFAULT_MESSAGE);

        final JsonObject payload = Json.createObjectBuilder()
                .add(ERROR, error)
                .add(MESSAGE, message)
                .build();

        final Response.Status status = category
                .filter(c -> c == ErrorCategory.DUPLICATE_KEY)
                .map(c -> BAD_REQUEST)
                .orElse(INTERNAL_SERVER_ERROR);

        return Response.status(status)
                .entity(payload)
                .build();
    }

}
