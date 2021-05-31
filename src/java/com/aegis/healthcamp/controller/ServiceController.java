/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.healthcamp.controller;

import com.aegis.healthcamp.service.LoginServiceLayer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andriod
 */
@RestController
//@Controller
@RequestMapping("/")
public class ServiceController {
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LoginService
     */
    public ServiceController() {
        System.out.println("in Medcamp controller");
    }
    @Autowired
    private LoginServiceLayer loginServiceLayer;

    public LoginServiceLayer getLoginServiceLayer() {
        return loginServiceLayer;
    }

    public void setLoginServiceLayer(LoginServiceLayer loginServiceLayer) {
        this.loginServiceLayer = loginServiceLayer;
    }
    
    @RequestMapping(value = "/get.htm", method = RequestMethod.GET)
    public @ResponseBody
    String checkMenthod() {

        try {
            //dataServices.deleteEntity(id);
            return "in get!";
        } catch (Exception e) {
            return "in catch!";
        }
    }
    
//    @RequestMapping(value = "/saveEyeSyncDetails.htm", method = RequestMethod.POST, 
//        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody
//    String saveEyeSyncDetails(@RequestBody String jsonStr) {
//        String result = "";
//        JsonParser jsonParser = new JsonParser();
//        JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
//        result = loginServiceLayer.saveEyeSyncDetails(jo);
//        return result;
//    }   
//    
//    @RequestMapping(value = "/saveEyeRegistrationDetails.htm", method = RequestMethod.POST, 
//        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody
//    String saveEyeRegistrationDetails(@RequestBody String jsonStr) {
//        String result = "";
//        JsonParser jsonParser = new JsonParser();
//        JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
//        System.out.println("InController"+jo);
//        result = loginServiceLayer.saveEyeRegistrationDetails(jsonStr);
//        return result;
//    }     
    
    @RequestMapping(value = "/getMRDetails.htm", method = RequestMethod.POST, 
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getMRDetails(@RequestBody String jsonStr) {
        String result = "";
        JsonParser jsonParser = new JsonParser();
        JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
        System.out.println("InController"+jo);
        result = loginServiceLayer.getMRDetails(jo);
        return result;
    }
    
    @RequestMapping(value = "/getCampDetails.htm", method = RequestMethod.GET)
    public @ResponseBody
    String getCampDetails() {
        String result = "";
        result = loginServiceLayer.getCampDetails();
        return result;
    }
    
    @RequestMapping(value = "/getEyeSpecificDetails.htm", method = RequestMethod.POST, 
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getEyeSpecificDetails(@RequestBody String jsonStr) {
        String result = "";
        JsonParser jsonParser = new JsonParser();
        JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
        System.out.println("InController"+jo);
        result = loginServiceLayer.getEyeSpecificDetails(jo);
        return result;
    }
    
    @RequestMapping(value = "/saveEyeSpecificationDtls.htm", method = RequestMethod.POST, 
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String saveEyeSpecificationDtls(@RequestBody String jsonStr) {
        String result = "";
        JsonParser jsonParser = new JsonParser();
        JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
        System.out.println("InController"+jo);
        result = loginServiceLayer.saveEyeSpecificationDtls(jo);
        return result;
    }
    
    @RequestMapping(value = "/savePatientDetails.htm", method = RequestMethod.POST, 
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String savePatientDetails(@RequestBody String jsonStr) {
        String result = "";
        JsonParser jsonParser = new JsonParser();
        JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
        System.out.println("InController"+jo);
        result = loginServiceLayer.savePatientDetails(jo);
        return result;
    }
    
    @RequestMapping(value = "/saveGeneralQuestions.htm", method = RequestMethod.POST, 
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String saveGeneralQuestions(@RequestBody String jsonStr) {
        String result = "";
        JsonParser jsonParser = new JsonParser();
        JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
        System.out.println("InController"+jo);
        result = loginServiceLayer.saveGeneralQuestions(jo);
        return result;
    }
    
    @RequestMapping(value = "/saveOutPatientDetails.htm", method = RequestMethod.POST, 
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String saveOutPatientDetails(@RequestBody String jsonStr) {
        String result = "";
        JsonParser jsonParser = new JsonParser();
        JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
        System.out.println("InController"+jo);
        result = loginServiceLayer.saveOutPatientDetails(jo);
        return result;
    }
}
