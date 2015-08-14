/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.it250ispitjuna.dao;

import com.metropolitan.it250ispitjuna.entities.Korisnik;


/**
 *
 * @author Vuk
 */
public interface UserDao {

    public Korisnik checkUser(String username, String password);

    public Korisnik registerUser(Korisnik user);

    public boolean checkIfUsernameExists(String username);
}
