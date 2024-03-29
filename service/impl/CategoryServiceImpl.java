package com.timesheet.service.impl;

import com.timesheet.dto.CategoryDTO;
import com.timesheet.dto.CategoryListDTO;
import com.timesheet.exception.ExistsException;
import com.timesheet.exception.NotFoundException;
import com.timesheet.mapper.Mapper;
import com.timesheet.repository.CategoryRepository;
import com.timesheet.service.CategoryService;
import org.springframework.stereotype.Component;


@Component
public record CategoryServiceImpl(CategoryRepository categoryRepository, Mapper mapper) implements CategoryService {

    @Override
    public CategoryDTO createCategory(CategoryDTO category) {
        verifyUser(category.getName());
        return categoryRepository
                .save(category.convertToEntity())
                .convertToDTO();
    }
    @Override
    public CategoryListDTO findById(Long id) {
        return mapper.categoryListDTOtoEntity(categoryRepository
                .findById(id).orElseThrow(() ->
                        new NotFoundException("We can't found a category with ID: "+id.toString())));
    }

    private void verifyUser(String name) throws ExistsException
    {
        if (categoryRepository.existsByName(name))
        {
            throw new ExistsException(name);
        }

    }
}
