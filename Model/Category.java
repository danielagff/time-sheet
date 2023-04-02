package com.timesheet.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.timesheet.DTO.CategoryDTO;
import com.timesheet.DTO.CategoryListDTO;
import com.timesheet.DTO.MarkingDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "categories")
@Getter @Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Marking> markings;

    public Category() {

    }
    public Category(String name) {
        this.name = name;
    }

    public Category(String name, List<Marking> markings) {
        this.name = name;
        this.markings = markings;
    }
    public CategoryDTO convertToDTO()
    {
        return new CategoryDTO(this.name);
    }


}
