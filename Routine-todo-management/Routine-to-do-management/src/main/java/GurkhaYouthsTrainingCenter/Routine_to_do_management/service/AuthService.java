package GurkhaYouthsTrainingCenter.Routine_to_do_management.service;

import GurkhaYouthsTrainingCenter.Routine_to_do_management.dto.LoginDto;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);
}
