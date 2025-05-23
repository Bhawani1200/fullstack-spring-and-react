package GurkhaYouthsTrainingCenter.Routine_to_do_management.controller;

import GurkhaYouthsTrainingCenter.Routine_to_do_management.dto.JwtAuthResponse;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.dto.LoginDto;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.dto.RegisterDto;
import GurkhaYouthsTrainingCenter.Routine_to_do_management.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;


//    build register REST API
    @PostMapping("/register")
    public ResponseEntity<String>register(@RequestBody RegisterDto registerDto){
      String response  =  authService.register(registerDto);
      return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    build login REST API

   @PostMapping("/login")
    public  ResponseEntity<JwtAuthResponse>login(@RequestBody LoginDto loginDto){
       String token= authService.login(loginDto);

       JwtAuthResponse jwtAuthResponse=new JwtAuthResponse();
       jwtAuthResponse.setAccessToken(token);
       return new ResponseEntity<>(jwtAuthResponse,HttpStatus.CREATED);
    }
}
