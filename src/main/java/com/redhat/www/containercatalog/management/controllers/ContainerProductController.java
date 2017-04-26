package com.redhat.www.containercatalog.management.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.redhat.www.containercatalog.management.services.ContainerProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by ykoer on 3/28/17.
 */
@Controller
@RequestMapping("")
public class ContainerProductController {

    private static final String DEFAULT_PAGE = "1";


    @Autowired
    private ContainerProductService containerProductService;

    /**
     *
     * @param page The current page
     * @param pageEntries Number of entries shown per page
     * @param sortBy Indicates the sort field name. The field name can be optionally prefixed by "-" to indicate descending sort
     * @return
     */
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public @ResponseBody
    JsonNode getContainerProductList(
            @RequestParam(value = "page", defaultValue = DEFAULT_PAGE) Integer page,
            @RequestParam(value = "page_entries", required = false) Integer pageEntries,
            @RequestParam(value = "sort", required = false) String sortBy) throws IOException {
        return containerProductService.getContainerProductList(page, pageEntries, sortBy);
    }

    /**
     *
     * @param productId The container product id
     * @return
     */
    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public @ResponseBody
    JsonNode getContainerProduct(@PathVariable String productId)throws IOException {
        return containerProductService.getContainerProductById(productId);
    }
}
