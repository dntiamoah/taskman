package com.ntiamoah.springboot.taskman.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dntiamoah on 17/05/2018.
 */


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    //Enable static ORDER BY for a required sorting fields
    List<Task> findAllByOrderByFirstNameAsc();
    List<Task> findAllByOrderByFirstNameDesc();

    List<Task> findAllByOrderByLastNameAsc();
    List<Task> findAllByOrderByLastNameDesc();

    List<Task> findAllByOrderByScheduledDateAsc();
    List<Task> findAllByOrderByScheduledDateDesc();

    // Enable distinct flag for status filtering
    List<Task> findDistinctTaskByStatus(String status);

}
