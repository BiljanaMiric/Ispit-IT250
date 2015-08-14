/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.it250ispitjuna.pages;

import com.metropolitan.it250ispitjuna.dao.MarkaModelDao;
import com.metropolitan.it250ispitjuna.entities.Automobil;
import com.metropolitan.it250ispitjuna.entities.Model;
import com.metropolitan.it250ispitjuna.entities.Servis;
import com.metropolitan.it250ispitjuna.services.ProtectedPage;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author BASKETBALL IN HEART
 */
@ProtectedPage
@RolesAllowed(value = {"ADMIN"})
public class DodavanjeServisa {

    @Property
    private Servis servis;
    
    @Property
    private Automobil automobil;

    @Inject
    private MarkaModelDao markaDao;
    @Persist
    @Property
    private List<Servis> listaServisa;

    void onActivate() {
        listaServisa = markaDao.listaServisa();
    }

    @CommitAfter
    Object onActionFromServis() {
        servis.setAutomobilId(automobil);
        markaDao.dodajServis(servis);
        return this;
    }
}
