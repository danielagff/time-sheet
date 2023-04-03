package com.timesheet.service;

import com.timesheet.dto.CategoryDTO;
import com.timesheet.dto.CategoryListDTO;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO category);

    CategoryListDTO findById(Long id);

}
