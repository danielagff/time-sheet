package com.timesheet.Service.Impl;

import com.timesheet.DTO.CategoryDTO;
import com.timesheet.DTO.MarkingDTO;
import com.timesheet.Exception.NotFoundException;
import com.timesheet.Model.Category;
import com.timesheet.Model.Marking;
import com.timesheet.Repository.CategoryRepository;
import com.timesheet.Repository.MarkingRepository;
import com.timesheet.Service.MarkingService;
import org.springframework.stereotype.Component;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public record MarkingServiceImpl(MarkingRepository markingRepository, CategoryRepository categoryRepository) implements MarkingService {

    @Override
    public MarkingDTO createMarking(Long id, MarkingDTO markingDTO) {

        Marking entity = markingDTO.dtoToEntity();

        entity.setMarkingTime(LocalDateTime.now());

        entity.setCategory(categoryRepository.findById(id).orElseThrow(() -> new NotFoundException(id.toString())));

        return markingRepository.save(entity).entityToDTO();
    }

    public List<MarkingDTO> getMarkingsByOwner(MarkingDTO markingDTO)
    {
       return markingRepository.findAll().stream()
               .filter(m -> m.getUserName().equals(markingDTO.getUserName()))
               .map(Marking::entityToDTO).collect(Collectors.toList());
    }

    public List<MarkingDTO> getMarkingsByCategoryName(CategoryDTO categoryDTO)
    {
        getCategoryByName(categoryDTO.getName());

        return markingRepository.findAll().stream()
                .filter(marking -> marking.getCategory().getName()
                        .equals(categoryDTO.getName()))
                .map(Marking::entityToDTO).collect(Collectors.toList());
    }

    public List<MarkingDTO> getMarkingsByDateAndUserAndCategory(LocalDateTime time, String userName, CategoryDTO categoryDTO)
    {
        String decodedUserName = URLDecoder.decode(userName, StandardCharsets.UTF_8);

        verifyUser(decodedUserName);

        return getMarkingsByCategoryName(categoryDTO).stream()
                .filter(m -> m.getUserName().equals(decodedUserName) &&
                        m.getMarkingTime().getMonth().equals(time.getMonth()) &&
                        m.getMarkingTime().getDayOfMonth() == time.getDayOfMonth())
                .collect(Collectors.toList());
    }

    private void getCategoryByName(String name)
    {
        categoryRepository.findAll().stream()
                .filter(c -> c.getName().equals(name))
                .map(Category::convertToDTO).findAny()
                .orElseThrow(() -> new NotFoundException(name));
    }

    private void verifyUser(String user)
    {
         if(!markingRepository.existsByUserName(user))
         {
             throw new NotFoundException("this user name ("+user+") don't exists");
         }
    }
}
