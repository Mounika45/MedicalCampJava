/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.healthcamp.service;

import com.google.gson.JsonObject;

/**
 *
 * @author Andriod
 */
public interface LoginServiceLayer {
    
//    public String saveEyeSyncDetails(JsonObject jo);
//    
//    public String saveEyeRegistrationDetails(String jo);   
    
    public String getMRDetails(JsonObject jo);
    
    public String getCampDetails();
    
    public String getEyeSpecificDetails(JsonObject jo);
    
    public String saveEyeSpecificationDtls(JsonObject jo);
    
    public String savePatientDetails(JsonObject jo);
    
    public String saveGeneralQuestions(JsonObject jo);
    
    public String saveOutPatientDetails(JsonObject jo);

}
