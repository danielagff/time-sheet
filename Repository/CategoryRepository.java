package com.timesheet.Repository;


import com.timesheet.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "select count(1) from categories c where c.category_name =:name", nativeQuery = true)
    int findByName(String name);


}
