package com.oocl.todolistapi.todolistapi.repositories;

import com.oocl.todolistapi.todolistapi.models.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoItemRepository extends JpaRepository<ToDoItem, Integer> {
}
