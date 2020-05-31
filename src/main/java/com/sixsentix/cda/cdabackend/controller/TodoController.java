package com.sixsentix.cda.cdabackend.controller;

import com.sixsentix.cda.cdabackend.model.Todo;
import com.sixsentix.cda.cdabackend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public @ResponseBody Iterable<Todo> getAllTodos(){
        return todoRepository.findAllByOrderByIdDesc();
    }

    @GetMapping("/open")
    public @ResponseBody Integer getNrOpenTodos() {
        return todoRepository.getNrOpenTodos();
    }

    @PostMapping
    public @ResponseBody Todo save(@RequestBody Todo todo) {
        if (todo.getDone() == null) todo.setDone(false);
        if (todo.getDateAdded() == null) todo.setDateAdded(new Date());
        return todoRepository.save(todo);
    }

    @PutMapping("/toggle/{id}")
    public void toggleDone(@PathVariable Integer id) {
        todoRepository.toggleDone(id);
    }

    @DeleteMapping("/{id}")
    public void removeTodo(@PathVariable Integer id) {
        todoRepository.deleteById(id);
    }
}
