package com.devtiro.books;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import com.devtiro.books.domain.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JacksonTests {
    @Test
    public void testThatObjectMapperCanCreateJsonFromObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Book book =
                Book.builder()
                        .isbn("978-0-13-478627-5")
                        .title("The Enigma of Eternity")
                        .author("Aria Montgomery")
                        .yearPublished("2005")
                        .build();


        String result = objectMapper.writeValueAsString(book);
        assertThat(result).isEqualTo("{\"isbn\":\"978-0-13-478627-5\",\"title\":\"The Enigma of Eternity\",\"author\":\"Aria Montgomery\",\"year\":\"2005\"}");

    }

    @Test
    public void testThatObjectMapperCanCreateJavaObjectFromJsonObject() throws JsonProcessingException {
        Book book =
                Book.builder()
                        .isbn("978-0-13-478627-5")
                        .title("The Enigma of Eternity")
                        .author("Aria Montgomery")
                        .yearPublished("2005")
                        .build();

        String json =
                "{\"foo\":\"foo\", \"isbn\":\"978-0-13-478627-5\",\"title\":\"The Enigma of"
                        + " Eternity\",\"author\":\"Aria Montgomery\",\"year\":\"2005\"}";

        final ObjectMapper objectMapper = new ObjectMapper();
        Book result = objectMapper.readValue(json, Book.class);

        assertThat(result).isEqualTo(book);
    }


}