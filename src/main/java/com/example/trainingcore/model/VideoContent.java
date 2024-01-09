package com.example.trainingcore.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("video_contents")
@Getter
@Setter
public class VideoContent {

    private String videoURL;

}
