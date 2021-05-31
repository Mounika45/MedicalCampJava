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
@Table(name = "m_village")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MVillage.findAll", query = "SELECT m FROM MVillage m")
    , @NamedQuery(name = "MVillage.findById", query = "SELECT m FROM MVillage m WHERE m.id = :id")
    , @NamedQuery(name = "MVillage.findByName", query = "SELECT m FROM MVillage m WHERE m.name = :name")
    , @NamedQuery(name = "MVillage.findByMandalId", query = "SELECT m FROM MVillage m WHERE m.mandalId = :mandalId")})
public class MVillage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MandalId")
    private int mandalId;

    public MVillage() {
    }

    public MVillage(Integer id) {
        this.id = id;
    }

    public MVillage(Integer id, String name, int mandalId) {
        this.id = id;
        this.name = name;
        this.mandalId = mandalId;
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

    public int getMandalId() {
        return mandalId;
    }

    public void setMandalId(int mandalId) {
        this.mandalId = mandalId;
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
        if (!(object instanceof MVillage)) {
            return false;
        }
        MVillage other = (MVillage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aegis.healthcamp.entities.MVillage[ id=" + id + " ]";
    }
    
}
