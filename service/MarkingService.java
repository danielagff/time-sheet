package com.timesheet.service;

import com.timesheet.dto.CategoryDTO;
import com.timesheet.dto.MarkingDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface MarkingService {

    MarkingDTO createMarking(Long id, MarkingDTO marking);

    List<MarkingDTO> getMarkingsByOwner(MarkingDTO markingDTO);

    List<MarkingDTO> getMarkingsByCategoryName(CategoryDTO categoryDTO);

    List<MarkingDTO> getMarkingsByDateAndUserAndCategory(LocalDateTime time, String userName, CategoryDTO categoryDTO);

    void verifyUser(String user);

}
