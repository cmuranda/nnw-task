package nnw.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import nnw.task.model.Address;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AddressManagerTest {
    ObjectMapper mockMapper = mock(ObjectMapper.class);
    AddressPrinter mockPrinter = mock(AddressPrinter.class);

    AddressManager manager = new AddressManager(mockMapper, mockPrinter);

    @Test
    void extractAddresses() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        var jsonObjectPath = Objects.requireNonNull(classLoader.getResource("addresses.json")).getFile();
        File jsonPath = new File(jsonObjectPath);
        //when
        manager.extractAddresses();

        verify(mockMapper).readValue(jsonPath, Address[].class);
    }
}