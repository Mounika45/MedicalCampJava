/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.healthcamp.dao;

import com.aegis.healthcamp.commons.HibernateDao;
import com.aegis.healthcamp.entities.MPatient;
import com.aegis.healthcamp.entities.TCasesheet;
import com.aegis.healthcamp.entities.TEyespecification;
import com.aegis.healthcamp.entities.TPatienthistory;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andriod
 */
@Repository("loginDao")
@Transactional
public class LoginDaoImpl extends HibernateDao implements LoginDao {

    @Autowired
    public SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public LoginDaoImpl() {
        System.out.println("on DaoImpl");
    }

    @Override
    public String getMRDetails(JsonObject jo) {
        Session session = null;
        String result = null;
        JsonArray jsa = new JsonArray();

        try {
            session = getSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery("select mp.id,mp.CampId, mp.FirstName,mp.LastName,mp.AdharNum,mp.MRNum,mp.Occupation,mp.Gender,\n"
                    + "mp.Age,mp.EmailId,mp.Address from m_patient mp join t_patienthistory tph on tph.PatientId=mp.Id\n"
                    + "where TreatmentLevelId=1 and MRNum= '" + jo.get("mr_no").getAsString() + "'");
            List list = query.list();

            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    JsonObject jso = new JsonObject();
                    Object[] os = (Object[]) list.get(i);

                    jso.addProperty("patient_id", "" + os[0]);
                    jso.addProperty("camp_id", "" + os[1]);
                    jso.addProperty("FirstName", "" + os[2]);
                    jso.addProperty("SurName", "");
                    jso.addProperty("AadhaarId", "" + os[5]);
                    jso.addProperty("uid", "" + os[6]);
                    jso.addProperty("DesignationID", "" + os[7]);
                    jso.addProperty("Gender", "" + os[8]);
                    jso.addProperty("Age", "" + os[9]);
                    jso.addProperty("EmailId", "" + os[10]);
                    jso.addProperty("MobileNo", "" + os[11]);
                    jso.addProperty("Address", "" + os[12]);

//                    jso.addProperty("VisionProblem", "" + os[12]);
//                    jso.addProperty("WearSpects", "" + os[13]);
//                    jso.addProperty("Diabetic", "" + os[14]);
//                    jso.addProperty("BloodPleasure", "" + os[15]);
//                    jso.addProperty("RegurarlyEyeChecked", "" + os[16]);
//                    jso.addProperty("RegDate", "" + os[17]);
//                    jso.addProperty("campPlace", "" + os[18]);
//                    jso.addProperty("ReferredDocs", "" + os[19]);
//                    jso.addProperty("Remarks", "" + os[20]);
                    jsa.add(jso);
                }
                result = "{\"status\":\"Success\",\"response\":" + jsa + "}";
            } else {
                result = "{\"status\":\"Failed\",\"response\":\"MR number not available\"}";
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Sync failed\",\"exception\":" + e + "}";
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public String getCampDetails() {
        Session session = null;
        String result = null;
        JsonArray jsa = new JsonArray();

        try {
            session = getSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery("select * from m_camp");
            List list = query.list();

            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    JsonObject jso = new JsonObject();
                    Object[] os = (Object[]) list.get(i);

                    jso.addProperty("Id", "" + os[0]);
                    jso.addProperty("CampName", "" + os[1]);

                    jsa.add(jso);
                }
                result = "{\"status\":\"Success\",\"response\":" + jsa + "}";
            } else {
                result = "{\"status\":\"Success\",\"response\":\"Camp details not available\"}";
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Sync failed\",\"exception\":" + e + "}";
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public String getEyeSpecificDetails(JsonObject jo) {
        Session session = null;
        String result = null;
        JsonArray jsa = new JsonArray();
        try {
            session = getSessionFactory().openSession();
//            SQLQuery query = session.createSQLQuery("select eye.PatientId, eye.CampId, eye.REDVSPH, eye.REDVCYL, eye.REDVAxis, eye.REDVVA, eye.RENVSPH, eye.RENVCYL, eye.RENVAxis,eye.RENVVA,\n"
//                    + "eye.LEDVSPH, eye.LEDVCYL, eye.LEDVAxis, eye.LEDVVA, eye.LENVSPH, eye.LENVCYL, eye.LENVAxis, eye.LENVVA,eye.NeedOpticals, eye.Remarks,\n"
//                    + "pat.FirstName, pat.LastName, pat.AdharNum, pat.MobileNum from t_eyespecification eye inner join m_patient pat on pat.Id = eye.PatientId where pat.MRNum= '" + jo.get("mr_no").getAsString() + "'");

            SQLQuery query = session.createSQLQuery("execute GetEyeSpecificDetailsbyMRNum :param1, :param2");
            query.setString("param1", jo.get("mr_no").getAsString());
            query.setInteger("param2", jo.get("camp_id").getAsInt());

            List list = query.list();

            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    JsonObject jso = new JsonObject();
                    Object[] os = (Object[]) list.get(i);

                    jso.addProperty("patient_id", "" + os[0]);
                    jso.addProperty("camp_id", "" + os[1]);
                    jso.addProperty("REDV_Sph", "" + os[2]);
                    jso.addProperty("REDV_Cyl", "" + os[3]);
                    jso.addProperty("REDV_Axis", "" + os[4]);
                    jso.addProperty("ReDV_Va", "" + os[5]);
                    jso.addProperty("RENV_Sph", "" + os[6]);
                    jso.addProperty("RENV_Cyl", "" + os[7]);
                    jso.addProperty("RENV_Axis", "" + os[8]);
                    jso.addProperty("ReNV_Va", "" + os[9]);
                    jso.addProperty("LEDV_Sph", "" + os[10]);
                    jso.addProperty("LEDV_Cyl", "" + os[1]);
                    jso.addProperty("LEDV_Axis", "" + os[12]);
                    jso.addProperty("LeDV_Va", "" + os[13]);
                    jso.addProperty("LENV_Sph", "" + os[14]);
                    jso.addProperty("LENV_Cyl", "" + os[15]);
                    jso.addProperty("LENV_Axis", "" + os[16]);
                    jso.addProperty("LENV_Va", "" + os[17]);
                    jso.addProperty("need_opticals", "" + os[18]);
                    jso.addProperty("remarks", "" + os[19]);

                    jso.addProperty("name", "" + os[20] + "" + os[21]);
                    jso.addProperty("aadhaar_id", "" + os[22]);
                    jso.addProperty("mobile_no", "" + os[23]);

                    SQLQuery q = session.createSQLQuery("select * from t_patienthistory where PatientId = " + os[0] + " and CampId = " + os[1] + " and TreatmentLevelId=1");

                    List l = q.list();
                    System.out.println("l" + l.toString());
                    String status = null;

                    if (l.size() > 0) {
                        for (int j = 0; j < l.size(); j++) {
                            Object[] o = (Object[]) l.get(j);
                            int statusid = (int) o[3];

                            System.out.println("statusid" + statusid);
                            if (statusid == 2) {
                                status = "Normal";
                            }
                            if (statusid == 3) {
                                status = "Referred to Hospital";
                            }
                        }
                        jso.addProperty("status", status);
                    } else {
//                        result = "{\"status\":\"Failed\",\"statusMessage\":\"Details not available\"}"; 
//                        return result;
                        jso.addProperty("status", "null");
                    }
                    jsa.add(jso);
                }
                result = "{\"status\":\"Success\",\"response\":" + jsa + "}";
            } else {

                SQLQuery q = session.createSQLQuery("select Id, CampId,FirstName, LastName, AdharNum, MobileNum from m_patient "
                        + "where MRNum = '" + jo.get("mr_no").getAsString() + "' and CampId= '" + jo.get("camp_id").getAsInt() + "'");

                List li = q.list();

                if (li.size() > 0) {
                    for (int i = 0; i < li.size(); i++) {
                        JsonObject jso = new JsonObject();
                        Object[] os = (Object[]) li.get(i);

                        jso.addProperty("patient_id", "" + os[0]);
                        jso.addProperty("camp_id", "" + os[1]);
                        jso.addProperty("REDV_Sph", "");
                        jso.addProperty("REDV_Cyl", "");
                        jso.addProperty("REDV_Axis", "");
                        jso.addProperty("ReDV_Va", "");
                        jso.addProperty("RENV_Sph", "");
                        jso.addProperty("RENV_Cyl", "");
                        jso.addProperty("RENV_Axis", "");
                        jso.addProperty("ReNV_Va", "");
                        jso.addProperty("LEDV_Sph", "");
                        jso.addProperty("LEDV_Cyl", "");
                        jso.addProperty("LEDV_Axis", "");
                        jso.addProperty("LeDV_Va", "");
                        jso.addProperty("LENV_Sph", "");
                        jso.addProperty("LENV_Cyl", "");
                        jso.addProperty("LENV_Axis", "");
                        jso.addProperty("LENV_Va", "");
                        jso.addProperty("need_opticals", "");
                        jso.addProperty("remarks", "");

                        jso.addProperty("name", "" + os[2] + "" + os[3]);
                        jso.addProperty("aadhaar_id", "" + os[4]);
                        jso.addProperty("mobile_no", "" + os[5]);

                        jso.addProperty("status", "");

                        jsa.add(jso);

                        result = "{\"status\":\"Success\",\"response\":" + jsa + "}";
                    }
                } else {
                    result = "{\"status\":\"Failed\",\"statusMessage\":\"Details not available\"}";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Sync failed\",\"exception\":" + e + "}";
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public String saveEyeSpecificationDtls(JsonObject eye_camp_object) {
        Session session = null;
        String result = null;
        int eye_spec_id = 0;

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            session = getSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery("execute UpdateEyeSpecificDtls :param1, :param2, :param3, :param4, :param5,"
                    + ":param6, :param7, :param8, :param9, :param10, :param11, :param12, :param13, :param14, :param15, :param16,"
                    + " :param17, :param18, :param19, :param20");

            query.setString("param1", eye_camp_object.get("REDV_Sph").getAsString());
            query.setString("param2", eye_camp_object.get("REDV_Cyl").getAsString());
            query.setString("param3", eye_camp_object.get("REDV_Axis").getAsString());
            query.setString("param4", eye_camp_object.get("ReDV_Va").getAsString());
            query.setString("param5", eye_camp_object.get("RENV_Sph").getAsString());
            query.setString("param6", eye_camp_object.get("RENV_Cyl").getAsString());
            query.setString("param7", eye_camp_object.get("RENV_Axis").getAsString());
            query.setString("param8", eye_camp_object.get("ReNV_Va").getAsString());
            query.setString("param9", eye_camp_object.get("LEDV_Sph").getAsString());
            query.setString("param10", eye_camp_object.get("LEDV_Cyl").getAsString());
            query.setString("param11", eye_camp_object.get("LEDV_Axis").getAsString());
            query.setString("param12", eye_camp_object.get("LeDV_Va").getAsString());
            query.setString("param13", eye_camp_object.get("LENV_Sph").getAsString());
            query.setString("param14", eye_camp_object.get("LENV_Cyl").getAsString());
            query.setString("param15", eye_camp_object.get("LENV_Axis").getAsString());
            query.setString("param16", eye_camp_object.get("LENV_Va").getAsString());
            query.setString("param17", eye_camp_object.get("need_opticals").getAsString());

            query.setInteger("param18", eye_camp_object.get("patient_id").getAsInt());
            query.setInteger("param19", eye_camp_object.get("camp_id").getAsInt());
            System.out.println("status" + eye_camp_object.get("status").getAsString());
            if (eye_camp_object.get("status").getAsString().equalsIgnoreCase("Normal")) {
                query.setInteger("param20", 2);
            }
            if (eye_camp_object.get("status").getAsString().equalsIgnoreCase("Referring to Hospital")) {
                query.setInteger("param20", 3);
            }

            List list = query.list();

            for (int i = 0; i < list.size(); i++) {
                eye_spec_id = (Integer) list.get(0);
            }

            TPatienthistory pat_his = new TPatienthistory();

            pat_his.setPatientId(eye_camp_object.get("patient_id").getAsInt());
            pat_his.setCampId(eye_camp_object.get("camp_id").getAsInt());
            pat_his.setStatusId(1);
            pat_his.setCreatedOn(date);
            pat_his.setTreatmentLevelId(0);

            session.save(pat_his);
            result = "{\"status\":\"Success\",\"eye_spec_id\":\"" + eye_spec_id + "\"}";

        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Sync failed\",\"exception\":" + e + "}";
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public String savePatientDetails(JsonObject jo) {
        String result = "";
        Session session = null;
        Date date = new Date();
        int regid, eye_gen;

        JsonObject registrationobject = jo.get("registrationobject").getAsJsonObject();
        JsonObject generalQuestions = jo.get("generalQuestions").getAsJsonObject();

        try {
            session = getSessionFactory().openSession();

            SQLQuery query = session.createSQLQuery("select * from m_patient where CampId=" + registrationobject.get("camp_id").getAsInt() + " "
                    + "and AdharNum='" + registrationobject.get("AadhaarId").getAsString() + "' and MobileNum= '" + registrationobject.get("MobileNo").getAsString() + "';");

            List list = query.list();

            if (list.size() > 0) {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"Data Already Available\"}";
            } else {
                MPatient mregistration = new MPatient();

                if (registrationobject.get("camp_id") != null) {
                    mregistration.setCampId(registrationobject.get("camp_id").getAsInt());
                }
                if (registrationobject.get("name") != null) {
                    mregistration.setFirstName(registrationobject.get("name").getAsString());
                }
                if (registrationobject.get("UID") != null) {
                    mregistration.setMRNum(registrationobject.get("UID").getAsString());
                }
                if (registrationobject.get("DesignationID") != null) {
                    mregistration.setOccupation(registrationobject.get("DesignationID").getAsString());
                }
                if (registrationobject.get("Gender") != null) {
                    mregistration.setGender(registrationobject.get("Gender").getAsString());
                }
                if (registrationobject.get("Age") != null) {
                    mregistration.setAge(registrationobject.get("Age").getAsInt());
                }
                if (registrationobject.get("EmailId") != null) {
                    mregistration.setEmailId(registrationobject.get("EmailId").getAsString());
                }
                if (registrationobject.get("MobileNo") != null) {
                    mregistration.setMobileNum(registrationobject.get("MobileNo").getAsString());
                }
                if (registrationobject.get("AadhaarId") != null) {
                    mregistration.setAdharNum(registrationobject.get("AadhaarId").getAsString());
                }
                if (registrationobject.get("AadhaarId") != null) {
                    mregistration.setAdharNum(registrationobject.get("AadhaarId").getAsString());
                }
                if (registrationobject.get("Address") != null) {
                    mregistration.setAddress(registrationobject.get("Address").getAsString());
                }
                mregistration.setCreatedOn(date);

                regid = (int) session.save(mregistration);

                TEyespecification generalQues = new TEyespecification();

                generalQues.setPatientId(regid);
                if (registrationobject.get("camp_id") != null) {
                    generalQues.setCampId(registrationobject.get("camp_id").getAsInt());
                }
                if (generalQuestions.get("VisionProblem") != null) {
                    generalQues.setHasVisionProblem(generalQuestions.get("VisionProblem").getAsString());
                }
                if (generalQuestions.get("WearSpects") != null) {
                    generalQues.setHasSpectacles(generalQuestions.get("WearSpects").getAsString());
                }
                if (generalQuestions.get("Diabetic") != null) {
                    generalQues.setHasDiabetes(generalQuestions.get("Diabetic").getAsString());
                }
                if (generalQuestions.get("BloodPleasure") != null) {
                    generalQues.setHasBP(generalQuestions.get("BloodPleasure").getAsString());
                }
                if (generalQuestions.get("RegurarlyEyeChecked") != null) {
                    generalQues.setWhereDoYouCheckEyes(generalQuestions.get("RegurarlyEyeChecked").getAsString());
                }
                generalQues.setCreatedOn(date);

                eye_gen = (int) session.save(generalQues);

                SQLQuery q = session.createSQLQuery("execute UpdatePatientCount :param1");
                q.setInteger("param1", registrationobject.get("camp_id").getAsInt());

                result = "{\"status\":\"Success\",\"statusMessage\":\"Data inserted Successfully\",\"regid\":\"" + regid + "\",\"eye_gen\":\"" + eye_gen + "\"}";
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Sync failed\"}";
        }
        return result;
    }

    @Override
    public String saveGeneralQuestions(JsonObject generalQuestions) {
        String result = "";
        Session session = null;
        Date date = new Date();
        int regid, eye_gen;

        try {
            session = getSessionFactory().openSession();

            TEyespecification generalQues = new TEyespecification();

            if (generalQuestions.get("patient_id") != null) {
                generalQues.setPatientId(generalQuestions.get("patient_id").getAsInt());
            }
            if (generalQuestions.get("camp_id") != null) {
                generalQues.setCampId(generalQuestions.get("camp_id").getAsInt());
            }
            if (generalQuestions.get("VisionProblem") != null) {
                generalQues.setHasVisionProblem(generalQuestions.get("VisionProblem").getAsString());
            }
            if (generalQuestions.get("WearSpects") != null) {
                generalQues.setHasSpectacles(generalQuestions.get("WearSpects").getAsString());
            }
            if (generalQuestions.get("Diabetic") != null) {
                generalQues.setHasDiabetes(generalQuestions.get("Diabetic").getAsString());
            }
            if (generalQuestions.get("BloodPleasure") != null) {
                generalQues.setHasBP(generalQuestions.get("BloodPleasure").getAsString());
            }
            if (generalQuestions.get("RegurarlyEyeChecked") != null) {
                generalQues.setWhereDoYouCheckEyes(generalQuestions.get("RegurarlyEyeChecked").getAsString());
            }
            generalQues.setCreatedOn(date);

            eye_gen = (int) session.save(generalQues);

            result = "{\"status\":\"Success\",\"eye_gen\":\"" + eye_gen + "\"}";
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Sync failed\"}";
        }
        return result;
    }

    @Override
    public String saveOutPatientDetails(JsonObject jo) {
        Session session = null;
        String result = null;
        int casesheet_id, patient_id;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            session = getSessionFactory().openSession();

            TCasesheet case_sheet = new TCasesheet();

            if (jo.get("patient_id") != null) {
                case_sheet.setPatientId(jo.get("patient_id").getAsInt());
            }
            if (jo.get("camp_id") != null) {
                case_sheet.setCampId(jo.get("camp_id").getAsInt());
            }
            if (jo.get("complaints") != null) {
                case_sheet.setComplaints(jo.get("complaints").getAsString());
            }
            if (jo.get("VnWithoutGlassesRE") != null) {
                case_sheet.setVnWithoutGlassesRE(jo.get("VnWithoutGlassesRE").getAsString());
            }
            if (jo.get("VnWithoutGlassesLE") != null) {
                case_sheet.setVnWithoutGlassesLE(jo.get("VnWithoutGlassesLE").getAsString());
            }
            if (jo.get("VnWithOldGlassesRE") != null) {
                case_sheet.setVnWithOldGlassesRE(jo.get("VnWithOldGlassesRE").getAsString());
            }
            if (jo.get("VnWithOldGlassesLE") != null) {
                case_sheet.setVnWithOldGlassesLE(jo.get("VnWithOldGlassesLE").getAsString());
            }
            if (jo.get("VnWithNewGlassesRE") != null) {
                case_sheet.setVnWithNewGlassesRE(jo.get("VnWithNewGlassesRE").getAsString());
            }
            if (jo.get("VnWithNewGlassesLE") != null) {
                case_sheet.setVnWithNewGlassesLE(jo.get("VnWithNewGlassesLE").getAsString());
            }
            if (jo.get("AnteriorSegmentRE") != null) {
                case_sheet.setAnteriorSegmentRE(jo.get("AnteriorSegmentRE").getAsString());
            }
            if (jo.get("AnteriorSegmentLE") != null) {
                case_sheet.setAnteriorSegmentLE(jo.get("AnteriorSegmentLE").getAsString());
            }
            if (jo.get("treatment") != null) {
                case_sheet.setTreatment(jo.get("treatment").getAsString());
            }
            case_sheet.setCreatedOn(new Date());

            casesheet_id = (int) session.save(case_sheet);

            TPatienthistory patient_history = new TPatienthistory();

            if (jo.get("camp_id") != null) {
                patient_history.setCampId(jo.get("camp_id").getAsInt());
            }
            if (jo.get("patient_id") != null) {
                patient_history.setPatientId(jo.get("patient_id").getAsInt());
            }
            if (jo.get("status") != null) {

                if (jo.get("status").getAsString().equalsIgnoreCase("Need Surgery")) {
                    patient_history.setStatusId(5);
                    patient_history.setHasFollowup(true);
                }
                if (jo.get("status").getAsString().equalsIgnoreCase("Need Examination")) {
                    patient_history.setStatusId(4);
                    patient_history.setHasFollowup(true);
                }
            }
            patient_history.setTreatmentLevelId(2);
            if (jo.get("followup_date") != null) {
                patient_history.setFollowupDate(dateFormat.parse(jo.get("followup_date").getAsString()));
            }
            patient_history.setCreatedOn(new Date());

            patient_id = (int) session.save(patient_history);

            result = "{\"status\":\"Success\",\"casesheet_id\":\"" + casesheet_id + "\",\"patient_id\":\"" + patient_id + "\"}";

        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Sync failed\",\"exception\":" + e + "}";
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

//    @Override
//    public String saveEyeSyncDetails(JsonObject jo) {
//        String result = "";
//        Session session = null;
//        Date date = new Date();
//        int regid, uploadid = 0, eyecampid, eyecounsid;
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        java.util.Date utilDate = new java.util.Date();
//        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//        System.out.println("dateFormat" + dateFormat.toString());
//        byte[] bytes = null;
//        String image = null;
//
//        JsonObject registrationobject = jo.get("registrationobject").getAsJsonObject();
//        JsonObject imageobject = jo.get("imageobject").getAsJsonObject();
//        JsonObject eye_camp_object = jo.get("eye_camp_object").getAsJsonObject();
//        JsonObject eye_counselling_obj = jo.get("eye_counselling_obj").getAsJsonObject();
//
//        try {
//            session = getSessionFactory().openSession();
//
//            MRegistration mregistration = new MRegistration();
//            if (registrationobject.get("SurName") != null) {
//                mregistration.setSurName(registrationobject.get("SurName").getAsString());
//            }
//            if (registrationobject.get("FirstName") != null) {
//                mregistration.setFirstName(registrationobject.get("FirstName").getAsString());
//            }
//            if (registrationobject.get("UID") != null) {
//                mregistration.setUid(registrationobject.get("UID").getAsString());
//            }
//            if (registrationobject.get("DesignationID") != null) {
//                mregistration.setDesignationName(registrationobject.get("DesignationID").getAsString());
//            }
//            if (registrationobject.get("Gender") != null) {
//                mregistration.setGender(registrationobject.get("Gender").getAsString());
//            }
//            if (registrationobject.get("Age") != null) {
//                mregistration.setAge(registrationobject.get("Age").getAsInt());
//            }
//            if (registrationobject.get("EmailId") != null) {
//                mregistration.setEmailId(registrationobject.get("EmailId").getAsString());
//            }
//            if (registrationobject.get("MobileNo") != null) {
//                mregistration.setMobileNo(registrationobject.get("MobileNo").getAsString());
//            }
//            if (registrationobject.get("VisionProblem") != null) {
//                mregistration.setVisionProblem(registrationobject.get("VisionProblem").getAsString());
//            }
//            if (registrationobject.get("WearSpects") != null) {
//                mregistration.setWearSpects(registrationobject.get("WearSpects").getAsString());
//            }
//            if (registrationobject.get("Diabetic") != null) {
//                mregistration.setDiabetic(registrationobject.get("Diabetic").getAsString());
//            }
//            if (registrationobject.get("BloodPleasure") != null) {
//                mregistration.setBloodPleasure(registrationobject.get("BloodPleasure").getAsString());
//            }
//            if (registrationobject.get("RegurarlyEyeChecked") != null) {
//                mregistration.setRegurarlyEyeChecked(registrationobject.get("RegurarlyEyeChecked").getAsString());
//            }
//            if (registrationobject.get("RegDate") != null) {
//                mregistration.setRegDate(dateFormat.parse(registrationobject.get("RegDate").getAsString()));
//            }
//            if (registrationobject.get("campPlace") != null) {
//                mregistration.setCampPlace(registrationobject.get("campPlace").getAsString());
//            }
//            if (registrationobject.get("ReferredDocs") != null) {
//                mregistration.setReferredHosp(registrationobject.get("ReferredDocs").getAsString());
//            }
//            if (registrationobject.get("Remarks") != null) {
//                mregistration.setRemarks(registrationobject.get("Remarks").getAsString());
//            }
//            if (registrationobject.get("Address") != null) {
//                mregistration.setAddress(registrationobject.get("Address").getAsString());
//            }
//            mregistration.setCreatedDate(date);
//
//            regid = (int) session.save(mregistration);
//
//            TtUploaddocs tt_upload = new TtUploaddocs();
//
//            tt_upload.setRegID(regid);
//            //System.out.println("doc_string"+imageobject.get("doc_string").getAsString());
//            if (imageobject.get("doc_string") != null) {
//                //tt_upload.setDocString(imageobject.get("doc_string").getAsString());
//                //System.out.println("doc_string"+imageobject.get("doc_string").getAsString());
//                String file_string = imageobject.get("doc_string").getAsString();
//                //System.out.println("file" + file_string);
//                String fileStream = file_string;
//                String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
//
//                String textDate = dateFormat.format(sqlDate);
//                bytes = Base64.decode(fileStream);
//                System.out.println("bytes" + bytes);
//                String location = "ImagesDetails";
//                //C:\inetpub\wwwroot\Images
//                String locFile = "C:\\inetpub\\wwwroot\\Images\\MedicalCamp\\" + timeStamp + regid + ".png";
//                //String locFile = "C:\\Golf\\" + location + "\\" + textDate + "\\" + file_names + ".png";
//                System.out.println("LocFile" + locFile);
//                File file = new File(locFile);
//                String filPathabs = file.getAbsolutePath();
//                String filePath = filPathabs.substring(0, filPathabs.lastIndexOf(File.separator));
//                String fil = file.getPath();
//                boolean val = file.getParentFile().mkdirs();
//                FileOutputStream fop = null;
//                try {
//                    fop = new FileOutputStream(file);
//                    fop.write(bytes);
//                    fop.flush();
//                    fop.close();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                    result = "{\"status\":\"Failed\",\"statusMessage\":\"File not uploaded to server due to the failure in file creation\"}";
//                    return result;
//                }
//                if (filePath != null) {
//                    image = timeStamp + regid + ".png";
//                    tt_upload.setDocPath(image);
//                }
//
//                uploadid = (int) session.save(tt_upload);
//            }
//
//            TtEyespec tt_eye_spec = new TtEyespec();
//
//            tt_eye_spec.setRegID(regid);
//            if (eye_camp_object.get("REDV_Sph") != null) {
//                tt_eye_spec.setREDVSph(eye_camp_object.get("REDV_Sph").getAsString());
//            }
//            if (eye_camp_object.get("REDV_Cyl") != null) {
//                tt_eye_spec.setREDVCyl(eye_camp_object.get("REDV_Cyl").getAsString());
//            }
//            if (eye_camp_object.get("REDV_Axis") != null) {
//                tt_eye_spec.setREDVAxis(eye_camp_object.get("REDV_Axis").getAsString());
//            }
//            if (eye_camp_object.get("ReDV_Va") != null) {
//                tt_eye_spec.setReDVVa(eye_camp_object.get("ReDV_Va").getAsString());
//            }
//            if (eye_camp_object.get("RENV_Sph") != null) {
//                tt_eye_spec.setRENVSph(eye_camp_object.get("RENV_Sph").getAsString());
//            }
//            if (eye_camp_object.get("RENV_Cyl") != null) {
//                tt_eye_spec.setRENVCyl(eye_camp_object.get("RENV_Cyl").getAsString());
//            }
//            if (eye_camp_object.get("RENV_Axis") != null) {
//                tt_eye_spec.setRENVAxis(eye_camp_object.get("RENV_Axis").getAsString());
//            }
//            if (eye_camp_object.get("ReNV_Va") != null) {
//                tt_eye_spec.setReNVVa(eye_camp_object.get("ReNV_Va").getAsString());
//            }
//            if (eye_camp_object.get("LEDV_Sph") != null) {
//                tt_eye_spec.setLEDVSph(eye_camp_object.get("LEDV_Sph").getAsString());
//            }
//            if (eye_camp_object.get("LEDV_Cyl") != null) {
//                tt_eye_spec.setLEDVCyl(eye_camp_object.get("LEDV_Cyl").getAsString());
//            }
//            if (eye_camp_object.get("LEDV_Axis") != null) {
//                tt_eye_spec.setLEDVAxis(eye_camp_object.get("LEDV_Axis").getAsString());
//            }
//            if (eye_camp_object.get("LeDV_Va") != null) {
//                tt_eye_spec.setLeDVVa(eye_camp_object.get("LeDV_Va").getAsString());
//            }
//            if (eye_camp_object.get("LENV_Sph") != null) {
//                tt_eye_spec.setLENVSph(eye_camp_object.get("LENV_Sph").getAsString());
//            }
//            if (eye_camp_object.get("LENV_Cyl") != null) {
//                tt_eye_spec.setLENVCyl(eye_camp_object.get("LENV_Cyl").getAsString());
//            }
//            if (eye_camp_object.get("LENV_Axis") != null) {
//                tt_eye_spec.setLENVAxis(eye_camp_object.get("LENV_Axis").getAsString());
//            }
//            if (eye_camp_object.get("LENV_Va") != null) {
//                tt_eye_spec.setLENVVa(eye_camp_object.get("LENV_Va").getAsString());
//            }
//
//            eyecampid = (int) session.save(tt_eye_spec);
//
//            TtOutpatient tt_outpatient = new TtOutpatient();
//
//            tt_outpatient.setRegID(regid);
//            if (eye_counselling_obj.get("Complaints") != null) {
//                tt_outpatient.setComplaints(eye_counselling_obj.get("Complaints").getAsString());
//            }
//            if (eye_counselling_obj.get("General") != null) {
//                tt_outpatient.setGeneral(eye_counselling_obj.get("General").getAsString());
//            }
//            if (eye_counselling_obj.get("Opthalmic") != null) {
//                tt_outpatient.setOpthalmic(eye_counselling_obj.get("Opthalmic").getAsString());
//            }
//            if (eye_counselling_obj.get("GPE") != null) {
//                tt_outpatient.setGpe(eye_counselling_obj.get("GPE").getAsString());
//            }
//            if (eye_counselling_obj.get("VisionID") != null) {
//                tt_outpatient.setVisionID(eye_counselling_obj.get("VisionID").getAsString());
//            }
//            if (eye_counselling_obj.get("HeadPosture") != null) {
//                tt_outpatient.setHeadPosture(eye_counselling_obj.get("HeadPosture").getAsString());
//            }
//            if (eye_counselling_obj.get("OcularPosture") != null) {
//                tt_outpatient.setOcularPosture(eye_counselling_obj.get("OcularPosture").getAsString());
//            }
//            if (eye_counselling_obj.get("OcularMovement") != null) {
//                tt_outpatient.setOcularMovement(eye_counselling_obj.get("OcularMovement").getAsString());
//            }
//            if (eye_counselling_obj.get("AdnexaRight_Eye") != null) {
//                tt_outpatient.setAdnexaRightEye(eye_counselling_obj.get("AdnexaRight_Eye").getAsString());
//            }
//            if (eye_counselling_obj.get("AdnexaLeft_Eye") != null) {
//                tt_outpatient.setAdnexaLeftEye(eye_counselling_obj.get("AdnexaLeft_Eye").getAsString());
//            }
//            if (eye_counselling_obj.get("AnteriorRight_Eye") != null) {
//                tt_outpatient.setAnteriorRightEye(eye_counselling_obj.get("AnteriorRight_Eye").getAsString());
//            }
//            if (eye_counselling_obj.get("AnteriorLeft_Eye") != null) {
//                tt_outpatient.setAnteriorLeftEye(eye_counselling_obj.get("AnteriorLeft_Eye").getAsString());
//            }
//            if (eye_counselling_obj.get("SlitlampExam") != null) {
//                //tt_outpatient.setSlitlampExam(eye_counselling_obj.get("SlitlampExam").getAsString());
//
//                String file_string = eye_counselling_obj.get("SlitlampExam").getAsString();
//                //System.out.println("file" + file_string);
//                String fileStream = file_string;
//                String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
//
//                String textDate = dateFormat.format(sqlDate);
//                bytes = Base64.decode(fileStream);
//                System.out.println("bytes" + bytes);
//                String location = "ImagesDetails";
//                //C:\inetpub\wwwroot\Images
//                String locFile = "C:\\inetpub\\wwwroot\\Images\\MedicalCamp\\" + timeStamp + regid + 1 + ".png";
//                //String locFile = "C:\\Golf\\" + location + "\\" + textDate + "\\" + file_names + ".png";
//                System.out.println("LocFile" + locFile);
//                File file = new File(locFile);
//                String filPathabs = file.getAbsolutePath();
//                String filePath = filPathabs.substring(0, filPathabs.lastIndexOf(File.separator));
//                String fil = file.getPath();
//                boolean val = file.getParentFile().mkdirs();
//                FileOutputStream fop = null;
//                try {
//                    fop = new FileOutputStream(file);
//                    fop.write(bytes);
//                    fop.flush();
//                    fop.close();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                    result = "{\"status\":\"Failed\",\"statusMessage\":\"File not uploaded to server due to the failure in file creation\"}";
//                    return result;
//                }
//                if (filePath != null) {
//                    image = timeStamp + regid + ".png";
//                    tt_outpatient.setSlitlampExam(image);
//                    //tt_upload.setDocPath(image);
//                }
//            }
//            if (eye_counselling_obj.get("IntraOcularPressure") != null) {
//                tt_outpatient.setIntraOcularPressure(eye_counselling_obj.get("IntraOcularPressure").getAsString());
//            }
//            if (eye_counselling_obj.get("KReading") != null) {
//                tt_outpatient.setKReading(eye_counselling_obj.get("KReading").getAsString());
//            }
//            if (eye_counselling_obj.get("Gonioscopy") != null) {
//                tt_outpatient.setGonioscopy(eye_counselling_obj.get("Gonioscopy").getAsString());
//            }
//            if (eye_counselling_obj.get("Funds_Shaffers") != null) {
//                tt_outpatient.setFundsShaffers(eye_counselling_obj.get("Funds_Shaffers").getAsString());
//            }
//            if (eye_counselling_obj.get("Funds_Shaffer_Text") != null) {
//                //tt_outpatient.setFundsShafferText(eye_counselling_obj.get("Funds_Shaffer_Text").getAsString());
//
//                String file_string = eye_counselling_obj.get("Funds_Shaffer_Text").getAsString();
//                //System.out.println("file" + file_string);
//                String fileStream = file_string;
//                String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
//
//                String textDate = dateFormat.format(sqlDate);
//                bytes = Base64.decode(fileStream);
//                System.out.println("bytes" + bytes);
//                String location = "ImagesDetails";
//                //C:\inetpub\wwwroot\Images
//                String locFile = "C:\\inetpub\\wwwroot\\Images\\MedicalCamp\\" + timeStamp + regid + 2 + ".png";
//                //String locFile = "C:\\Golf\\" + location + "\\" + textDate + "\\" + file_names + ".png";
//                System.out.println("LocFile" + locFile);
//                File file = new File(locFile);
//                String filPathabs = file.getAbsolutePath();
//                String filePath = filPathabs.substring(0, filPathabs.lastIndexOf(File.separator));
//                String fil = file.getPath();
//                boolean val = file.getParentFile().mkdirs();
//                FileOutputStream fop = null;
//                try {
//                    fop = new FileOutputStream(file);
//                    fop.write(bytes);
//                    fop.flush();
//                    fop.close();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                    result = "{\"status\":\"Failed\",\"statusMessage\":\"File not uploaded to server due to the failure in file creation\"}";
//                    return result;
//                }
//                if (filePath != null) {
//                    image = timeStamp + regid + ".png";
//                    tt_outpatient.setFundsShafferText(image);
//                }
//            }
//            if (eye_counselling_obj.get("Funds") != null) {
//                String file_string = eye_counselling_obj.get("Funds").getAsString();
//                //System.out.println("file" + file_string);
//                String fileStream = file_string;
//                String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
//
//                String textDate = dateFormat.format(sqlDate);
//                bytes = Base64.decode(fileStream);
//                System.out.println("bytes" + bytes);
//                String location = "ImagesDetails";
//                //C:\inetpub\wwwroot\Images
//                String locFile = "C:\\inetpub\\wwwroot\\Images\\MedicalCamp\\" + timeStamp + regid + 3 + ".png";
//                //String locFile = "C:\\Golf\\" + location + "\\" + textDate + "\\" + file_names + ".png";
//                System.out.println("LocFile" + locFile);
//                File file = new File(locFile);
//                String filPathabs = file.getAbsolutePath();
//                String filePath = filPathabs.substring(0, filPathabs.lastIndexOf(File.separator));
//                String fil = file.getPath();
//                boolean val = file.getParentFile().mkdirs();
//                FileOutputStream fop = null;
//                try {
//                    fop = new FileOutputStream(file);
//                    fop.write(bytes);
//                    fop.flush();
//                    fop.close();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                    result = "{\"status\":\"Failed\",\"statusMessage\":\"File not uploaded to server due to the failure in file creation\"}";
//                    return result;
//                }
//                if (filePath != null) {
//                    image = timeStamp + regid + ".png";
//                    tt_outpatient.setFunds(image);
//                }
//            }
//            if (eye_counselling_obj.get("SphDvRight_Eye") != null) {
//                tt_outpatient.setSphDvRightEye(eye_counselling_obj.get("SphDvRight_Eye").getAsString());
//            }
//            if (eye_counselling_obj.get("SphNvRight_Eye") != null) {
//                tt_outpatient.setSphNvRightEye(eye_counselling_obj.get("SphNvRight_Eye").getAsString());
//            }
//            if (eye_counselling_obj.get("CylDvRight_Eye") != null) {
//                tt_outpatient.setCylDvRightEye(eye_counselling_obj.get("CylDvRight_Eye").getAsString());
//            }
//            if (eye_counselling_obj.get("CylNvRight_Eye") != null) {
//                tt_outpatient.setCylNvRightEye(eye_counselling_obj.get("CylNvRight_Eye").getAsString());
//            }
//            if (eye_counselling_obj.get("AxisDvRight_Eye") != null) {
//                tt_outpatient.setAxisDvRightEye(eye_counselling_obj.get("AxisDvRight_Eye").getAsString());
//            }
//            if (eye_counselling_obj.get("AxisNvRight_Eye") != null) {
//                tt_outpatient.setAxisNvRightEye(eye_counselling_obj.get("AxisNvRight_Eye").getAsString());
//            }
//            if (eye_counselling_obj.get("VaDvRight_Eye") != null) {
//                tt_outpatient.setVaDvRightEye(eye_counselling_obj.get("VaDvRight_Eye").getAsString());
//            }
//            if (eye_counselling_obj.get("VaNvRight_Eye") != null) {
//                tt_outpatient.setVaNvRightEye(eye_counselling_obj.get("VaNvRight_Eye").getAsString());
//            }
//            if (eye_counselling_obj.get("SphDvLeft_Eye") != null) {
//                tt_outpatient.setSphDvLeftEye(eye_counselling_obj.get("SphDvLeft_Eye").getAsString());
//            }
//            if (eye_counselling_obj.get("SphNvLeft_Eye") != null) {
//                tt_outpatient.setSphNvLeftEye(eye_counselling_obj.get("SphNvLeft_Eye").getAsString());
//            }
//            if (eye_counselling_obj.get("CylDvLeft_Eye") != null) {
//                tt_outpatient.setCylDvLeftEye(eye_counselling_obj.get("CylDvLeft_Eye").getAsString());
//            }
//            if (eye_counselling_obj.get("CylNvLeft_Eye") != null) {
//                tt_outpatient.setCylNvLeftEye(eye_counselling_obj.get("CylNvLeft_Eye").getAsString());
//            }
//            if (eye_counselling_obj.get("AxisDvLeft_Eye") != null) {
//                tt_outpatient.setAxisDvLeftEye(eye_counselling_obj.get("AxisDvLeft_Eye").getAsString());
//            }
//            if (eye_counselling_obj.get("AxisNvLeft_Eye") != null) {
//                tt_outpatient.setAxisNvLeftEye(eye_counselling_obj.get("AxisNvLeft_Eye").getAsString());
//            }
//            if (eye_counselling_obj.get("VaDvLeft_Eye") != null) {
//                tt_outpatient.setVaDvLeftEye(eye_counselling_obj.get("VaDvLeft_Eye").getAsString());
//            }
//            if (eye_counselling_obj.get("VaNvLeft_Eye") != null) {
//                tt_outpatient.setVaNvLeftEye(eye_counselling_obj.get("VaNvLeft_Eye").getAsString());
//            }
//            if (eye_counselling_obj.get("FollowUp") != null) {
//                tt_outpatient.setFollowUp(eye_counselling_obj.get("FollowUp").getAsString());
//            }
//            if (eye_counselling_obj.get("Treatment") != null) {
//                tt_outpatient.setTreatment(eye_counselling_obj.get("Treatment").getAsString());
//            }
//
//            eyecounsid = (int) session.save(tt_outpatient);
//            //session.getTransaction().commit();
//
//            result = "{\"status\":\"Success\",\"statusMessage\":\"Data Saved\", \"regid\":" + regid + ", \"uploadid\":" + uploadid + ""
//                    + ", \"eyecampid\":" + eyecampid + ", \"eyecounsid\":" + eyecounsid + "}";
//            return result;
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (session != null) {
//                e.printStackTrace();
//                //session.getTransaction().rollback();
//            }
//            result = "{\"status\":\"Failed\",\"statusMessage\":\"Sync failed\"}";
//            return result;
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//    }
//
//    @Override
//    public String saveEyeRegistrationDetails(String registrationobject) {
//        String result = "";
//        Session session = null;
//        Date date = new Date();
//        int regid;
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        java.util.Date utilDate = new java.util.Date();
//        JSONObject object = null;
//        try {
//            object = new JSONObject(registrationobject);
//            System.out.println("object::" + object);
//            System.out.println("object.get(\"FirstName\")::" + object.getJSONObject("registrationobject").getString("FirstName"));
//            session = getSessionFactory().openSession();
//
//            MRegistration mregistration = new MRegistration();
//            if (object.getJSONObject("registrationobject").getString("SurName") != null) {
//                mregistration.setSurName(object.getJSONObject("registrationobject").getString("SurName"));
//            }
//            if (object.getJSONObject("registrationobject").getString("FirstName") != null) {
//                mregistration.setFirstName(object.getJSONObject("registrationobject").getString("FirstName"));
//            }
//            if (object.getJSONObject("registrationobject").getString("UID") != null) {
//                mregistration.setUid(object.getJSONObject("registrationobject").getString("UID"));
//            }
//            if (object.getJSONObject("registrationobject").getString("DesignationID") != null) {
//                mregistration.setDesignationName(object.getJSONObject("registrationobject").getString("DesignationID"));
//            }
//            if (object.getJSONObject("registrationobject").getString("Gender") != null) {
//                mregistration.setGender(object.getJSONObject("registrationobject").getString("Gender"));
//            }
//            if (object.getJSONObject("registrationobject").getString("Age") != null) {
//                mregistration.setAge(object.getJSONObject("registrationobject").getInt("Age"));
//            }
//            if (object.getJSONObject("registrationobject").getString("EmailId") != null) {
//                mregistration.setEmailId(object.getJSONObject("registrationobject").getString("EmailId"));
//            }
//            if (object.getJSONObject("registrationobject").getString("MobileNo") != null) {
//                mregistration.setMobileNo(object.getJSONObject("registrationobject").getString("MobileNo"));
//            }
//            if (object.getJSONObject("registrationobject").getString("VisionProblem") != null) {
//                mregistration.setVisionProblem(object.getJSONObject("registrationobject").getString("VisionProblem"));
//            }
//            if (object.getJSONObject("registrationobject").getString("WearSpects") != null) {
//                mregistration.setWearSpects(object.getJSONObject("registrationobject").getString("WearSpects"));
//            }
//            if (object.getJSONObject("registrationobject").getString("Diabetic") != null) {
//                mregistration.setDiabetic(object.getJSONObject("registrationobject").getString("Diabetic"));
//            }
//            if (object.getJSONObject("registrationobject").getString("BloodPleasure") != null) {
//                mregistration.setBloodPleasure(object.getJSONObject("registrationobject").getString("BloodPleasure"));
//            }
//            if (object.getJSONObject("registrationobject").getString("RegurarlyEyeChecked") != null) {
//                mregistration.setRegurarlyEyeChecked(object.getJSONObject("registrationobject").getString("RegurarlyEyeChecked"));
//            }
//            if (object.getJSONObject("registrationobject").getString("RegDate") != null) {
//                mregistration.setRegDate(dateFormat.parse(object.getJSONObject("registrationobject").getString("RegDate")));
//            }
//            if (object.getJSONObject("registrationobject").getString("campPlace") != null) {
//                mregistration.setCampPlace(object.getJSONObject("registrationobject").getString("campPlace"));
//            }
//            if (object.getJSONObject("registrationobject").getString("ReferredDocs") != null) {
//                mregistration.setReferredHosp(object.getJSONObject("registrationobject").getString("ReferredDocs"));
//            }
//            if (object.getJSONObject("registrationobject").getString("Remarks") != null) {
//                mregistration.setRemarks(object.getJSONObject("registrationobject").getString("Remarks"));
//            }
//            if (object.getJSONObject("registrationobject").getString("Address") != null) {
//                mregistration.setAddress(object.getJSONObject("registrationobject").getString("Address"));
//            }
//            if (object.getJSONObject("registrationobject").getString("AadhaarId") != null) {
//                mregistration.setAadharNo(object.getJSONObject("registrationobject").getString("AadhaarId"));
//            }
//
//            mregistration.setCreatedDate(date);
//            regid = (int) session.save(mregistration);
//
//            result = "{\"status\":\"Success\",\"regid\":\"" + regid + "\",\"UID\":\"" + object.getJSONObject("registrationobject").getString("UID") + "\"}";
//
//            return result;
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (session != null) {
//                e.printStackTrace();
//            }
//            result = "{\"status\":\"Failed\",\"statusMessage\":\"Sync failed\"}";
//            return result;
//        }
//    }
//    @Override
//    public String saveEyeSpecificationDtls(JsonObject eye_camp_object) {
//        Session session = null;
//        String result = null;
//        int eye_spec_id, patient_his_id;
//
//        try {
//            session = getSessionFactory().openSession();
//
//            TEyespecification tt_eye_spec = new TEyespecification();
//
//            if (eye_camp_object.get("patient_id") != null) {
//                tt_eye_spec.setPatientId(eye_camp_object.get("patient_id").getAsInt());
//            }
//            if (eye_camp_object.get("camp_id") != null) {
//                tt_eye_spec.setCampId(eye_camp_object.get("camp_id").getAsInt());
//            }
//            if (eye_camp_object.get("REDV_Sph") != null) {
//                tt_eye_spec.setRedvsph(eye_camp_object.get("REDV_Sph").getAsString());
//            }
//            if (eye_camp_object.get("REDV_Cyl") != null) {
//                tt_eye_spec.setRedvcyl(eye_camp_object.get("REDV_Cyl").getAsString());
//            }
//            if (eye_camp_object.get("REDV_Axis") != null) {
//                tt_eye_spec.setREDVAxis(eye_camp_object.get("REDV_Axis").getAsString());
//            }
//            if (eye_camp_object.get("ReDV_Va") != null) {
//                tt_eye_spec.setRedvva(eye_camp_object.get("ReDV_Va").getAsString());
//            }
//            if (eye_camp_object.get("RENV_Sph") != null) {
//                tt_eye_spec.setRenvsph(eye_camp_object.get("RENV_Sph").getAsString());
//            }
//            if (eye_camp_object.get("RENV_Cyl") != null) {
//                tt_eye_spec.setRenvcyl(eye_camp_object.get("RENV_Cyl").getAsString());
//            }
//            if (eye_camp_object.get("RENV_Axis") != null) {
//                tt_eye_spec.setRENVAxis(eye_camp_object.get("RENV_Axis").getAsString());
//            }
//            if (eye_camp_object.get("ReNV_Va") != null) {
//                tt_eye_spec.setRenvva(eye_camp_object.get("ReNV_Va").getAsString());
//            }
//            if (eye_camp_object.get("LEDV_Sph") != null) {
//                tt_eye_spec.setLedvsph(eye_camp_object.get("LEDV_Sph").getAsString());
//            }
//            if (eye_camp_object.get("LEDV_Cyl") != null) {
//                tt_eye_spec.setLedvcyl(eye_camp_object.get("LEDV_Cyl").getAsString());
//            }
//            if (eye_camp_object.get("LEDV_Axis") != null) {
//                tt_eye_spec.setLEDVAxis(eye_camp_object.get("LEDV_Axis").getAsString());
//            }
//            if (eye_camp_object.get("LeDV_Va") != null) {
//                tt_eye_spec.setLedvva(eye_camp_object.get("LeDV_Va").getAsString());
//            }
//            if (eye_camp_object.get("LENV_Sph") != null) {
//                tt_eye_spec.setLenvsph(eye_camp_object.get("LENV_Sph").getAsString());
//            }
//            if (eye_camp_object.get("LENV_Cyl") != null) {
//                tt_eye_spec.setLenvcyl(eye_camp_object.get("LENV_Cyl").getAsString());
//            }
//            if (eye_camp_object.get("LENV_Axis") != null) {
//                tt_eye_spec.setLENVAxis(eye_camp_object.get("LENV_Axis").getAsString());
//            }
//            if (eye_camp_object.get("LENV_Va") != null) {
//                tt_eye_spec.setLenvva(eye_camp_object.get("LENV_Va").getAsString());
//            }
//            if (eye_camp_object.get("need_opticals") != null) {
//                tt_eye_spec.setNeedOpticals(eye_camp_object.get("need_opticals").getAsString());
//            }
//            tt_eye_spec.setCreatedOn(new Date());
//            
//            eye_spec_id = (int) session.save(tt_eye_spec);
//
//            TPatienthistory patient_history = new TPatienthistory();
//
//            if (eye_camp_object.get("camp_id") != null) {
//                patient_history.setCampId(eye_camp_object.get("camp_id").getAsInt());
//            }
//            if (eye_camp_object.get("patient_id") != null) {
//                patient_history.setPatientId(eye_camp_object.get("patient_id").getAsInt());
//            }
//            if (eye_camp_object.get("status") != null) {
//
//                if (eye_camp_object.get("status").getAsString().equalsIgnoreCase("Normal")) {
//                    patient_history.setStatusId(2);
//                }
//                if (eye_camp_object.get("status").getAsString().equalsIgnoreCase("Referring to Hospital")) {
//                    patient_history.setStatusId(3);
//                }
//            }
//            patient_history.setTreatmentLevelId(1);
//            patient_history.setCreatedOn(new Date());
//
//            patient_his_id = (int) session.save(patient_history);
//
//            result = "{\"status\":\"Success\",\"eye_spec_id\":\"" + eye_spec_id + "\",\"patient_his_id\":\"" + patient_his_id + "\"}";
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (session != null) {
//                e.printStackTrace();
//            }
//            result = "{\"status\":\"Failed\",\"statusMessage\":\"Sync failed\",\"exception\":" + e + "}";
//            return result;
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//        return result;
//    }
}
