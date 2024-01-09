package com.example.trainingcore.web.dto.mapper;

import com.example.trainingcore.model.VideoContent;
import com.example.trainingcore.web.dto.VideoContentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VideoContentMapper
        extends Mappable<VideoContent, VideoContentDTO> {
}
