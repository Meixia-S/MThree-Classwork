package org.example.Data;

import java.util.*;

public interface ToDoDao {

  ToDo add(ToDo todo);

  List<ToDo> getAll();

  ToDo findById(int id);

  // true if item exists and is updated
  boolean update(ToDo todo);

  // true if item exists and is deleted
  boolean deleteById(int id);
}