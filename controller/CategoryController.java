package com.timesheet.controller;

import com.timesheet.dto.CategoryDTO;
import com.timesheet.dto.CategoryListDTO;
import com.timesheet.service.CategoryService;
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

    @GetMapping("/testeAmanda")
    public ResponseEntity<Integer> getAmanda()
    {
        int a = 5+5;
        return ResponseEntity.ok(a);
    }

}
