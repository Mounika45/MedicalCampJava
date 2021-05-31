/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.healthcamp.service;

import com.aegis.healthcamp.dao.LoginDao;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andriod
 */
@Service("loginServiceLayer")
public class LoginServiceImpl implements LoginServiceLayer {

    @Autowired
    private LoginDao loginDao;

    public LoginDao getLoginDao() {
        return loginDao;
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

//    @Override
//    public String saveEyeSyncDetails(JsonObject jo) {
//        return loginDao.saveEyeSyncDetails(jo);
//    }
//
//    @Override
//    public String saveEyeRegistrationDetails(String jo) {
//        return loginDao.saveEyeRegistrationDetails(jo);
//    }

    @Override
    public String getMRDetails(JsonObject jo) {
       return loginDao.getMRDetails(jo);
    }

    @Override
    public String getCampDetails() {
       return loginDao.getCampDetails();
    }

    @Override
    public String getEyeSpecificDetails(JsonObject jo) {
        return loginDao.getEyeSpecificDetails(jo);
    }

    @Override
    public String saveEyeSpecificationDtls(JsonObject jo) {
        return loginDao.saveEyeSpecificationDtls(jo);
    }

    @Override
    public String savePatientDetails(JsonObject jo) {
        return loginDao.savePatientDetails(jo);
    }
    
    @Override
    public String saveGeneralQuestions(JsonObject jo) {
        return loginDao.saveGeneralQuestions(jo);
    }

    @Override
    public String saveOutPatientDetails(JsonObject jo) {
        return loginDao.saveOutPatientDetails(jo);
    }
}
