package com.example.trainingcore.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("text_contents")
@Getter
@Setter
public class TextContent {

    private String text;

}
