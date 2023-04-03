package com.timesheet.mapper;

import com.timesheet.dto.CategoryDTO;
import com.timesheet.dto.CategoryListDTO;
import com.timesheet.model.Category;
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
