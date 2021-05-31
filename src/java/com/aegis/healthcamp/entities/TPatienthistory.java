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
@Table(name = "t_patienthistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPatienthistory.findAll", query = "SELECT t FROM TPatienthistory t")
    , @NamedQuery(name = "TPatienthistory.findById", query = "SELECT t FROM TPatienthistory t WHERE t.id = :id")
    , @NamedQuery(name = "TPatienthistory.findByPatientId", query = "SELECT t FROM TPatienthistory t WHERE t.patientId = :patientId")
    , @NamedQuery(name = "TPatienthistory.findByCampId", query = "SELECT t FROM TPatienthistory t WHERE t.campId = :campId")
    , @NamedQuery(name = "TPatienthistory.findByStatusId", query = "SELECT t FROM TPatienthistory t WHERE t.statusId = :statusId")
    , @NamedQuery(name = "TPatienthistory.findByTreatmentLevelId", query = "SELECT t FROM TPatienthistory t WHERE t.treatmentLevelId = :treatmentLevelId")
    , @NamedQuery(name = "TPatienthistory.findByHasFollowup", query = "SELECT t FROM TPatienthistory t WHERE t.hasFollowup = :hasFollowup")
    , @NamedQuery(name = "TPatienthistory.findByFollowupDate", query = "SELECT t FROM TPatienthistory t WHERE t.followupDate = :followupDate")
    , @NamedQuery(name = "TPatienthistory.findByRemarks", query = "SELECT t FROM TPatienthistory t WHERE t.remarks = :remarks")
    , @NamedQuery(name = "TPatienthistory.findByCreatedOn", query = "SELECT t FROM TPatienthistory t WHERE t.createdOn = :createdOn")
    , @NamedQuery(name = "TPatienthistory.findByCreatedBy", query = "SELECT t FROM TPatienthistory t WHERE t.createdBy = :createdBy")})
public class TPatienthistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "StatusId")
    private int statusId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TreatmentLevelId")
    private int treatmentLevelId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HasFollowup")
    private boolean hasFollowup;
    @Column(name = "FollowupDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date followupDate;
    @Size(max = 1000)
    @Column(name = "Remarks")
    private String remarks;
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "CreatedBy")
    private Integer createdBy;

    public TPatienthistory() {
    }

    public TPatienthistory(Integer id) {
        this.id = id;
    }

    public TPatienthistory(Integer id, int patientId, int campId, int statusId, int treatmentLevelId, boolean hasFollowup) {
        this.id = id;
        this.patientId = patientId;
        this.campId = campId;
        this.statusId = statusId;
        this.treatmentLevelId = treatmentLevelId;
        this.hasFollowup = hasFollowup;
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

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getTreatmentLevelId() {
        return treatmentLevelId;
    }

    public void setTreatmentLevelId(int treatmentLevelId) {
        this.treatmentLevelId = treatmentLevelId;
    }

    public boolean getHasFollowup() {
        return hasFollowup;
    }

    public void setHasFollowup(boolean hasFollowup) {
        this.hasFollowup = hasFollowup;
    }

    public Date getFollowupDate() {
        return followupDate;
    }

    public void setFollowupDate(Date followupDate) {
        this.followupDate = followupDate;
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

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
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
        if (!(object instanceof TPatienthistory)) {
            return false;
        }
        TPatienthistory other = (TPatienthistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.healthcamp.entities.TPatienthistory[ id=" + id + " ]";
    }
    
}
