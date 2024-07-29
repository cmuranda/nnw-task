package nnw.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import nnw.task.model.Address;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        var jsonObjectPath = Objects.requireNonNull(classLoader.getResource("addresses.json")).getFile();
        Path jsonPath = Path.of(jsonObjectPath);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        Address[] address = mapper.readValue(jsonPath.toFile(), Address[].class);
        System.out.println(address[0]);
        System.out.println(jsonPath.toAbsolutePath());


//        File file = new File(Objects.requireNonNull(classLoader.getResource("addresses.json")).getFile());


    }
}