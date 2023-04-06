package com.timesheet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.timesheet.dto.MarkingDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "markings")
@Getter
@Setter
public class Marking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marking_id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "marking_time")
    private LocalDateTime markingTime;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnoreProperties("markings")
    private Category category;

    public Marking() {
    }
    public Marking(String userName) {
        this.userName = userName;
    }

    public MarkingDTO entityToDTO()
    {
        return new MarkingDTO(this.userName, this.markingTime, this.category.getName());
    }



}