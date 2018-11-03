package co.pablob.exception.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonString;

import static org.junit.jupiter.api.Assertions.*;

class BaseExceptionImplsTest {

    private String code = "123";

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Default interaction with String message should work as normal")
    void prefixCodeMessageMustToBeOk() {
        // Given
        String message = "To the sour melon add garlic, chocolate, cabbage juice and sichuan-style pork butt.";

        // When
        ResourceNotFoundException exception = new ResourceNotFoundException(code, message);

        // Then
        assertEquals("BEX", exception.getPrefix());
        assertEquals("BEX-" + code, exception.getCode());
        assertEquals(message, ((JsonString) exception.getJsonValue()).getString());
    }

    @Test
    @DisplayName("Message is a JsonObject.")
    void jsonObjectMessageTest() {
        // Given
        JsonObject message = getJsonObject(
                "WARNING",
                "name",
                "Impositio manducares, tanquam mirabilis fluctui."
        );

        // When
        SystemException exception = new SystemException(code, message);

        // Then
        assertEquals("SYS", exception.getPrefix());
        assertEquals("SYS-" + code, exception.getCode());
        assertEquals(message, exception.getJsonValue());
    }

    @Test
    @DisplayName("Message is an Array")
    void jsonArrayMessageTest(){
        // Given
        JsonObject message1 = getJsonObject(
                "WARNING",
                "name",
                "Why does the parrot die?"
        );
        JsonObject message2 = getJsonObject(
                "INFO",
                "last_name",
                "Impositio manducares, tanquam mirabilis fluctui."
        );

        JsonArray messages = Json.createArrayBuilder()
                .add(message1)
                .add(message2)
                .build();

        // When
        BusinessException exception = new BusinessException(code, messages);

        // Then
        assertEquals("BEX", exception.getPrefix());
        assertEquals("BEX-" + code, exception.getCode());
        assertEquals(messages, exception.getJsonValue());


    }

    private JsonObject getJsonObject(String level, String field, String message) {
        return Json.createObjectBuilder()
                .add("level", level)
                .add("field", field)
                .add("msg", message)
                .build();
    }
}