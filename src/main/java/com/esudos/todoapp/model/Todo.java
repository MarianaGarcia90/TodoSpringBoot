package com.esudos.todoapp.model;


import com.mongodb.lang.NonNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class Todo {

    @Id
    private String id; //no mongo o id é tipo String

    @NonNull
    private String description;
    @NonNull
    private boolean done;
    private LocalDateTime createdAt;

    public Todo(String id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
        this.createdAt = LocalDateTime.now();
    }

    public Todo(){
        this.createdAt = LocalDateTime.now();
    }
}
