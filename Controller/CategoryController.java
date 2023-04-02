package com.timesheet.Controller;

import com.timesheet.DTO.CategoryDTO;
import com.timesheet.DTO.CategoryListDTO;
import com.timesheet.Model.Category;
import com.timesheet.Service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public record CategoryController(CategoryService categoryService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO)
    {
        return categoryService.createCategory(categoryDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryListDTO> getCategoryById(@PathVariable Long id)
    {
        return ResponseEntity.ok(categoryService.findById(id));
    }

}
