package nnw.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import nnw.task.model.Address;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

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
        String jsonObjectPath = Objects.requireNonNull(classLoader.getResource(ADDRESS_FILE_PATH)).getFile();
        File jsonPath = new File(jsonObjectPath);
        addresses = mapper.readValue(jsonPath, Address[].class);
    }

    public void printAllAddresses(){
        Arrays.stream(addresses)
                .map(this::prettyPrintAddress)
                .forEach(System.out::println);
    }

    public void printAddressOfType(String type){
        Arrays.stream(addresses)
                .filter(address -> address.getType().getName().equals(type))
                .map(this::prettyPrintAddress)
                .forEach(System.out::println);
    }

    public void validateAllAddresses(){
        try(ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {

            Validator validator = validatorFactory.getValidator();

            for (var address : addresses) {
                Set<ConstraintViolation<Address>> violations = validator.validate(address);
                displayViolations(address, violations);
            }

        }
    }

    public void displayViolations(Address address, Set<ConstraintViolation<Address>> violations){
        String header = """
                -------------------------------------
                Address Id : %s
                Is Valid : %s
                -------------------------------------
                """.formatted(address.getId(), violations.isEmpty() ? "TRUE" : "FALSE");

        StringBuilder message = new StringBuilder(header);

        if (!violations.isEmpty()){
            message.append(" Reasons \n")
                    .append("-------------------------------------\n");
        }
        for(var violation: violations) {
            message.append(violation.getMessage())
                    .append("\n");
        }
        message.append("\n");
        System.out.println(message);
    }

    public String prettyPrintAddress(Address address){
        return addressPrinter.print(address);
    }
}
