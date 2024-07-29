package nnw.task.validation;

import jakarta.validation.ConstraintValidatorContext;
import nnw.task.model.Address;
import nnw.task.model.AddressLineDetail;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AddressLineValidatorTest {
    ConstraintValidatorContext mockContext = mock(ConstraintValidatorContext.class);
    AddressLineValidator validator = new AddressLineValidator();

    @Test
    void isValid_nullDetails() {
        assertFalse(validator.isValid(new Address(), mockContext));
    }

    @Test
    void isValid_notNullNotBlankLine1(){
        var details = new AddressLineDetail();
        details.setLine1("Sample line 1");

        var address = new Address();
        address.setAddressLineDetail(details);
        assertTrue(validator.isValid(address, mockContext));
    }

    @Test
    void isValid_notNullNotBlankLine2(){
        var details = new AddressLineDetail();
        details.setLine2("Sample line 2");

        var address = new Address();
        address.setAddressLineDetail(details);
        assertTrue(validator.isValid(address, mockContext));
    }

    @Test
    void isValid_Line1Line2BothNull(){
        var details = new AddressLineDetail();

        var address = new Address();
        address.setAddressLineDetail(details);
        assertFalse(validator.isValid(address, mockContext));
    }
}