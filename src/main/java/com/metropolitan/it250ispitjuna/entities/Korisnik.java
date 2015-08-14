/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.it250ispitjuna.entities;

import com.metropolitan.it250ispitjuna.data.Role;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "korisnik")
@NamedQueries({
    @NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k")})
public class Korisnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KORISNIK_ID")
    private Integer korisnikId;
    @Column(name = "KORISNIK_IME")
    private String korisnikIme;
    @Column(name = "KORISNIK_PREZIME")
    private String korisnikPrezime;
    @Basic(optional = false)
    @Column(name = "KORISNIK_USERNAME")
    private String korisnikUsername;
    @Basic(optional = false)
    @Column(name = "KORISNIK_PASSWORD")
    private String korisnikPassword;
    @Column(name = "KORISNIK_ROLA")
    @Enumerated(EnumType.STRING)
    private Role korisnikRola;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "korisnikId")
    private List<Automobil> automobilList;

    @Inject
    public Korisnik() {
    }

    public Korisnik(Integer korisnikId) {
        this.korisnikId = korisnikId;
    }

    public Korisnik(Integer korisnikId, String korisnikUsername, String korisnikPassword) {
        this.korisnikId = korisnikId;
        this.korisnikUsername = korisnikUsername;
        this.korisnikPassword = korisnikPassword;
    }

    public Integer getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Integer korisnikId) {
        this.korisnikId = korisnikId;
    }

    public String getKorisnikIme() {
        return korisnikIme;
    }

    public void setKorisnikIme(String korisnikIme) {
        this.korisnikIme = korisnikIme;
    }

    public String getKorisnikPrezime() {
        return korisnikPrezime;
    }

    public void setKorisnikPrezime(String korisnikPrezime) {
        this.korisnikPrezime = korisnikPrezime;
    }

    public String getKorisnikUsername() {
        return korisnikUsername;
    }

    public void setKorisnikUsername(String korisnikUsername) {
        this.korisnikUsername = korisnikUsername;
    }

    public String getKorisnikPassword() {
        return korisnikPassword;
    }

    public void setKorisnikPassword(String korisnikPassword) {
        this.korisnikPassword = korisnikPassword;
    }

    public Role getKorisnikRola() {
        return korisnikRola;
    }

    public void setKorisnikRola(Role korisnikRola) {
        this.korisnikRola = korisnikRola;
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
        hash += (korisnikId != null ? korisnikId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.korisnikId == null && other.korisnikId != null) || (this.korisnikId != null && !this.korisnikId.equals(other.korisnikId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metropolitan.it250ispitjuna.entities.Korisnik[ korisnikId=" + korisnikId + " ]";
    }

}
