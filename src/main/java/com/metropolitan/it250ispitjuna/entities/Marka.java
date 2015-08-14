/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.it250ispitjuna.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Vuk
 */
@Entity
@Table(name = "marka")
@NamedQueries({
    @NamedQuery(name = "Marka.findAll", query = "SELECT m FROM Marka m")})
public class Marka implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MARKA_ID")
    private Integer markaId;
    @Basic(optional = false)
    @Column(name = "MARKA_IME")
    private String markaIme;
    @OneToMany(mappedBy = "markaId")
    private List<Model> modelList;
    @OneToMany(mappedBy = "markaId")
    private List<Automobil> automobilList;

    @Inject
    public Marka() {
    }

    public Marka(Integer markaId) {
        this.markaId = markaId;
    }

    public Marka(Integer markaId, String markaIme) {
        this.markaId = markaId;
        this.markaIme = markaIme;
    }

    public Integer getMarkaId() {
        return markaId;
    }

    public void setMarkaId(Integer markaId) {
        this.markaId = markaId;
    }

    public String getMarkaIme() {
        return markaIme;
    }

    public void setMarkaIme(String markaIme) {
        this.markaIme = markaIme;
    }

    public List<Model> getModelList() {
        return modelList;
    }

    public void setModelList(List<Model> modelList) {
        this.modelList = modelList;
    }

    public List<Automobil> getAutomobilList() {
        return automobilList;
    }

    public void setAutomobilList(List<Automobil> automobilList) {
        this.automobilList = automobilList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (markaId != null ? markaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marka)) {
            return false;
        }
        Marka other = (Marka) object;
        if ((this.markaId == null && other.markaId != null) || (this.markaId != null && !this.markaId.equals(other.markaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return markaIme;
    }

}
