package GurkhaYouthsTrainingCenter.Routine_to_do_management.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class TodoAPIException extends RuntimeException{
    private HttpStatus status;
    private String message;
}
