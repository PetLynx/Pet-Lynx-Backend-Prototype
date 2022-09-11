package com.lynxiq.api.lynxiq.service.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class LynxiqServiceController {


    @GetMapping(value = "/pets")
    public JsonNode getPetsdata() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new ClassPathResource("pet-data.json").getFile();
        JsonNode node = objectMapper.readTree(jsonFile);
        return node;


    }
    @GetMapping(value = "/pets/{id}")
    public Object getPetsdata(@PathVariable String id) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new ClassPathResource("pet-data.json").getFile();
        Map obj = objectMapper.readValue(jsonFile, Map.class);
        List<Object> pets = (List<Object>) obj.get("pets");;
        Object[] filterPet = pets
                .stream()
                .filter(pet -> ((Map)pet).get("id").equals(id))
                .toArray();

        return filterPet[0];


        
    }
}
