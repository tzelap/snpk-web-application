package com.snpk.webapplication.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.snpk.webapplication.validation.constraints.ValidateStringEnum;


public class StringEnumValidator implements ConstraintValidator<ValidateStringEnum, String>{
    
    private Set<String> allowedEnumValues; 
    
    public static Set<String> getEnumValueSet(Class<? extends Enum<?>> e){
        Enum<?>[] enums = e.getEnumConstants();
        String[] enumValStrings = new String[enums.length];
        for(int i = 0; i < enums.length; i++) {
            enumValStrings[i] = enums[i].name();
        }
        Set<String> enumValueSet = new HashSet<String>(Arrays.asList(enumValStrings)); 
        return enumValueSet;
    }
    
    @Override
    public void initialize(ValidateStringEnum constraintAnnotation) {
        Class<? extends Enum<?>> enumSelected = constraintAnnotation.enumClass();
        allowedEnumValues = getEnumValueSet(enumSelected);
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null) {
            return true;
        } else {
            return allowedEnumValues.contains(value.toUpperCase());
        }
    }

}
