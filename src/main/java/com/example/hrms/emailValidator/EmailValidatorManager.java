package com.example.hrms.emailValidator;

import com.example.hrms.entities.concretes.User;
import org.springframework.stereotype.Service;

@Service
public class EmailValidatorManager {
    public String emailValidator(User user){
        return "Doğrulama kodu " + user.getEmail() + " adresine gönderildi.";
    }
}
