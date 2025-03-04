package GurkhaYouthsTrainingCenter.Routine_to_do_management.service.impl;

import GurkhaYouthsTrainingCenter.Routine_to_do_management.Exception.ResourceNotFoundException;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.dto.TodoDto;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.entity.Todo;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.repository.TodoRespository;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.service.TodoService;
import org.modelmapper.ModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRespository todoRespository;

    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

      //convert TodoDto into TodoDto Jpa entity
        Todo todo=modelMapper.map(todoDto,Todo.class);

      // Todo Jpa entity
        Todo savedTodo=todoRespository.save(todo);

   //convert savedTodo Jpa entity object into TodoDto object
   TodoDto savedTodoDto=modelMapper.map(savedTodo,TodoDto.class);
        return savedTodoDto;
    }

    @Override
    public TodoDto getTodo(Long id) {
        Todo todo=todoRespository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Tod with given id not found:"+id));
        return modelMapper.map(todo,TodoDto.class);
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo>todos=todoRespository.findAll();
        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long id) {
       Todo todo= todoRespository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Tod with given id is not found"+id));
       todo.setTitle(todoDto.getTitle());
       todo.setDescription(todoDto.getDescription());
       todo.setCompleted(todoDto.isCompleted());
       Todo savedTodo=todoRespository.save(todo);
        return modelMapper.map(savedTodo,TodoDto.class);
    }

    @Override
    public void deleteTodo(Long id) {
       Todo todo= todoRespository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Todo with the given id is not found:"+id));
       todoRespository.deleteById(id);
    }

    @Override
    public TodoDto completeTodo(Long id) {
        Todo todo=todoRespository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("The given todo is not found"+id));
        todo.setCompleted(Boolean.TRUE);
        Todo savedTodo=todoRespository.save(todo);
        return modelMapper.map(savedTodo,TodoDto.class);
    }


}
