package nnw.task.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import nnw.task.model.Address;
import nnw.task.model.Country;
import nnw.task.model.ProvinceOrState;

public class ZACountryValidator implements ConstraintValidator<ValidZACountry, Address> {
    @Override
    public boolean isValid(Address address, ConstraintValidatorContext constraintValidatorContext) {
        if(address == null){
            return true;
        }
        Country country = address.getCountry();
        ProvinceOrState provinceOrState = address.getProvinceOrState();

        if(country == null || country.getName() == null){
            return true;
        }

        if(!country.getCode().equals("ZA")){
            return true;
        }

        return provinceOrState != null;
    }
}
