package nnw.task.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import nnw.task.model.Address;
import nnw.task.model.AddressLineDetail;

public class AddressLineValidator implements ConstraintValidator<ValidAddressLine, Address> {
    @Override
    public boolean isValid(Address address, ConstraintValidatorContext constraintValidatorContext) {
        AddressLineDetail details = address.getAddressLineDetail();

        if (details == null){
            return false;
        }

        String line1 = details.getLine1();
        String line2 = details.getLine2();


        if(line1 != null && !line1.isBlank()){
            return true;
        }

        return line2 != null && !line2.isBlank();
    }
}
