package com.redhat.www.containercatalog.management.services;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * Created by ykoer on 4/11/17.
 */
public interface ContainerRepositoryService {

    JsonNode getContainerRepositoryList(Integer page, Integer pageEntries, String sortBy) throws IOException;

    JsonNode getContainerRepositoryById(String repositoryId);

    void saveContainerRepository(JsonNode containerRepository);
}
