package com.codegym.casestudy.validator;

import com.codegym.casestudy.entity.User;
import com.codegym.casestudy.model.ChangePass;
import com.codegym.casestudy.repository.IUserRepository;
import com.codegym.casestudy.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ChangePassValidator implements Validator {
    @Autowired
    IUserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return clazz== ChangePass.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        // TODO Auto-generated method stub
        ChangePass entity = (ChangePass) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullname", "NotBlank.changePass.fullname");

        if(!entity.getOldPassword().isEmpty()) {
            User user = repository.findByEmail(entity.getEmail());
            if(encoder.matches(entity.getOldPassword(), user.getPassword()) == false) {
                errors.rejectValue("oldPassword", "NotDuplicate.changePass.oldPassword");
            }
            else {
                if(entity.getNewPassword().isEmpty()) {
                    errors.rejectValue("newPassword", "NotBlank.changePass.newPassword");
                }
                else {
                    if(entity.getNewPassword().length()<7) {
                        errors.rejectValue("newPassword", "Min.changePass.newPassword");
                    }
                    if(entity.getNewPassword().length()>15) {
                        errors.rejectValue("newPassword", "Max.changePass.newPassword");
                    }
                }
                if(entity.getConfirm().isEmpty()) {
                    errors.rejectValue("confirm", "NotBlank.changePass.confirm");
                }
                if((!entity.getNewPassword().isEmpty())&&(!entity.getConfirm().isEmpty())) {
                    if(!entity.getNewPassword().equals(entity.getConfirm())) {
                        errors.rejectValue("confirm", "NotDuplicate.changePass.confirm");
                    }
                }
            }
        }
    }
}
