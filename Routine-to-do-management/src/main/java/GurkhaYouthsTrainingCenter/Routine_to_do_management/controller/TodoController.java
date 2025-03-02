package GurkhaYouthsTrainingCenter.Routine_to_do_management.controller;


import GurkhaYouthsTrainingCenter.Routine_to_do_management.dto.TodoDto;
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

    @GetMapping("{id}")
    public ResponseEntity<TodoDto>getTodo(@PathVariable("id") Long todoId){
       TodoDto todoDto= todoService.getTodo(todoId);
       return new ResponseEntity<>(todoDto,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<TodoDto>>getAllTodos() {
        List<TodoDto> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
}
}
