package nnw.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import nnw.task.model.Address;
import nnw.task.model.AddressLineDetail;
import nnw.task.model.Country;
import nnw.task.model.ProvinceOrState;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;

public class AddressManager {
    private static final String ADDRESS_FILE_PATH = "addresses.json";
    private final ObjectMapper mapper;
    private final AddressPrinter addressPrinter;
    private Address[] addresses;

    public AddressManager(ObjectMapper mapper, AddressPrinter printer){
        this.mapper = mapper;
        this.addressPrinter = printer;
    }

    public void extractAddresses() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        var jsonObjectPath = Objects.requireNonNull(classLoader.getResource(ADDRESS_FILE_PATH)).getFile();
        Path jsonPath = Path.of(jsonObjectPath);
        addresses = mapper.readValue(jsonPath.toFile(), Address[].class);
    }

    public String prettyPrintAddress(Address address){
        return addressPrinter.print(address);
    }
}
