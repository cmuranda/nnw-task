package nnw.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Question 1
        HighestCommonFactor highestCommonFactor = new HighestCommonFactor();
        highestCommonFactor.highestCommonFactor(new int[]{1, 43, 56});

        //Question 2
        AddressPrinter printer = new PrettyPrint();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        AddressManager addressManager = new AddressManager(mapper, printer);
        addressManager.extractAddresses();

        //2b
        System.out.println("\n *** Question 2B ***");
        addressManager.printAllAddresses();

        //2c
        System.out.println("\n*** Question 2C ***");
        addressManager.printAddressOfType("Physical Address");

        //2d
        /*
            I used annotations in the Address.java file and added class level validations in the nnw.task.validation package
        */

        //2e
        addressManager.validateAllAddresses();
    }
}