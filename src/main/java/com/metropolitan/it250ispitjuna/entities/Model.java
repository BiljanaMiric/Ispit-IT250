/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.it250ispitjuna.entities;

import java.io.Serializable;
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
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Vuk
 */
@Entity
@Table(name = "model")
@NamedQueries({
    @NamedQuery(name = "Model.findAll", query = "SELECT m FROM Model m")})
public class Model implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MODEL_ID")
    private Integer modelId;
    @Basic(optional = false)
    @Column(name = "MODEL_IME")
    private String modelIme;
    @Basic(optional = false)
    @Column(name = "MODEL_KUBLIKAZA")
    private int modelKublikaza;
    @Basic(optional = false)
    @Column(name = "MODEL_GODINA")
    private int modelGodina;
    @Column(name = "MODEL_OPREMA")
    private String modelOprema;
    @JoinColumn(name = "MARKA_ID", referencedColumnName = "MARKA_ID")
    @ManyToOne
    private Marka markaId;

    @Inject
    public Model() {
    }

    public Model(Integer modelId) {
        this.modelId = modelId;
    }

    public Model(Integer modelId, String modelIme, int modelKublikaza, int modelGodina) {
        this.modelId = modelId;
        this.modelIme = modelIme;
        this.modelKublikaza = modelKublikaza;
        this.modelGodina = modelGodina;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getModelIme() {
        return modelIme;
    }

    public void setModelIme(String modelIme) {
        this.modelIme = modelIme;
    }

    public int getModelKublikaza() {
        return modelKublikaza;
    }

    public void setModelKublikaza(int modelKublikaza) {
        this.modelKublikaza = modelKublikaza;
    }

    public int getModelGodina() {
        return modelGodina;
    }

    public void setModelGodina(int modelGodina) {
        this.modelGodina = modelGodina;
    }

    public String getModelOprema() {
        return modelOprema;
    }

    public void setModelOprema(String modelOprema) {
        this.modelOprema = modelOprema;
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
        hash += (modelId != null ? modelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Model)) {
            return false;
        }
        Model other = (Model) object;
        if ((this.modelId == null && other.modelId != null) || (this.modelId != null && !this.modelId.equals(other.modelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return modelIme;
    }

}
