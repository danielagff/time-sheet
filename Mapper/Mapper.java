package com.timesheet.Mapper;

import com.timesheet.DTO.CategoryDTO;
import com.timesheet.DTO.CategoryListDTO;
import com.timesheet.DTO.MarkingDTO;
import com.timesheet.Model.Category;
import com.timesheet.Model.Marking;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Mapper {
    public Category categoryToDTO(CategoryDTO categoryDTO) {
        return new Category(categoryDTO.getName());
    }


    public CategoryListDTO categoryListDTOtoEntity(Category category) {
        return new CategoryListDTO(category.getName(),
                category.getMarkings().stream()
                        .map(marking -> marking.entityToDTO())
                        .collect(Collectors.toList()));
    }

}
