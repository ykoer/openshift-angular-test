package com.redhat.www.containercatalog.management.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ykoer on 4/11/17.
 */
@Service
public class ContainerRepositoryServiceImpl implements ContainerRepositoryService {


    @Override
    public JsonNode getContainerRepositoryList(Integer page, Integer pageEntries, String sortBy) throws IOException {
        InputStream is =  FormServiceImpl.class.getClassLoader().getResourceAsStream("containerRepositories.json");

        ObjectMapper mapper = new ObjectMapper();
        JsonNode repositories = mapper.readTree(is);

        return repositories;
    }

    @Override
    public JsonNode getContainerRepositoryById(String productId) {
        return null;
    }

    @Override
    public void saveContainerRepository(JsonNode containerProduct) {

    }
}
