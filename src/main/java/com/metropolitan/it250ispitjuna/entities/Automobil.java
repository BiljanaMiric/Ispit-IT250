/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.it250ispitjuna.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Vuk
 */
@Entity
@Table(name = "automobil")
@NamedQueries({
    @NamedQuery(name = "Automobil.findAll", query = "SELECT a FROM Automobil a")})
public class Automobil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AUTOMOBIL_ID")
    private Integer automobilId;
    @Basic(optional = false)
    @Column(name = "AUTOMOBIL_DATUM_UNOSA")
    @Temporal(TemporalType.DATE)
    private Date automobilDatumUnosa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "automobilId")
    private List<Servis> servisList;
    @JoinColumn(name = "KORISNIK_ID", referencedColumnName = "KORISNIK_ID")
    @ManyToOne(optional = false)
    private Korisnik korisnikId;
    @JoinColumn(name = "MARKA_ID", referencedColumnName = "MARKA_ID")
    @ManyToOne
    private Marka markaId;

    @Inject
    public Automobil() {
    }

    public Automobil(Integer automobilId) {
        this.automobilId = automobilId;
    }

    public Automobil(Integer automobilId, Date automobilDatumUnosa) {
        this.automobilId = automobilId;
        this.automobilDatumUnosa = automobilDatumUnosa;
    }

    public Integer getAutomobilId() {
        return automobilId;
    }

    public void setAutomobilId(Integer automobilId) {
        this.automobilId = automobilId;
    }

    public Date getAutomobilDatumUnosa() {
        return automobilDatumUnosa;
    }

    public void setAutomobilDatumUnosa(Date automobilDatumUnosa) {
        this.automobilDatumUnosa = automobilDatumUnosa;
    }

    public List<Servis> getServisList() {
        return servisList;
    }

    public void setServisList(List<Servis> servisList) {
        this.servisList = servisList;
    }

    public Korisnik getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Korisnik korisnikId) {
        this.korisnikId = korisnikId;
    }

    public Marka getMarkaId() {
        return markaId;
    }

    public void setMarkaId(Marka markaId) {
        this.markaId = markaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (automobilId != null ? automobilId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Automobil)) {
            return false;
        }
        Automobil other = (Automobil) object;
        if ((this.automobilId == null && other.automobilId != null) || (this.automobilId != null && !this.automobilId.equals(other.automobilId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metropolitan.it250ispitjuna.entities.Automobil[ automobilId=" + automobilId + " ]";
    }
    
}
