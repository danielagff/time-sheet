package com.timesheet.dto;

import com.timesheet.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {

    private String name;

    public Category convertToEntity()
    {
        return new Category(this.name);
    }

    public CategoryDTO() {
    }
    public CategoryDTO(String name) {
        this.name = name;
    }

}
