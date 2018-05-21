package com.ntiamoah.springboot.taskman.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dntiamoah on 17/05/2018.
 */


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
