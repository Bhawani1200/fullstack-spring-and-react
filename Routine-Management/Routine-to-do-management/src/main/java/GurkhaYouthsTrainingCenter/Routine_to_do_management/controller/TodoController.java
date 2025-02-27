package GurkhaYouthsTrainingCenter.Routine_to_do_management.controller;


import GurkhaYouthsTrainingCenter.Routine_to_do_management.dto.TodoDto;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
