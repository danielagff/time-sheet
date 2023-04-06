package com.timesheet.service.impl;

import com.timesheet.dto.MarkingDTO;
import com.timesheet.dto.UserInformationDTO;
import com.timesheet.service.CategoryService;
import com.timesheet.service.MarkingService;
import com.timesheet.service.UserInformationService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public record UserInformationServiceImpl(CategoryService categoryService, MarkingService markingService) implements UserInformationService {

    @Override
    public UserInformationDTO getTotalTimeByDay(UserInformationDTO userInformationDTO) {

        markingService.verifyUser(userInformationDTO.getUserName());

        String categoryName = markingService.getMarkingsByOwner(new MarkingDTO(
                userInformationDTO.getUserName(),
                LocalDateTime.now())).stream().map(markingDTO -> markingDTO.getCategoryName()).findAny().get();

        List<LocalDateTime> listHour = markingService.getMarkingsByOwner(new MarkingDTO(
                        userInformationDTO.getUserName(),
                        LocalDateTime.now())).stream()
                .filter(markingDTO -> markingDTO.getCategoryName()
                        .equals(userInformationDTO.getCategoryName()))
                .map(markingDTO -> markingDTO.getMarkingTime())
                .collect(Collectors.toList());

        int totalHourSum = 0;

        for (LocalDateTime item : listHour) {
            totalHourSum += item.getMinute();
        }

        return new UserInformationDTO(userInformationDTO.getUserName(), userInformationDTO.getDay(), userInformationDTO.getMonth(), categoryName ,totalHourSum);
    }

}
