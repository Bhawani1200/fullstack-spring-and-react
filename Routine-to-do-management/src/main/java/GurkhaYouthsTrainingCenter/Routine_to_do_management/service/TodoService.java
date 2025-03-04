package GurkhaYouthsTrainingCenter.Routine_to_do_management.service;

import GurkhaYouthsTrainingCenter.Routine_to_do_management.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodo(Long id);

    List<TodoDto> getAllTodos();

    TodoDto updateTodo(TodoDto todoDto,Long id);

    void deleteTodo(Long id);

    TodoDto completeTodo(Long id);
}
