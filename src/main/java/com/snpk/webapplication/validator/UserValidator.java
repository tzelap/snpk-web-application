package com.snpk.webapplication.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.snpk.webapplication.model.User;
import com.snpk.webapplication.services.UserService;

@Component
public class UserValidator implements Validator{
    @Autowired 
    UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
       User user = (User) target;
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
       if (user.getUsername().length() < 4 || user.getUsername().length() > 32) {
           errors.rejectValue("username", "Size.user.username");
       }
       if (userService.findByUsername(user.getUsername()) != null) {
           errors.rejectValue("username", "Duplicate.user.username");
       }
       
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
       if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
           errors.rejectValue("password", "Size.user.password");
       }
       if (!user.getPasswordConfirm().equals(user.getPassword())) {
           errors.rejectValue("passwordConfirm", "Diff.user.passwordConfirm");
       }
    }
    
}
