package com.marceloluiz.tasks.controller;

import com.marceloluiz.tasks.model.Task;
import com.marceloluiz.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){
        return service.addTask(task);
    }

    @GetMapping
    public List<Task> getTasks(){
        return service.findAllTasks();
    }

    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable String taskId){
        return service.getTaskById(taskId);
    }

    @GetMapping("/severity/{severity}")
    public List<Task> getTaskBySeverity(@PathVariable int severity){
        return service.getTaskBySeverity(severity);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Task> getTaskBySeverity(@PathVariable String assignee){
        return service.getTaskByAssignee(assignee);
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task){
        return service.updateTask(task);
    }

    @DeleteMapping("/{taskId}")
    public String removeTask(@PathVariable String taskId){
        return service.deleteTask(taskId);
    }
}
