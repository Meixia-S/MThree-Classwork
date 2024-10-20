package org.example.Controller;

import corbos.todoapi.data.ToDoDao;
import corbos.todoapi.models.ToDo;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {

  private final ToDoDao dao;

  public ToDoController(ToDoDao dao) {
    this.dao = dao;
  }

  @GetMapping
  public List<ToDo> all() {
    return dao.getAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ToDo create(@RequestBody ToDo todo) {
    return dao.add(todo);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ToDo> findById(@PathVariable int id) {
    ToDo result = dao.findById(id);
    if (result == null) {
      return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(result);
  }

  @PutMapping("/{id}")
  public ResponseEntity update(@PathVariable int id, @RequestBody ToDo todo) {
    ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
    if (id != todo.getId()) {
      response = new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
    } else if (dao.update(todo)) {
      response = new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    return response;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable int id) {
    if (dao.deleteById(id)) {
      return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity(HttpStatus.NOT_FOUND);
  }
}