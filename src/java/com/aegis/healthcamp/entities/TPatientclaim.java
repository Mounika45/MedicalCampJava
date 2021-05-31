/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.healthcamp.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "t_patientclaim")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPatientclaim.findAll", query = "SELECT t FROM TPatientclaim t")
    , @NamedQuery(name = "TPatientclaim.findById", query = "SELECT t FROM TPatientclaim t WHERE t.id = :id")
    , @NamedQuery(name = "TPatientclaim.findByPatientId", query = "SELECT t FROM TPatientclaim t WHERE t.patientId = :patientId")
    , @NamedQuery(name = "TPatientclaim.findByCaseSheetId", query = "SELECT t FROM TPatientclaim t WHERE t.caseSheetId = :caseSheetId")
    , @NamedQuery(name = "TPatientclaim.findByClaimCategory", query = "SELECT t FROM TPatientclaim t WHERE t.claimCategory = :claimCategory")
    , @NamedQuery(name = "TPatientclaim.findByClaimValue", query = "SELECT t FROM TPatientclaim t WHERE t.claimValue = :claimValue")
    , @NamedQuery(name = "TPatientclaim.findByCashClaim", query = "SELECT t FROM TPatientclaim t WHERE t.cashClaim = :cashClaim")
    , @NamedQuery(name = "TPatientclaim.findByCreatedOn", query = "SELECT t FROM TPatientclaim t WHERE t.createdOn = :createdOn")
    , @NamedQuery(name = "TPatientclaim.findByCreatedBy", query = "SELECT t FROM TPatientclaim t WHERE t.createdBy = :createdBy")})
public class TPatientclaim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "PatientId")
    private Integer patientId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CaseSheetId")
    private int caseSheetId;
    @Size(max = 50)
    @Column(name = "ClaimCategory")
    private String claimCategory;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ClaimValue")
    private BigDecimal claimValue;
    @Column(name = "CashClaim")
    private BigDecimal cashClaim;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreatedBy")
    private int createdBy;

    public TPatientclaim() {
    }

    public TPatientclaim(Integer id) {
        this.id = id;
    }

    public TPatientclaim(Integer id, int caseSheetId, Date createdOn, int createdBy) {
        this.id = id;
        this.caseSheetId = caseSheetId;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public int getCaseSheetId() {
        return caseSheetId;
    }

    public void setCaseSheetId(int caseSheetId) {
        this.caseSheetId = caseSheetId;
    }

    public String getClaimCategory() {
        return claimCategory;
    }

    public void setClaimCategory(String claimCategory) {
        this.claimCategory = claimCategory;
    }

    public BigDecimal getClaimValue() {
        return claimValue;
    }

    public void setClaimValue(BigDecimal claimValue) {
        this.claimValue = claimValue;
    }

    public BigDecimal getCashClaim() {
        return cashClaim;
    }

    public void setCashClaim(BigDecimal cashClaim) {
        this.cashClaim = cashClaim;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPatientclaim)) {
            return false;
        }
        TPatientclaim other = (TPatientclaim) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.healthcamp.entities.TPatientclaim[ id=" + id + " ]";
    }
    
}
