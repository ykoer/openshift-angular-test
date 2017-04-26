package com.redhat.www.containercatalog.management.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.redhat.www.containercatalog.management.services.ContainerRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by ykoer on 3/28/17.
 */
@Controller
@RequestMapping("")
public class ContainerRepositoryController {

    private static final String DEFAULT_PAGE = "1";


    @Autowired
    private ContainerRepositoryService containerRepositoryService;

    /**
     *
     * @param page The current page
     * @param pageEntries Number of entries shown per page
     * @param sortBy Indicates the sort field name. The field name can be optionally prefixed by "-" to indicate descending sort
     * @return
     */
    @RequestMapping(value = "/repositories", method = RequestMethod.GET)
    public @ResponseBody
    JsonNode getContainerRepositoryList(
            @RequestParam(value = "page", defaultValue = DEFAULT_PAGE) Integer page,
            @RequestParam(value = "page_entries", required = false) Integer pageEntries,
            @RequestParam(value = "sort", required = false) String sortBy) throws IOException {
        return containerRepositoryService.getContainerRepositoryList(page, pageEntries, sortBy);
    }

    /**
     *
     * @param repositoryId The container repository id
     * @return
     */
    @RequestMapping(value = "/repository/{repositoryId}", method = RequestMethod.GET)
    public @ResponseBody
    JsonNode getContainerRepository(@PathVariable String repositoryId)throws IOException {
        return containerRepositoryService.getContainerRepositoryById(repositoryId);
    }
}
