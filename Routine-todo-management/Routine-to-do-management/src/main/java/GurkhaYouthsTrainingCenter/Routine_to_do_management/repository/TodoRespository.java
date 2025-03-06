package GurkhaYouthsTrainingCenter.Routine_to_do_management.repository;

import GurkhaYouthsTrainingCenter.Routine_to_do_management.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRespository extends JpaRepository<Todo,Long> {
}
