package com.timesheet.repository;

import com.timesheet.model.Marking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkingRepository extends JpaRepository<Marking, Long> {
    boolean existsByUserName(String userName);
}
