package com.redhat.www.containercatalog.management.services;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Created by ykoer on 3/27/17.
 */
public interface FormService {

    public JsonNode getForm(String type);
}
