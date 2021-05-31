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
@Table(name = "m_patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MPatient.findAll", query = "SELECT m FROM MPatient m")
    , @NamedQuery(name = "MPatient.findById", query = "SELECT m FROM MPatient m WHERE m.id = :id")
    , @NamedQuery(name = "MPatient.findByCampId", query = "SELECT m FROM MPatient m WHERE m.campId = :campId")
    , @NamedQuery(name = "MPatient.findByFirstName", query = "SELECT m FROM MPatient m WHERE m.firstName = :firstName")
    , @NamedQuery(name = "MPatient.findByLastName", query = "SELECT m FROM MPatient m WHERE m.lastName = :lastName")
    , @NamedQuery(name = "MPatient.findByFatherHusbandName", query = "SELECT m FROM MPatient m WHERE m.fatherHusbandName = :fatherHusbandName")
    , @NamedQuery(name = "MPatient.findByAdharNum", query = "SELECT m FROM MPatient m WHERE m.adharNum = :adharNum")
    , @NamedQuery(name = "MPatient.findByMRNum", query = "SELECT m FROM MPatient m WHERE m.mRNum = :mRNum")
    , @NamedQuery(name = "MPatient.findByOccupation", query = "SELECT m FROM MPatient m WHERE m.occupation = :occupation")
    , @NamedQuery(name = "MPatient.findByGender", query = "SELECT m FROM MPatient m WHERE m.gender = :gender")
    , @NamedQuery(name = "MPatient.findByAge", query = "SELECT m FROM MPatient m WHERE m.age = :age")
    , @NamedQuery(name = "MPatient.findByEmailId", query = "SELECT m FROM MPatient m WHERE m.emailId = :emailId")
    , @NamedQuery(name = "MPatient.findByMobileNum", query = "SELECT m FROM MPatient m WHERE m.mobileNum = :mobileNum")
    , @NamedQuery(name = "MPatient.findByAddress", query = "SELECT m FROM MPatient m WHERE m.address = :address")
    , @NamedQuery(name = "MPatient.findByCreatedOn", query = "SELECT m FROM MPatient m WHERE m.createdOn = :createdOn")
    , @NamedQuery(name = "MPatient.findByCreatedBy", query = "SELECT m FROM MPatient m WHERE m.createdBy = :createdBy")
    , @NamedQuery(name = "MPatient.findByUpdatedOn", query = "SELECT m FROM MPatient m WHERE m.updatedOn = :updatedOn")
    , @NamedQuery(name = "MPatient.findByUpdatedBy", query = "SELECT m FROM MPatient m WHERE m.updatedBy = :updatedBy")})
public class MPatient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CampId")
    private int campId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "FirstName")
    private String firstName;
    @Size(max = 500)
    @Column(name = "LastName")
    private String lastName;
    @Size(max = 500)
    @Column(name = "FatherHusbandName")
    private String fatherHusbandName;
    @Size(max = 12)
    @Column(name = "AdharNum")
    private String adharNum;
    @Size(max = 50)
    @Column(name = "MRNum")
    private String mRNum;
    @Size(max = 50)
    @Column(name = "Occupation")
    private String occupation;
    @Size(max = 10)
    @Column(name = "Gender")
    private String gender;
    @Column(name = "Age")
    private Integer age;
    @Size(max = 100)
    @Column(name = "EmailId")
    private String emailId;
    @Size(max = 10)
    @Column(name = "MobileNum")
    private String mobileNum;
    @Size(max = 500)
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreatedBy")
    private int createdBy;
    @Column(name = "UpdatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    @Column(name = "UpdatedBy")
    private Integer updatedBy;

    public MPatient() {
    }

    public MPatient(Integer id) {
        this.id = id;
    }

    public MPatient(Integer id, int campId, String firstName, Date createdOn, int createdBy) {
        this.id = id;
        this.campId = campId;
        this.firstName = firstName;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCampId() {
        return campId;
    }

    public void setCampId(int campId) {
        this.campId = campId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherHusbandName() {
        return fatherHusbandName;
    }

    public void setFatherHusbandName(String fatherHusbandName) {
        this.fatherHusbandName = fatherHusbandName;
    }

    public String getAdharNum() {
        return adharNum;
    }

    public void setAdharNum(String adharNum) {
        this.adharNum = adharNum;
    }

    public String getMRNum() {
        return mRNum;
    }

    public void setMRNum(String mRNum) {
        this.mRNum = mRNum;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        if (!(object instanceof MPatient)) {
            return false;
        }
        MPatient other = (MPatient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.healthcamp.entities.MPatient[ id=" + id + " ]";
    }
    
}
