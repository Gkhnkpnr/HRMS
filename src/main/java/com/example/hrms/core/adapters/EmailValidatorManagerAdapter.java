package com.example.hrms.core.adapters;

import com.example.hrms.core.services.EmailCheckService;
import com.example.hrms.emailValidator.EmailValidatorManager;
import com.example.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailValidatorManagerAdapter implements EmailCheckService {
    private final EmailValidatorManager emailValidatorManager;


    @Autowired
    public EmailValidatorManagerAdapter(EmailValidatorManager emailValidatorManager) {
        this.emailValidatorManager = emailValidatorManager;
    }

    @Override
    public String emailValidator(User user) {
        return this.emailValidatorManager.emailValidator(user);
    }
}
