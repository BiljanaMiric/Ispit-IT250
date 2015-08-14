/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.it250ispitjuna.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Vuk
 */
@Entity
@Table(name = "servis")
@NamedQueries({
    @NamedQuery(name = "Servis.findAll", query = "SELECT s FROM Servis s")})
public class Servis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SERVIS_ID")
    private Integer servisId;
    @Column(name = "SERVIS_DATUMSERVISA")
    @Temporal(TemporalType.DATE)
    private Date servisDatumservisa;
    @Column(name = "SERVIS_DATUMKRAJASERVISA")
    @Temporal(TemporalType.DATE)
    private Date servisDatumkrajaservisa;
    @Column(name = "KILOMETRAZA")
    private Integer kilometraza;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CENA")
    private BigDecimal cena;
    @JoinColumn(name = "AUTOMOBIL_ID", referencedColumnName = "AUTOMOBIL_ID")
    @ManyToOne(optional = false)
    private Automobil automobilId;

    @Inject
    public Servis() {
    }

    public Servis(Integer servisId) {
        this.servisId = servisId;
    }

    public Integer getServisId() {
        return servisId;
    }

    public void setServisId(Integer servisId) {
        this.servisId = servisId;
    }

    public Date getServisDatumservisa() {
        return servisDatumservisa;
    }

    public void setServisDatumservisa(Date servisDatumservisa) {
        this.servisDatumservisa = servisDatumservisa;
    }

    public Date getServisDatumkrajaservisa() {
        return servisDatumkrajaservisa;
    }

    public void setServisDatumkrajaservisa(Date servisDatumkrajaservisa) {
        this.servisDatumkrajaservisa = servisDatumkrajaservisa;
    }

    public Integer getKilometraza() {
        return kilometraza;
    }

    public void setKilometraza(Integer kilometraza) {
        this.kilometraza = kilometraza;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public Automobil getAutomobilId() {
        return automobilId;
    }

    public void setAutomobilId(Automobil automobilId) {
        this.automobilId = automobilId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servisId != null ? servisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servis)) {
            return false;
        }
        Servis other = (Servis) object;
        if ((this.servisId == null && other.servisId != null) || (this.servisId != null && !this.servisId.equals(other.servisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metropolitan.it250ispitjuna.entities.Servis[ servisId=" + servisId + " ]";
    }

}
