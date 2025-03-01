package GurkhaYouthsTrainingCenter.Routine_to_do_management.service.impl;

import GurkhaYouthsTrainingCenter.Routine_to_do_management.dto.TodoDto;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.entity.Todo;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.repository.TodoRespository;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.service.TodoService;
import org.modelmapper.ModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRespository todoRespository;

    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

//        convert TodoDto into TodoDto Jpa entity
//        Todo todo=new Todo();
//        todo.setTitle(todoDto.getTitle());
//        todo.setDescription(todoDto.getDescription());
//        todo.setCompleted(todoDto.isCompleted());

        Todo todo=modelMapper.map(TodoDto,Todo.class);

//             Todo Jpa entity
        Todo savedTodo=todoRespository.save(todo);

//        convert savedTodo Jpa entity object into TodoDto object
   TodoDto savedTodoDto=modelMapper.map(todoDto,TodoDto.class);
        return savedTodoDto;
    }

    @Override
    public TodoDto getTodo(Long id) {
        Todo todo=todoRespository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Tod with given id not found:"+id));
        return modelMapper.map(todo,TodoDto.class);
    }

}
