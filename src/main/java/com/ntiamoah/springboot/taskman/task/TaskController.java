package com.ntiamoah.springboot.taskman.task;

import com.ntiamoah.springboot.taskman.common.Title;
import com.ntiamoah.springboot.taskman.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by dntiamoah on 17/05/2018.
 */
@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;


    @GetMapping("/findAll")
    public List<Task> getAllTasks() {

        List<Task> taskList = taskRepository.findAll();

        return taskList;
    }

    @GetMapping("/findAllOrderBy/{orderBy}")
    public List<Task> findAllOrderBy(@PathVariable(value = "orderBy") String orderBy) {

        String order = orderBy;
        List<Task> orderedTasks;
        switch (order) {

            case "FirstNameAsc":
                orderedTasks = taskRepository.findAllByOrderByFirstNameAsc();
                break;
            case "LastNameAsc":
                orderedTasks = taskRepository.findAllByOrderByLastNameAsc();
                break;
            case "ScheduledDateAsc":
                orderedTasks = taskRepository.findAllByOrderByScheduledDateAsc();
                break;
            case "FirstNameDesc":
                orderedTasks = taskRepository.findAllByOrderByFirstNameDesc();
                break;
            case "LastNameDesc":
                orderedTasks = taskRepository.findAllByOrderByLastNameDesc();
                break;
            case "ScheduledDateDesc":
                orderedTasks = taskRepository.findAllByOrderByScheduledDateDesc();
                break;
            default:
                orderedTasks = taskRepository.findAll();
        }
//        TODO implement UI side logic to build sort request
//        return orderedTasks;

        return taskRepository.findAllByOrderByFirstNameAsc();
    }


    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {

        return taskRepository.save(task);
    }

    @GetMapping("/findById/{id}")
    public Task getTaskById(@PathVariable(value = "id") Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("task", "id", id));
    }

    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable(value = "id") Long id, @Valid @RequestBody Task changeTask) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("task", "id", id));

        task.setTitle(changeTask.getTitle());
        task.setFirstName(changeTask.getFirstName());
        task.setLastName(changeTask.getLastName());
        task.setScheduledDate(changeTask.getScheduledDate());
        task.setNotes(changeTask.getNotes());

        return taskRepository.save(task);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteTAsk(@PathVariable(value = "id") Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("task", "id", id));

        taskRepository.delete(task);

        return ResponseEntity.ok().build();
    }

//    @GetMapping("/titles")
//    public List<Title> getTitles(){
//        List<Title> titles = Stream.of(EnumSet.allOf(Title.class));
//    }


}
