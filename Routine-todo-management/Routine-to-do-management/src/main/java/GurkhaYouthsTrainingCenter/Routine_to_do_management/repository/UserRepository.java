package GurkhaYouthsTrainingCenter.Routine_to_do_management.repository;

import GurkhaYouthsTrainingCenter.Routine_to_do_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User>findByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<User>findByUsernameOrEmail(String username, String email);

}
