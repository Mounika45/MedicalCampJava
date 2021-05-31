/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.healthcamp.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "m_mandal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MMandal.findAll", query = "SELECT m FROM MMandal m")
    , @NamedQuery(name = "MMandal.findById", query = "SELECT m FROM MMandal m WHERE m.id = :id")
    , @NamedQuery(name = "MMandal.findByName", query = "SELECT m FROM MMandal m WHERE m.name = :name")
    , @NamedQuery(name = "MMandal.findByDistrictId", query = "SELECT m FROM MMandal m WHERE m.districtId = :districtId")})
public class MMandal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DistrictId")
    private int districtId;

    public MMandal() {
    }

    public MMandal(Integer id) {
        this.id = id;
    }

    public MMandal(Integer id, String name, int districtId) {
        this.id = id;
        this.name = name;
        this.districtId = districtId;
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

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
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
        if (!(object instanceof MMandal)) {
            return false;
        }
        MMandal other = (MMandal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.healthcamp.entities.MMandal[ id=" + id + " ]";
    }
    
}
