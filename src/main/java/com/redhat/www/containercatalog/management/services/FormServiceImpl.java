package com.redhat.www.containercatalog.management.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ykoer on 3/27/17.
 */
@Service("formService")
public class FormServiceImpl implements FormService {


    @Override
    public JsonNode getForm(String type) {

        try {
            InputStream is =  FormServiceImpl.class.getClassLoader().getResourceAsStream("formdata/containerProductForm.json");
            ObjectMapper mapper = new ObjectMapper();
            JsonNode formtemplate = mapper.readTree(is);
            return formtemplate;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
