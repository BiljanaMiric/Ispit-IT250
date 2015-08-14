/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.it250ispitjuna.pages;

import com.metropolitan.it250ispitjuna.dao.UserDao;
import com.metropolitan.it250ispitjuna.data.Role;
import com.metropolitan.it250ispitjuna.entities.Korisnik;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Vuk
 */
public class RegistracijaKorisnika {

    @Property
    private Korisnik userReg;
    @SessionState
    private Korisnik loggedInUser;
    @Inject
    private UserDao userDao;
    @Component
    private BeanEditForm form;

    public String getMD5Hash(String yourString) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(yourString.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }

    @CommitAfter
    Object onSuccess() {
        if (!userDao.checkIfUsernameExists(userReg.getKorisnikUsername())) {
            String unhashPassword = userReg.getKorisnikPassword();
            userReg.setKorisnikPassword(getMD5Hash(unhashPassword));
            userReg.setKorisnikRola(Role.KORISNIK);
            Korisnik u = userDao.registerUser(userReg);
            loggedInUser = u;
            return Index.class;
        } else {
            form.recordError("Email koji ste uneli vec postoji");
            return null;
        }
    }
}
