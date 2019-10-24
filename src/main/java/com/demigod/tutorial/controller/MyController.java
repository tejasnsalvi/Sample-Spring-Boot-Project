package com.demigod.tutorial.controller;

import com.demigod.tutorial.exception.MyException;
import io.swagger.annotations.ApiParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.StandardLevel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

/**
 * @author TejasS
 */
@RestController
public class MyController {

    private static final Logger logger = LogManager.getLogger();

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public String test(@RequestParam(value = "id", defaultValue = "test", required = false) String id,
                       @ApiParam(allowableValues = "Option_1,Option_2", defaultValue = "Option_1") @RequestParam(value = "choose") String choose) {
        String resp = null;
        try {
            resp = "test";
        } catch (RestClientException ex) {
            logger.error("Exception in MyController.test.restclientError");
            throw (new MyException("MyController.test.restclientError", ex, StandardLevel.ERROR));
        }
        return resp;
    }
}
