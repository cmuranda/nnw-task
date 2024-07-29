package nnw.task.validation;

import jakarta.validation.ConstraintValidatorContext;
import nnw.task.model.Address;
import nnw.task.model.Country;
import nnw.task.model.ProvinceOrState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class ZACountryValidatorTest {
    ConstraintValidatorContext mockContext = mock(ConstraintValidatorContext.class);
    ZACountryValidator validator = new ZACountryValidator();

    @Test
    void isValid_nullAddress() {
        assertTrue(validator.isValid(null, mockContext));
    }

    @Test
    void isValid_nullCountry(){
        var address = new Address();
        assertTrue(validator.isValid(address, mockContext));

        address.setCountry(new Country());
        assertTrue(validator.isValid(address, mockContext));
    }

    @Test
    void isValid_notZACountry(){
        var country = new Country();
        country.setName("Not ZA");
        country.setCode("^ZA");

        var address = new Address();
        address.setCountry(country);

        assertTrue(validator.isValid(address, mockContext));
    }

    @Test
    void isValid_ZA_NoProvince(){
        var country = new Country();
        country.setName("South Africa");
        country.setCode("ZA");

        var address = new Address();
        address.setCountry(country);

        assertFalse(validator.isValid(address, mockContext));
    }

    @Test
    void isValid_ZA_WithProvince(){
        var country = new Country();
        country.setName("ZA");
        country.setCode("ZA");

        ProvinceOrState provinceOrState = new ProvinceOrState();
        provinceOrState.setCode("WC");
        provinceOrState.setName("Western Cape");

        var address = new Address();
        address.setCountry(country);
        address.setProvinceOrState(provinceOrState);

        assertTrue(validator.isValid(address, mockContext));
    }
}