package com.timesheet.Service.Impl;

import com.timesheet.DTO.MarkingDTO;
import com.timesheet.Exception.NotFoundException;
import com.timesheet.Model.Marking;
import com.timesheet.Repository.CategoryRepository;
import com.timesheet.Repository.MarkingRepository;
import com.timesheet.Service.MarkingService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public record MarkingServiceImpl(MarkingRepository repository, CategoryRepository categoryRepository) implements MarkingService {

    @Override
    public MarkingDTO createMarking(Long id, MarkingDTO marking) {

        Marking entity = marking.dtoToEntity();

        entity.setMarkingTime(LocalDateTime.now());

        entity.setCategory(categoryRepository.findById(id).orElseThrow(() -> new NotFoundException(id.toString())));

        return repository.save(entity).entityToDTO();
    }

    public List<MarkingDTO> getMarkingsByOwner(MarkingDTO markingDTO)
    {
       return repository.findAll().stream()
               .filter(m -> m.getUserName().equals(markingDTO.getUserName()))
               .map(Marking::entityToDTO).collect(Collectors.toList());
    }
}
