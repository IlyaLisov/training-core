package com.example.trainingcore.web.dto.mapper;

import com.example.trainingcore.model.TextContent;
import com.example.trainingcore.web.dto.TextContentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TextContentMapper
        extends Mappable<TextContent, TextContentDTO> {
}
