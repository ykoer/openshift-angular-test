package com.redhat.www.containercatalog.management.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ykoer on 3/28/17.
 */
@Service
public class ContainerProductServiceImpl implements ContainerProductService {

    @Override
    public JsonNode getContainerProductList(Integer page, Integer pageEntries, String sortBy) throws IOException {

        InputStream is =  FormServiceImpl.class.getClassLoader().getResourceAsStream("containerProducts.json");

        ObjectMapper mapper = new ObjectMapper();
        JsonNode products = mapper.readTree(is);

        return products;
    }

    @Override
    public JsonNode getContainerProductById(String productId) {
        return null;
    }

    @Override
    public void saveContainerProduct(JsonNode containerProduct) {

    }
}
