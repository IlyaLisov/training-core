package com.example.trainingcore.service.impl;

import com.example.trainingcore.model.Module;
import com.example.trainingcore.model.exception.ResourceNotFoundException;
import com.example.trainingcore.repository.ModuleRepository;
import com.example.trainingcore.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;

    @Override
    public Module getById(
            final ObjectId id
    ) {
        return moduleRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<Module> getAll(
            final Pageable page
    ) {
        return moduleRepository.findAll(page)
                .getContent();
    }

    @Override
    public Module create(
            final Module entity
    ) {
        return moduleRepository.save(entity);
    }

    @Override
    public Module update(
            final Module entity
    ) {
        Module module = getById(entity.getId());
        module.setName(entity.getName());
        module.setContent(entity.getContent());
        return moduleRepository.save(module);
    }

    @Override
    public boolean existsById(
            final ObjectId id
    ) {
        return moduleRepository.existsById(id);
    }

    @Override
    public void delete(
            final ObjectId id
    ) {
        moduleRepository.deleteById(id);
    }

}
