package co.pablob.exception.entity;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;

/**
 * Exception that can be extended by any custom exception when the code definition is needed.
 */
public abstract class BaseException extends RuntimeException{
    private String code;
    private JsonValue jsonValue;

    /**
     * Override this method in case of prefix is needed on the exception.
     *
     * <p>
     * If prefix is defined the final code on the response will be "prefix-code".
     * </p>
     *
     * @return the prefix that will be added to the code on message response.
     */
    protected String getPrefix(){
        return "";
    }

    public BaseException() {
    }

    /**
     * @param code Code that will be added after prefix if this exist
     * @param message The message to explain the exception cause.
     */
    public BaseException(String code, String message) {
        super(message);

        this.codeGenerator(code);

        this.jsonValue = Json.createObjectBuilder().add("obj", message).build().get("obj");
    }

    public JsonValue getJsonValue() {
        return jsonValue;
    }

    public String getCode() {
        return code;
    }


    /**
     * The message in this constructor could be any {@link JsonValue} implementation.
     *
     * <ol>
     *     <li>{@link JsonObject}</li>
     *     <li>{@link javax.json.JsonArray}</li>
     *     <li>{@link JsonValue}</li>
     *     <li>{@link javax.json.JsonNumber}</li>
     * </ol>
     *
     * @param code Code that will be added after prefix if this exist
     * @param message JsonValue with information about the cause of the error.
     */
    public BaseException(String code , JsonValue message){
        this.codeGenerator(code);
        this.jsonValue = message;
    }

    /**
     * This method will create a code based on Prefix and the received code.
     *
     * In case that Prefix is empty the code will be directly the incoming code,
     * otherwise, the code will have the format "$prefix-$code".
     *
     * @param code the exception code
     */
    private void codeGenerator(String code ){
        if (getPrefix() != null && getPrefix().isEmpty()) {
            this.code = code;
        } else {
            this.code = getPrefix() + "-" + code;
        }
    }
}
