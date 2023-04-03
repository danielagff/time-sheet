package com.timesheet.DTO;

import com.timesheet.Model.Marking;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryListDTO {

    private String name;

    private List<MarkingDTO> markingDTOS = new ArrayList<>();

    public CategoryListDTO(){}

    public CategoryListDTO(String name) {
        this.name = name;
    }

    public CategoryListDTO(String name, List<MarkingDTO> markingDTOS) {
        this.name = name;
        this.markingDTOS = markingDTOS;
    }
}
