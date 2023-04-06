package com.timesheet.dto;

import com.timesheet.model.Marking;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MarkingDTO {

    private String userName;

    private LocalDateTime markingTime;

    private String categoryName;

    public MarkingDTO() {
    }
    public MarkingDTO(String userName, LocalDateTime markingTime) {
        this.userName = userName;
        this.markingTime = markingTime;

    }
    public MarkingDTO(String userName, LocalDateTime markingTime, String categoryName) {
        this.userName = userName;
        this.markingTime = markingTime;
        this.categoryName = categoryName;
    }

    public Marking dtoToEntity()
    {
        return new Marking(this.userName);
    }
}
