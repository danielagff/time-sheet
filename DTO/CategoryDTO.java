package com.timesheet.DTO;

import com.timesheet.Model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
