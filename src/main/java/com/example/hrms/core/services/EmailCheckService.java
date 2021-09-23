package com.example.hrms.core.services;

import com.example.hrms.entities.concretes.User;

public interface EmailCheckService {
    String emailValidator(User user);
}
