package com.timesheet.Service.Impl;

import com.timesheet.DTO.CategoryDTO;
import com.timesheet.DTO.CategoryListDTO;
import com.timesheet.Exception.ExistsException;
import com.timesheet.Exception.NotFoundException;
import com.timesheet.Mapper.Mapper;
import com.timesheet.Model.Category;
import com.timesheet.Repository.CategoryRepository;
import com.timesheet.Service.CategoryService;
import org.springframework.stereotype.Component;

import java.util.Optional;


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
                        new NotFoundException("We cant fount a category with ID: ")));
    }

    private void verifyUser(String name) throws ExistsException
    {
        if (categoryRepository.findByName(name) >= 1)
        {
            throw new ExistsException(name);
        }

    }
}
