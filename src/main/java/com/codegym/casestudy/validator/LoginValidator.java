package com.codegym.casestudy.validator;

import com.codegym.casestudy.entity.User;
import com.codegym.casestudy.model.Login;
import com.codegym.casestudy.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LoginValidator implements Validator {
    @Autowired
    private IUserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return clazz == Login.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        // TODO Auto-generated method stub
        Login entity = (Login) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotBlank.userLogin.username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotBlank.userLogin.password");

        if (!errors.hasFieldErrors()) {
            User user = repository.findByEmail(entity.getUsername());
            if (user == null) {
                errors.rejectValue("username", "NotFind.userLogin.username");
                errors.rejectValue("password", "NotFind.userLogin.password");
            } else {
                passwordEncoder.matches(user.getPassword(), entity.getPassword());
                if (user.getPassword().equals(entity.getPassword()) == false) {
                    if (passwordEncoder.matches(entity.getPassword(), user.getPassword()) == false) {
                        errors.rejectValue("password", "NotFind.userLogin.password");
                    }
                    errors.rejectValue("password", "NotFind.userLogin.password");
                }
            }
        }
    }
}
