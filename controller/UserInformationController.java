package com.timesheet.controller;

import com.timesheet.dto.UserInformationDTO;
import com.timesheet.service.UserInformationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userinfos")
public record UserInformationController(UserInformationService userInformationService) {

    @PatchMapping
    public ResponseEntity<UserInformationDTO> getInformationByUser(@RequestBody UserInformationDTO userInformationDTO)
    {
        return ResponseEntity.ok(userInformationService.getTotalTimeByDay(userInformationDTO));
    }

}
