package com.codegym.casestudy.validator;

import com.codegym.casestudy.entity.User;
import com.codegym.casestudy.model.Register;
import com.codegym.casestudy.repository.IUserRepository;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RegisterValidator implements Validator {
    @Autowired
    private IUserRepository repository;

    private EmailValidator emailValidator = new EmailValidator();

    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return clazz == Register.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
// TODO Auto-generated method stub
        Register entity = (Register) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotBlank.userRegister.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotBlank.userRegister.username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotBlank.userRegister.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirm", "NotBlank.userRegister.confirm");

//        if(!this.emailValidator.isValid(entity.getEmail())) {
//            errors.rejectValue("email", "Pattern.userRegister.email");
//        }

        if(!errors.hasFieldErrors("email")) {
            User user = repository.findByEmail(entity.getEmail());
            if(user != null) {
                errors.rejectValue("email", "Duplicate.userRegister.email");
            }
        }

        if(!errors.hasFieldErrors("password")) {
            if(entity.getPassword().length()<7) {
                errors.rejectValue("password", "Min.userRegister.password");
            }
            if(entity.getPassword().length()>15) {
                errors.rejectValue("password", "Max.userRegister.password");
            }
        }

        if(!errors.hasFieldErrors("confirm")) {
            if(entity.getPassword().equals(entity.getConfirm()) == false) {
                errors.rejectValue("confirm", "NotDuplicate.userRegister.password");
            }
        }
    }
}
