package com.redhat.www.containercatalog.management.controllers;

import com.redhat.www.containercatalog.management.errors.EntityNotFoundException;
import com.redhat.www.containercatalog.management.errors.ErrorInfo;
import com.redhat.www.containercatalog.management.errors.JsonFormatException;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorController {

    private static final Log log = LogFactory.getLog(ErrorController.class);

    /**
     * All exceptions get a basic error handler.
     *
     * @param req
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    ErrorInfo handleBadRequest(HttpServletRequest req, Exception ex) {
        return createErrorInfo(req, ex, "Sorry we are unable to process your request.");
    }

    /**
     * JsonFormateException Handler
     *
     * @param req
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(JsonFormatException.class)
    @ResponseBody
    ErrorInfo handleJsonFormatException(HttpServletRequest req, JsonFormatException ex) {
        return createErrorInfo(req, ex, "An error occurred while formatting the json response.");
    }

    /**
     * EntityNotFoundException Handler
     * @param req
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    ErrorInfo handleEntityNotFoundException(HttpServletRequest req, EntityNotFoundException ex) {
        ErrorInfo errorInfo = createErrorInfo(req, ex, "The thing you are searching for does not exists.");
        errorInfo.setExceptionDetails(null); //No need to return exception details.
        return errorInfo;
    }

    private ErrorInfo createErrorInfo(HttpServletRequest req, Exception ex, String serverMessage) {
        String url = new String(req.getRequestURL());
        log.error("An error occurred for request: " + url, ex);

        ErrorInfo info = new ErrorInfo();
        info.setUrl(url);
        info.setServerMessage(serverMessage);
        info.setExceptionMessage(ex.getMessage());
        info.setExceptionDetails(ExceptionUtils.getStackTrace(ex));
        return info;
    }

}
