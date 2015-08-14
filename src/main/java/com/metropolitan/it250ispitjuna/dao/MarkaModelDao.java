package com.metropolitan.it250ispitjuna.dao;

import com.metropolitan.it250ispitjuna.entities.Automobil;
import com.metropolitan.it250ispitjuna.entities.Korisnik;
import com.metropolitan.it250ispitjuna.entities.Marka;
import com.metropolitan.it250ispitjuna.entities.Model;
import com.metropolitan.it250ispitjuna.entities.Servis;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Vuk
 */
public interface MarkaModelDao {

    public void dodajMarku(Marka marka);

    public void dodajModel(Model model);

    public List<Marka> listaMarki();
    
    public List<Automobil> listaAuta();
    
    public List<Servis> listaServisa();

    public List<Model> listaModela();

    public void deleteMarka(Integer id);

    public void updateMarka(Marka auto);

    public void deleteModel(Integer id);

    public void updateModel(Model auto);

    public Marka getMarkaById(Integer id);
    
    public Automobil getAutoById(Integer id);

    public void dodajServis(Servis servis);

    public void deleteServis(Integer id);
    
    public List<Automobil> getAutoPoId(Korisnik id);

}
