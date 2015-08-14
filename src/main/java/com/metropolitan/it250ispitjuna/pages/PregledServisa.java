/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.it250ispitjuna.pages;

import com.metropolitan.it250ispitjuna.dao.MarkaModelDao;
import com.metropolitan.it250ispitjuna.entities.Automobil;
import com.metropolitan.it250ispitjuna.entities.Korisnik;
import com.metropolitan.it250ispitjuna.entities.Marka;
import com.metropolitan.it250ispitjuna.entities.Servis;
import com.metropolitan.it250ispitjuna.services.ProtectedPage;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author BASKETBALL IN HEART
 */
@ProtectedPage
@RolesAllowed(value = {"ADMIN"})
public class PregledServisa {

    @Property
    @SessionState
    private Korisnik loggedInUser;

    @Property
    private Automobil auto;

    @Inject
    private MarkaModelDao markaDao;

    @Property
    private List<Automobil> listaAuta;

    void onActivate() {
        listaAuta = markaDao.getAutoPoId(loggedInUser);
    }

    public ValueEncoder getEncoder() {
        return new ValueEncoder<Automobil>() {
            @Override
            public String toClient(Automobil v) {
                return String.valueOf(v.getAutomobilId()); // pazi ovde
            }

            @Override
            public Automobil toValue(String string) {
                Automobil drz = markaDao.getAutoById(Integer.parseInt(string));
                return drz;
            }
        };
    }

}
