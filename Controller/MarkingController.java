package com.timesheet.Controller;

import com.timesheet.DTO.CategoryDTO;
import com.timesheet.DTO.MarkingDTO;
import com.timesheet.Service.MarkingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/marking")
public record MarkingController(MarkingService markingService) {

    @PostMapping("/{id}")
    public MarkingDTO createMarking(@PathVariable Long id, @RequestBody MarkingDTO markingDTO)
    {
        return markingService.createMarking(id, markingDTO);
    }

    @PostMapping
    public ResponseEntity<List<MarkingDTO>> getAllMarkingsByUserName(@RequestBody MarkingDTO markingDTO)
    {
        return ResponseEntity.ok(markingService.getMarkingsByOwner(markingDTO));
    }

    @PatchMapping
    public ResponseEntity<List<MarkingDTO>> getAllMarkingsByCategoryName(@RequestBody CategoryDTO categoryDTO)
    {
       return ResponseEntity.ok(markingService.getMarkingsByCategoryName(categoryDTO));
    }

    @PatchMapping("/filter/{time}&{userName}")
    public ResponseEntity<List<MarkingDTO>> getAllMarkingsByUserCategoryAndTime(@PathVariable LocalDateTime time,
                                                                                @PathVariable String userName,
                                                                                @RequestBody CategoryDTO categoryDTO)
    {

        return ResponseEntity.ok(markingService.getMarkingsByDateAndUserAndCategory(time, userName, categoryDTO));
    }

}
