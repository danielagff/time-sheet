package com.timesheet.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInformationDTO {
    private String userName;
    private String day;
    private String month;
    private String categoryName;
    private int totalValue;

    public UserInformationDTO() {
    }
    public UserInformationDTO(String userName, String day, String month, int totalValue) {
        this.userName = userName;
        this.day = day;
        this.month = month;
        this.totalValue = totalValue;
    }

    public UserInformationDTO(String userName, String day, String month, String categoryName, int totalValue) {
        this.userName = userName;
        this.day = day;
        this.month = month;
        this.categoryName = categoryName;
        this.totalValue = totalValue;
    }
}
