package com.timesheet.Repository;

import com.timesheet.Model.Marking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkingRepository extends JpaRepository<Marking, Long> {

}
