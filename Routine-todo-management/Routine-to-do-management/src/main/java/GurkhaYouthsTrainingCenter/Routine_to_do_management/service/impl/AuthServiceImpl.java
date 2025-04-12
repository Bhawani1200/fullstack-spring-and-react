package GurkhaYouthsTrainingCenter.Routine_to_do_management.service.impl;

import GurkhaYouthsTrainingCenter.Routine_to_do_management.dto.RegisterDto;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.entity.Role;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.entity.User;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.exception.TodoAPIException;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.repository.RoleRepository;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.repository.UserRepository;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public String register(RegisterDto registerDto) {

//        check username is already exists in the database
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new TodoAPIException(HttpStatus.BAD_REQUEST,"Username already exists");
        }

//        check email is already exists in the database
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new TodoAPIException(HttpStatus.BAD_REQUEST,"Email already exists");
        }

        User user=new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles =new HashSet<>();
        Role userRole=roleRepository.findByName("ROLE_USER");
        roles.add(userRole);

        user.setRoles(roles);

        userRepository.save(user);
        return "User registered successfully!!!";
    }
}
