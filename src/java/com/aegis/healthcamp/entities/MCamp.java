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
@Table(name = "m_camp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MCamp.findAll", query = "SELECT m FROM MCamp m")
    , @NamedQuery(name = "MCamp.findById", query = "SELECT m FROM MCamp m WHERE m.id = :id")
    , @NamedQuery(name = "MCamp.findByName", query = "SELECT m FROM MCamp m WHERE m.name = :name")
    , @NamedQuery(name = "MCamp.findByDate", query = "SELECT m FROM MCamp m WHERE m.date = :date")
    , @NamedQuery(name = "MCamp.findByDistrictId", query = "SELECT m FROM MCamp m WHERE m.districtId = :districtId")
    , @NamedQuery(name = "MCamp.findByMandalId", query = "SELECT m FROM MCamp m WHERE m.mandalId = :mandalId")
    , @NamedQuery(name = "MCamp.findByVillageId", query = "SELECT m FROM MCamp m WHERE m.villageId = :villageId")
    , @NamedQuery(name = "MCamp.findByStreetName", query = "SELECT m FROM MCamp m WHERE m.streetName = :streetName")
    , @NamedQuery(name = "MCamp.findByHouseNum", query = "SELECT m FROM MCamp m WHERE m.houseNum = :houseNum")
    , @NamedQuery(name = "MCamp.findByPINCode", query = "SELECT m FROM MCamp m WHERE m.pINCode = :pINCode")
    , @NamedQuery(name = "MCamp.findByOrganisedBy", query = "SELECT m FROM MCamp m WHERE m.organisedBy = :organisedBy")
    , @NamedQuery(name = "MCamp.findByOrganisedContact", query = "SELECT m FROM MCamp m WHERE m.organisedContact = :organisedContact")
    , @NamedQuery(name = "MCamp.findByRemarks", query = "SELECT m FROM MCamp m WHERE m.remarks = :remarks")
    , @NamedQuery(name = "MCamp.findByCreatedOn", query = "SELECT m FROM MCamp m WHERE m.createdOn = :createdOn")
    , @NamedQuery(name = "MCamp.findByCreatedBy", query = "SELECT m FROM MCamp m WHERE m.createdBy = :createdBy")
    , @NamedQuery(name = "MCamp.findByUpdatedOn", query = "SELECT m FROM MCamp m WHERE m.updatedOn = :updatedOn")
    , @NamedQuery(name = "MCamp.findByUpdatedBy", query = "SELECT m FROM MCamp m WHERE m.updatedBy = :updatedBy")})
public class MCamp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Name")
    private String name;
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "DistrictId")
    private Integer districtId;
    @Column(name = "MandalId")
    private Integer mandalId;
    @Column(name = "VillageId")
    private Integer villageId;
    @Size(max = 50)
    @Column(name = "StreetName")
    private String streetName;
    @Size(max = 50)
    @Column(name = "HouseNum")
    private String houseNum;
    @Size(max = 10)
    @Column(name = "PINCode")
    private String pINCode;
    @Size(max = 50)
    @Column(name = "OrganisedBy")
    private String organisedBy;
    @Size(max = 10)
    @Column(name = "OrganisedContact")
    private String organisedContact;
    @Size(max = 1000)
    @Column(name = "Remarks")
    private String remarks;
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

    public MCamp() {
    }

    public MCamp(Integer id) {
        this.id = id;
    }

    public MCamp(Integer id, String name, Date createdOn, int createdBy) {
        this.id = id;
        this.name = name;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getMandalId() {
        return mandalId;
    }

    public void setMandalId(Integer mandalId) {
        this.mandalId = mandalId;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getPINCode() {
        return pINCode;
    }

    public void setPINCode(String pINCode) {
        this.pINCode = pINCode;
    }

    public String getOrganisedBy() {
        return organisedBy;
    }

    public void setOrganisedBy(String organisedBy) {
        this.organisedBy = organisedBy;
    }

    public String getOrganisedContact() {
        return organisedContact;
    }

    public void setOrganisedContact(String organisedContact) {
        this.organisedContact = organisedContact;
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
        if (!(object instanceof MCamp)) {
            return false;
        }
        MCamp other = (MCamp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.healthcamp.entities.MCamp[ id=" + id + " ]";
    }
    
}
