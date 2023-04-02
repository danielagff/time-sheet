package com.timesheet.Service;

import com.timesheet.DTO.CategoryDTO;
import com.timesheet.DTO.CategoryListDTO;
import com.timesheet.Model.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO category);

    CategoryListDTO findById(Long id);

}
