package GurkhaYouthsTrainingCenter.Routine_to_do_management.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderImpl {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

        System.out.println(passwordEncoder.encode("bhawani"));
        System.out.println(passwordEncoder.encode("admin"));
        System.out.println(passwordEncoder.encode("ram"));
    }
}

