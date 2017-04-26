package com.redhat.www.containercatalog.management.controllers;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.CharEncoding;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


@RestController
@RequestMapping(value = "")
public class VersionInfoController {

    private static final Log logger = LogFactory.getLog(VersionInfoController.class);

    @Autowired
    ServletContext context;

    /**
     * Reads and returns the Version.info file.
     *
     * @return The version info or a 404 error
     */
    @RequestMapping(
            produces = MediaType.TEXT_PLAIN_VALUE,
            method = RequestMethod.GET,
            value = "version.info")
    public ResponseEntity<String> getVersionInfo() throws IOException {
        String versionFile = "version.info";
        String notFound = "Could not find " + versionFile + ".";

        ResponseEntity<String> response;
        try {
            InputStream inputStream = new FileInputStream(context.getRealPath(versionFile));
            if (inputStream == null) {
                throw new FileNotFoundException(notFound);
            }
            String versionInfo = IOUtils.toString(inputStream, CharEncoding.UTF_8);
            response = ResponseEntity.ok().body(versionInfo);
        } catch (IOException exception) {
            logger.error(notFound);
            throw new IOException(notFound, exception);
        }
        return response;
    }
}
