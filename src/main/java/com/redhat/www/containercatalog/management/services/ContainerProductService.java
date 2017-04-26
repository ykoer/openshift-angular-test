package com.redhat.www.containercatalog.management.services;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * Created by ykoer on 3/28/17.
 */
public interface ContainerProductService {

    JsonNode getContainerProductList(Integer page, Integer pageEntries, String sortBy) throws IOException;

    JsonNode getContainerProductById(String productId);

    void saveContainerProduct(JsonNode containerProduct);
}
