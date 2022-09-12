package com.lynxiq.api.lynxiq.service.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/lynx")
public class LynxiqServiceController {

	@Autowired
	ResourceLoader resourceLoader;
	@GetMapping(value = "/ping")
	 public String pingData()
	 {
		
		return "ping";
	 }
	
	@GetMapping(value = "/pets")
    public JsonNode getPetsdata() throws IOException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();
//        URL resource = getClass().getClassLoader().getResource("pet-data.json");
//        File jsonFile = new File(resource.toURI());
		
		
		
		File jsonFile		= new File("src/pet-data.json");
        JsonNode node = objectMapper.readTree(jsonFile);
        
        
     
        
        return node;
       

    }
	@GetMapping(value = "/pets/{id}")
    public Object getPetsdata(@PathVariable String id) throws IOException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();
        //URL resource = getClass().getClassLoader().getResource("pet-data.json");
        File jsonFile		= new File("src/pet-data.json");
        Map obj = objectMapper.readValue(jsonFile, Map.class);
        List<Object> pets = (List<Object>) obj.get("pets");;
        Object[] filterPet = pets
                .stream()
                .filter(pet -> ((Map)pet).get("id").equals(id))
                .toArray();

        return filterPet[0];


        
    }
}
