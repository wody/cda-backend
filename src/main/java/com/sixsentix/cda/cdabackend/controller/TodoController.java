package com.sixsentix.cda.cdabackend.controller;

import com.sixsentix.cda.cdabackend.model.Todo;
import com.sixsentix.cda.cdabackend.repository.TodoRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/todo")
public class TodoController {

  @Autowired
  private TodoRepository todoRepository;

  @GetMapping
  public @ResponseBody
  Iterable<Todo> getAllTodos() {
    return todoRepository.findAllByOrderByIdDesc();
  }

  @GetMapping("/open")
  public @ResponseBody
  Integer getNrOpenTodos() {
    return todoRepository.getNrOpenTodos();
  }

  /**
   * Save a new Todo item.
   *
   * @param todo item to be created
   * @return created todo item
   */
  @PostMapping
  public @ResponseBody
  Todo save(@RequestBody Todo todo) {
    if (todo.getDone() == null) {
      todo.setDone(false);
    }
    if (todo.getDateAdded() == null) {
      todo.setDateAdded(new Date());
    }
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

  @DeleteMapping("/cleanup")
  public void removeDoneTodos() {
    todoRepository.deleteDoneTodos();
  }
}
