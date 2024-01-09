package com.example.trainingcore.web.dto.mapper;

import com.example.trainingcore.model.Module;
import com.example.trainingcore.web.dto.ModuleDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuleMapper extends Mappable<Module, ModuleDTO> {
}
