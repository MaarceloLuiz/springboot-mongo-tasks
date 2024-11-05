package com.marceloluiz.tasks.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collation = "tasks")
@Data
@Builder //using builder instead of constructors to create a more clear and readable instance of the 'Task'
public class Task {
    @Id
    private final String taskId;
    private String description;
    private int severity;
    private String assignee;
    private int storyPoint;

    public static class TaskBuilder{
        private String taskId = UUID.randomUUID().toString().split("-")[0];

        public TaskBuilder taskId(String taskId){
            this.taskId = taskId;
            return this;
        }
    }
}
