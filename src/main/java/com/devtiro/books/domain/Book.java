package com.devtiro.books.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

    private String isbn;

    private String title;

    private String author;

    @JsonProperty("year")
    private String yearPublished;
}