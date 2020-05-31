package com.sixsentix.cda.cdabackend.repository;

import com.sixsentix.cda.cdabackend.model.Todo;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
    @Query("SELECT count(*) FROM todos where done = false")
    Integer getNrOpenTodos();

    @Modifying
    @Query("UPDATE todos SET done = NOT done WHERE id = :id")
    void toggleDone(@Param("id") Integer id);

    Iterable<Todo> findAllByOrderByIdDesc();

    @Modifying
    @Query("DELETE FROM todos WHERE done = true")
    void deleteDoneTodos();
}
