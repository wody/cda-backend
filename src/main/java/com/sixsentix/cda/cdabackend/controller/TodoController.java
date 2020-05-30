package com.sixsentix.cda.cdabackend.controller;

import com.sixsentix.cda.cdabackend.model.Todo;
import com.sixsentix.cda.cdabackend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/todo")
    public @ResponseBody Iterable<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    @GetMapping("/todo/open")
    public @ResponseBody Integer getNrOpenTodos() {
        return todoRepository.getNrOpenTodos();
    }

    @PostMapping("/todo")
    public @ResponseBody Todo save(@RequestBody Todo todo) {
        if (todo.getDone() == null) todo.setDone(false);
        if (todo.getDate_added() == null) todo.setDate_added(new Date());
        return todoRepository.save(todo);
    }

    @PutMapping("/todo/toggle/{id}")
    public void toggleDone(@PathVariable Integer id) {
        todoRepository.toggleDone(id);
    }

    @DeleteMapping("/todo/{id}")
    public void removeTodo(@PathVariable Integer id) {
        todoRepository.deleteById(id);
    }
}
