/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.healthcamp.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "t_casesheet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCasesheet.findAll", query = "SELECT t FROM TCasesheet t")})
public class TCasesheet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id", updatable = false, insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PatientId")
    private int patientId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CampId")
    private int campId;
    @Size(max = 1000)
    @Column(name = "Complaints")
    private String complaints;
    @Size(max = 5000)
    @Column(name = "HitoryGeneral")
    private String hitoryGeneral;
    @Size(max = 50)
    @Column(name = "HistoryOpthalmic")
    private String historyOpthalmic;
    @Size(max = 50)
    @Column(name = "VnWithoutGlassesRE")
    private String vnWithoutGlassesRE;
    @Size(max = 50)
    @Column(name = "VnWithoutGlassesLE")
    private String vnWithoutGlassesLE;
    @Size(max = 50)
    @Column(name = "VnWithOldGlassesRE")
    private String vnWithOldGlassesRE;
    @Size(max = 50)
    @Column(name = "VnWithOldGlassesLE")
    private String vnWithOldGlassesLE;
    @Size(max = 50)
    @Column(name = "VnWithNewGlassesRE")
    private String vnWithNewGlassesRE;
    @Size(max = 50)
    @Column(name = "VnWithNewGlassesLE")
    private String vnWithNewGlassesLE;
    @Size(max = 100)
    @Column(name = "HeadPosture")
    private String headPosture;
    @Size(max = 100)
    @Column(name = "OcularPosture")
    private String ocularPosture;
    @Size(max = 100)
    @Column(name = "OcularMovement")
    private String ocularMovement;
    @Size(max = 50)
    @Column(name = "AdnexaRE")
    private String adnexaRE;
    @Size(max = 50)
    @Column(name = "AdnexaLE")
    private String adnexaLE;
    @Size(max = 50)
    @Column(name = "AnteriorSegmentRE")
    private String anteriorSegmentRE;
    @Size(max = 50)
    @Column(name = "AnteriorSegmentLE")
    private String anteriorSegmentLE;
    @Size(max = 50)
    @Column(name = "SlitLampRE")
    private String slitLampRE;
    @Size(max = 50)
    @Column(name = "SlitLampLE")
    private String slitLampLE;
    @Size(max = 5000)
    @Column(name = "Treatment")
    private String treatment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "CreatedBy")
    private Integer createdBy;
    @Column(name = "UpdatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    @Column(name = "UpdatedBy")
    private Integer updatedBy;

    public TCasesheet() {
    }

    public TCasesheet(Integer id) {
        this.id = id;
    }

    public TCasesheet(Integer id, int patientId, int campId, Date createdOn) {
        this.id = id;
        this.patientId = patientId;
        this.campId = campId;
        this.createdOn = createdOn;
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

    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }

    public String getHitoryGeneral() {
        return hitoryGeneral;
    }

    public void setHitoryGeneral(String hitoryGeneral) {
        this.hitoryGeneral = hitoryGeneral;
    }

    public String getHistoryOpthalmic() {
        return historyOpthalmic;
    }

    public void setHistoryOpthalmic(String historyOpthalmic) {
        this.historyOpthalmic = historyOpthalmic;
    }

    public String getVnWithoutGlassesRE() {
        return vnWithoutGlassesRE;
    }

    public void setVnWithoutGlassesRE(String vnWithoutGlassesRE) {
        this.vnWithoutGlassesRE = vnWithoutGlassesRE;
    }

    public String getVnWithoutGlassesLE() {
        return vnWithoutGlassesLE;
    }

    public void setVnWithoutGlassesLE(String vnWithoutGlassesLE) {
        this.vnWithoutGlassesLE = vnWithoutGlassesLE;
    }

    public String getVnWithOldGlassesRE() {
        return vnWithOldGlassesRE;
    }

    public void setVnWithOldGlassesRE(String vnWithOldGlassesRE) {
        this.vnWithOldGlassesRE = vnWithOldGlassesRE;
    }

    public String getVnWithOldGlassesLE() {
        return vnWithOldGlassesLE;
    }

    public void setVnWithOldGlassesLE(String vnWithOldGlassesLE) {
        this.vnWithOldGlassesLE = vnWithOldGlassesLE;
    }

    public String getVnWithNewGlassesRE() {
        return vnWithNewGlassesRE;
    }

    public void setVnWithNewGlassesRE(String vnWithNewGlassesRE) {
        this.vnWithNewGlassesRE = vnWithNewGlassesRE;
    }

    public String getVnWithNewGlassesLE() {
        return vnWithNewGlassesLE;
    }

    public void setVnWithNewGlassesLE(String vnWithNewGlassesLE) {
        this.vnWithNewGlassesLE = vnWithNewGlassesLE;
    }

    public String getHeadPosture() {
        return headPosture;
    }

    public void setHeadPosture(String headPosture) {
        this.headPosture = headPosture;
    }

    public String getOcularPosture() {
        return ocularPosture;
    }

    public void setOcularPosture(String ocularPosture) {
        this.ocularPosture = ocularPosture;
    }

    public String getOcularMovement() {
        return ocularMovement;
    }

    public void setOcularMovement(String ocularMovement) {
        this.ocularMovement = ocularMovement;
    }

    public String getAdnexaRE() {
        return adnexaRE;
    }

    public void setAdnexaRE(String adnexaRE) {
        this.adnexaRE = adnexaRE;
    }

    public String getAdnexaLE() {
        return adnexaLE;
    }

    public void setAdnexaLE(String adnexaLE) {
        this.adnexaLE = adnexaLE;
    }

    public String getAnteriorSegmentRE() {
        return anteriorSegmentRE;
    }

    public void setAnteriorSegmentRE(String anteriorSegmentRE) {
        this.anteriorSegmentRE = anteriorSegmentRE;
    }

    public String getAnteriorSegmentLE() {
        return anteriorSegmentLE;
    }

    public void setAnteriorSegmentLE(String anteriorSegmentLE) {
        this.anteriorSegmentLE = anteriorSegmentLE;
    }

    public String getSlitLampRE() {
        return slitLampRE;
    }

    public void setSlitLampRE(String slitLampRE) {
        this.slitLampRE = slitLampRE;
    }

    public String getSlitLampLE() {
        return slitLampLE;
    }

    public void setSlitLampLE(String slitLampLE) {
        this.slitLampLE = slitLampLE;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
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
        if (!(object instanceof TCasesheet)) {
            return false;
        }
        TCasesheet other = (TCasesheet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.healthcamp.entities.TCasesheet[ id=" + id + " ]";
    }
    
}
