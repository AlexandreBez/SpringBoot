package basico.springboot.validation.constraintValidator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import basico.springboot.validation.NotEmptyList;


public class NotEmptyListValidator implements ConstraintValidator<NotEmptyList, List>{

    @Override
    public void initialize(NotEmptyList constraintAnnotation){

    }

    @Override
    public boolean isValid(List list, ConstraintValidatorContext constraintValidatorContext) {
        
        
        return list != null && !list.isEmpty();
    }
    
}