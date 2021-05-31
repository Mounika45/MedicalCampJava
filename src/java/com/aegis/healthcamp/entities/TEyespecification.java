/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.healthcamp.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "t_eyespecification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TEyespecification.findAll", query = "SELECT t FROM TEyespecification t")})
public class TEyespecification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "PatientId")
    private int patientId;
    @Basic(optional = false)
    @Column(name = "CampId")
    private int campId;
    @Column(name = "HasVisionProblem")
    private String hasVisionProblem;
    @Column(name = "HasSpectacles")
    private String hasSpectacles;
    @Column(name = "HasDiabetes")
    private String hasDiabetes;
    @Column(name = "HasBP")
    private String hasBP;
    @Size(max = 500)
    @Column(name = "WhereDoYouCheckEyes")
    private String whereDoYouCheckEyes;
    @Size(max = 50)
    @Column(name = "REDVSPH")
    private String redvsph;
    @Size(max = 50)
    @Column(name = "REDVCYL")
    private String redvcyl;
    @Size(max = 50)
    @Column(name = "REDVAxis")
    private String rEDVAxis;
    @Size(max = 50)
    @Column(name = "REDVVA")
    private String redvva;
    @Size(max = 50)
    @Column(name = "RENVSPH")
    private String renvsph;
    @Size(max = 50)
    @Column(name = "RENVCYL")
    private String renvcyl;
    @Size(max = 50)
    @Column(name = "RENVAxis")
    private String rENVAxis;
    @Size(max = 50)
    @Column(name = "RENVVA")
    private String renvva;
    @Size(max = 50)
    @Column(name = "LEDVSPH")
    private String ledvsph;
    @Size(max = 50)
    @Column(name = "LEDVCYL")
    private String ledvcyl;
    @Size(max = 50)
    @Column(name = "LEDVAxis")
    private String lEDVAxis;
    @Size(max = 50)
    @Column(name = "LEDVVA")
    private String ledvva;
    @Size(max = 50)
    @Column(name = "LENVSPH")
    private String lenvsph;
    @Size(max = 50)
    @Column(name = "LENVCYL")
    private String lenvcyl;
    @Size(max = 50)
    @Column(name = "LENVAxis")
    private String lENVAxis;
    @Size(max = 50)
    @Column(name = "LENVVA")
    private String lenvva;
    @Column(name = "NeedOpticals")
    private String needOpticals;
    @Size(max = 1000)
    @Column(name = "Remarks")
    private String remarks;
    @Basic(optional = false)
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Basic(optional = false)
    @Column(name = "CreatedBy")
    private int createdBy;
    @Column(name = "UpdatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    @Column(name = "UpdatedBy")
    private Integer updatedBy;

    public TEyespecification() {
    }

    public TEyespecification(Integer id) {
        this.id = id;
    }

    public TEyespecification(Integer id, int patientId, int campId, Date createdOn, int createdBy) {
        this.id = id;
        this.patientId = patientId;
        this.campId = campId;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getCampId() {
        return campId;
    }

    public void setCampId(int campId) {
        this.campId = campId;
    }

    public String getHasVisionProblem() {
        return hasVisionProblem;
    }

    public void setHasVisionProblem(String hasVisionProblem) {
        this.hasVisionProblem = hasVisionProblem;
    }

    public String getHasSpectacles() {
        return hasSpectacles;
    }

    public void setHasSpectacles(String hasSpectacles) {
        this.hasSpectacles = hasSpectacles;
    }

    public String getHasDiabetes() {
        return hasDiabetes;
    }

    public void setHasDiabetes(String hasDiabetes) {
        this.hasDiabetes = hasDiabetes;
    }

    public String getHasBP() {
        return hasBP;
    }

    public void setHasBP(String hasBP) {
        this.hasBP = hasBP;
    }

    public String getWhereDoYouCheckEyes() {
        return whereDoYouCheckEyes;
    }

    public void setWhereDoYouCheckEyes(String whereDoYouCheckEyes) {
        this.whereDoYouCheckEyes = whereDoYouCheckEyes;
    }

    public String getRedvsph() {
        return redvsph;
    }

    public void setRedvsph(String redvsph) {
        this.redvsph = redvsph;
    }

    public String getRedvcyl() {
        return redvcyl;
    }

    public void setRedvcyl(String redvcyl) {
        this.redvcyl = redvcyl;
    }

    public String getREDVAxis() {
        return rEDVAxis;
    }

    public void setREDVAxis(String rEDVAxis) {
        this.rEDVAxis = rEDVAxis;
    }

    public String getRedvva() {
        return redvva;
    }

    public void setRedvva(String redvva) {
        this.redvva = redvva;
    }

    public String getRenvsph() {
        return renvsph;
    }

    public void setRenvsph(String renvsph) {
        this.renvsph = renvsph;
    }

    public String getRenvcyl() {
        return renvcyl;
    }

    public void setRenvcyl(String renvcyl) {
        this.renvcyl = renvcyl;
    }

    public String getRENVAxis() {
        return rENVAxis;
    }

    public void setRENVAxis(String rENVAxis) {
        this.rENVAxis = rENVAxis;
    }

    public String getRenvva() {
        return renvva;
    }

    public void setRenvva(String renvva) {
        this.renvva = renvva;
    }

    public String getLedvsph() {
        return ledvsph;
    }

    public void setLedvsph(String ledvsph) {
        this.ledvsph = ledvsph;
    }

    public String getLedvcyl() {
        return ledvcyl;
    }

    public void setLedvcyl(String ledvcyl) {
        this.ledvcyl = ledvcyl;
    }

    public String getLEDVAxis() {
        return lEDVAxis;
    }

    public void setLEDVAxis(String lEDVAxis) {
        this.lEDVAxis = lEDVAxis;
    }

    public String getLedvva() {
        return ledvva;
    }

    public void setLedvva(String ledvva) {
        this.ledvva = ledvva;
    }

    public String getLenvsph() {
        return lenvsph;
    }

    public void setLenvsph(String lenvsph) {
        this.lenvsph = lenvsph;
    }

    public String getLenvcyl() {
        return lenvcyl;
    }

    public void setLenvcyl(String lenvcyl) {
        this.lenvcyl = lenvcyl;
    }

    public String getLENVAxis() {
        return lENVAxis;
    }

    public void setLENVAxis(String lENVAxis) {
        this.lENVAxis = lENVAxis;
    }

    public String getLenvva() {
        return lenvva;
    }

    public void setLenvva(String lenvva) {
        this.lenvva = lenvva;
    }

    public String getNeedOpticals() {
        return needOpticals;
    }

    public void setNeedOpticals(String needOpticals) {
        this.needOpticals = needOpticals;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TEyespecification)) {
            return false;
        }
        TEyespecification other = (TEyespecification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.healthcamp.entities.TEyespecification[ id=" + id + " ]";
    }
    
}
