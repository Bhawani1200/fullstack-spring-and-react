package GurkhaYouthsTrainingCenter.Routine_to_do_management.service;

import GurkhaYouthsTrainingCenter.Routine_to_do_management.dto.TodoDto;

public interface TodoService {
    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodo(Long id);
}
