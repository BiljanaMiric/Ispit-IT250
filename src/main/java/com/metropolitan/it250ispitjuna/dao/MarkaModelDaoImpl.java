/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.it250ispitjuna.dao;

import com.metropolitan.it250ispitjuna.entities.Automobil;
import com.metropolitan.it250ispitjuna.entities.Korisnik;
import com.metropolitan.it250ispitjuna.entities.Marka;
import com.metropolitan.it250ispitjuna.entities.Model;
import com.metropolitan.it250ispitjuna.entities.Servis;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Vuk
 */
public class MarkaModelDaoImpl implements MarkaModelDao {

    @Inject
    private Session session;

    @Override
    public void dodajMarku(Marka marka) {
        session.merge(marka);
    }

    @Override
    public List<Marka> listaMarki() {
        return session.createCriteria(Marka.class).list();
    }

    @Override
    public void dodajModel(Model model) {
        session.merge(model);
    }

    @Override
    public List<Model> listaModela() {
        return session.createCriteria(Model.class).list();
    }

    @Override
    public void deleteMarka(Integer id) {
        Marka k = (Marka) session.createCriteria(Marka.class).add(Restrictions.eq("id", id)).uniqueResult();
        session.delete(k);
    }

    @Override
    public void updateMarka(Marka auto) {
        session.merge(auto);
    }

    @Override
    public void deleteModel(Integer id) {
        Model k = (Model) session.createCriteria(Model.class).add(Restrictions.eq("id", id)).uniqueResult();
        session.delete(k);
    }

    @Override
    public void updateModel(Model model) {
        session.merge(model);
    }
    @Override
    public Marka getMarkaById(Integer id) {
        return (Marka) session.createCriteria(Marka.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public void dodajServis(Servis servis) {
        session.merge(servis);
    }

    @Override
    public void deleteServis(Integer id) {
        Servis k = (Servis) session.createCriteria(Servis.class).add(Restrictions.eq("id", id)).uniqueResult();
        session.delete(k);
    }

    @Override
    public List<Servis> listaServisa() {
        return session.createCriteria(Servis.class).list();
    }
    
    @Override
    public List<Automobil> listaAuta() {
        return session.createCriteria(Automobil.class).list();
    }
    
    @Override
    public Automobil getAutoById(Integer id) {
        return (Automobil) session.createCriteria(Automobil.class).add(Restrictions.eq("id", id)).uniqueResult();
    }
    
    @Override
    public List<Automobil> getAutoPoId(Korisnik id) {
        return session.createCriteria(Servis.class).add(Restrictions.eq("korisnikId", id)).list();
    }

}
