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
@Table(name = "t_campmember")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCampmember.findAll", query = "SELECT t FROM TCampmember t")
    , @NamedQuery(name = "TCampmember.findById", query = "SELECT t FROM TCampmember t WHERE t.id = :id")
    , @NamedQuery(name = "TCampmember.findByCampId", query = "SELECT t FROM TCampmember t WHERE t.campId = :campId")
    , @NamedQuery(name = "TCampmember.findByName", query = "SELECT t FROM TCampmember t WHERE t.name = :name")
    , @NamedQuery(name = "TCampmember.findByDesignation", query = "SELECT t FROM TCampmember t WHERE t.designation = :designation")
    , @NamedQuery(name = "TCampmember.findByMobile", query = "SELECT t FROM TCampmember t WHERE t.mobile = :mobile")
    , @NamedQuery(name = "TCampmember.findByIsDeleted", query = "SELECT t FROM TCampmember t WHERE t.isDeleted = :isDeleted")
    , @NamedQuery(name = "TCampmember.findByCreatedOn", query = "SELECT t FROM TCampmember t WHERE t.createdOn = :createdOn")
    , @NamedQuery(name = "TCampmember.findByCreatedBy", query = "SELECT t FROM TCampmember t WHERE t.createdBy = :createdBy")
    , @NamedQuery(name = "TCampmember.findByUpdatedOn", query = "SELECT t FROM TCampmember t WHERE t.updatedOn = :updatedOn")
    , @NamedQuery(name = "TCampmember.findByUpdatedBy", query = "SELECT t FROM TCampmember t WHERE t.updatedBy = :updatedBy")})
public class TCampmember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CampId")
    private int campId;
    @Size(max = 50)
    @Column(name = "Name")
    private String name;
    @Size(max = 50)
    @Column(name = "Designation")
    private String designation;
    @Size(max = 10)
    @Column(name = "Mobile")
    private String mobile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsDeleted")
    private boolean isDeleted;
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

    public TCampmember() {
    }

    public TCampmember(Integer id) {
        this.id = id;
    }

    public TCampmember(Integer id, int campId, boolean isDeleted, Date createdOn, int createdBy) {
        this.id = id;
        this.campId = campId;
        this.isDeleted = isDeleted;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
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
        if (!(object instanceof TCampmember)) {
            return false;
        }
        TCampmember other = (TCampmember) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.healthcamp.entities.TCampmember[ id=" + id + " ]";
    }
    
}
