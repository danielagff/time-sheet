package com.timesheet.DTO;

import com.timesheet.Model.Marking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MarkingDTO {

    private String userName;

    private LocalDateTime markingTime;

    public MarkingDTO() {
    }
    public MarkingDTO(String userName, LocalDateTime markingTime) {
        this.userName = userName;
        this.markingTime = markingTime;

    }

    public Marking dtoToEntity()
    {
        return new Marking(this.userName);
    }
}
