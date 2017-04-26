package com.redhat.www.containercatalog.management.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.redhat.www.containercatalog.management.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ykoer on 3/27/17.
 */
@Controller
@RequestMapping("/form")
public class FormController {

    @Autowired
    private FormService formService;

    @RequestMapping(value = "/{type}", method = RequestMethod.GET)
    public @ResponseBody
    JsonNode getContainerData(@PathVariable("type") String type ) {
        return formService.getForm(type);
    }

}
