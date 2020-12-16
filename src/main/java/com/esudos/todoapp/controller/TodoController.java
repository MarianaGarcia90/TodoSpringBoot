package com.esudos.todoapp.controller;

import com.esudos.todoapp.model.Todo;
import com.esudos.todoapp.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public List<Todo> showList(){
        return todoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo addTask (@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeTask(@PathVariable String id) {
        Optional<Todo> removeTask= todoRepository.findById(id);

        if (removeTask.isPresent()) {
            todoRepository.deleteById(id);
            return new ResponseEntity<>(removeTask.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}


