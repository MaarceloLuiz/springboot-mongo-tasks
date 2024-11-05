package com.marceloluiz.tasks.service;

import com.marceloluiz.tasks.model.Task;
import com.marceloluiz.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    //CRUD
    public Task addTask(Task task){
        return repository.save(task);
    }

    public List<Task> findAllTasks(){
        return repository.findAll();
    }

    public Task getTaskById(String taskId){
        return repository.findById(taskId).get();
    }

    public List<Task> getTaskBySeverity(int severity){
        return repository.findBySeverity(severity);
    }

    public List<Task> getTaskByAssignee(String assignee){
        return repository.findByAssignee(assignee);
    }

    public Task updateTask(Task taskRequest){
        Task existingTask = getTaskById(taskRequest.getTaskId());
        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setAssignee(taskRequest.getAssignee());
        existingTask.setSeverity(taskRequest.getSeverity());
        existingTask.setStoryPoint(taskRequest.getStoryPoint());

        return repository.save(existingTask);
    }

    public String deleteTask(String taskId){
        repository.deleteById(taskId);
        return "Task " + taskId + " was deleted from dashboard";
    }
}
