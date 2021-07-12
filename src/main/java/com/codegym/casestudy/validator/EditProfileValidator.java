package com.codegym.casestudy.validator;

import com.codegym.casestudy.entity.User;
import com.codegym.casestudy.model.EditProfile;
import com.codegym.casestudy.repository.IUserRepository;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EditProfileValidator implements Validator {
    @Autowired
    IUserRepository repository;

    private EmailValidator emailValidator = new EmailValidator();

    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return clazz == EditProfile.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        // TODO Auto-generated method stub
        EditProfile entity = (EditProfile) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotBlank.userModel.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotBlank.userModel.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirm", "NotBlank.userModel.confirm");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullname", "NotBlank.userModel.fullname");



        if(!errors.hasFieldErrors("email")) {
//            if(!this.emailValidator.isValid(entity.getEmail())) {
//                errors.rejectValue("email", "Pattern.userModel.email");
//            }
            User user = repository.findByEmail(entity.getEmail());
            if(user != null) {
                errors.rejectValue("email", "Duplicate.userModel.email");
            }
        }
    }
}
