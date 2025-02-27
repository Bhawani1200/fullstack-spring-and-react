package GurkhaYouthsTrainingCenter.Routine_to_do_management.service.impl;

import GurkhaYouthsTrainingCenter.Routine_to_do_management.dto.TodoDto;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.entity.Todo;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.repository.TodoRespository;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRespository todoRespository;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

//        convert TodoDto into TodoDto Jpa entity
        Todo todo=new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

//             Todo Jpa entity
        Todo savedTodo=todoRespository.save(todo);

//        convert savedTodo Jpa entity object into TodoDto object
        TodoDto savedTodoDto=new TodoDto();
        savedTodoDto.setId(savedTodo.getId());
        savedTodoDto.setTitle(savedTodo.getTitle());
        savedTodoDto.setDescription(savedTodo.getDescription());
        savedTodoDto.setCompleted(savedTodo.isCompleted());
        return savedTodoDto;
    }
}
