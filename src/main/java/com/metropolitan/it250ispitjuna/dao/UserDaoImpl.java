/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.it250ispitjuna.dao;

import com.metropolitan.it250ispitjuna.entities.Korisnik;
import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Vuk
 */
public class UserDaoImpl implements UserDao {

    @Inject
    private Session session;

    @Override
    public Korisnik checkUser(String email, String password) {
        try {
            Korisnik u = (Korisnik) session.createCriteria(Korisnik.class).add(Restrictions.eq("korisnikUsername",
                    email)).add(Restrictions.eq("korisnikPassword", password)).uniqueResult();
            if (u != null) {
                return u;
            }
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public Korisnik registerUser(Korisnik user) {
        return (Korisnik) session.merge(user);
    }

    @Override
    public boolean checkIfUsernameExists(String username) {
        Long rows = (Long) session.createCriteria(Korisnik.class).add(Restrictions.eq("korisnikUsername",
                username)).setProjection(Projections.rowCount()).uniqueResult();
        return (rows == 0) ? false : true;
    }

}
