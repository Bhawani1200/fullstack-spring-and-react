package GurkhaYouthsTrainingCenter.Routine_to_do_management.controller;


import GurkhaYouthsTrainingCenter.Routine_to_do_management.dto.TodoDto;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.entity.Todo;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/todos")
public class TodoController {

    private TodoService todoService;

//    Build addTodo rest api

    @PostMapping
    public ResponseEntity<TodoDto>addTodo(@RequestBody TodoDto todoDto){
        TodoDto savedTodo=todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

//    Build get Todo REST API
    @GetMapping("{id}")
    public ResponseEntity<TodoDto>getTodo(@PathVariable("id") Long todoId){
       TodoDto todoDto= todoService.getTodo(todoId);
       return new ResponseEntity<>(todoDto,HttpStatus.OK);
    }

    //    Build getAll Todo REST API
    @GetMapping
    public ResponseEntity<List<TodoDto>>getAllTodos() {
        List<TodoDto> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

//    Build update Todo REST APi
    @PutMapping("{id}")
    public ResponseEntity<TodoDto>updateTodo(
            @RequestBody TodoDto todoDto,
            @PathVariable("id") Long todoId){
        TodoDto updatedTodo=todoService.updateTodo(todoDto,todoId);
        return ResponseEntity.ok(updatedTodo);
    }

//    build delete REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteTodo(@PathVariable("id") Long todoId){
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("Todo deleted successfully");
    }

//    build in complete RESt API
    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto>completedTodo(@PathVariable("id") Long completedId){
        TodoDto savedCompleted=todoService.completeTodo(completedId);
        return ResponseEntity.ok(savedCompleted);
    }

}
