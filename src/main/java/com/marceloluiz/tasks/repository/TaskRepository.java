package com.marceloluiz.tasks.repository;

import com.marceloluiz.tasks.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findBySeverity(int severity);
    List<Task> findByAssignee(String assignee);
}
