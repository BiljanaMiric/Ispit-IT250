/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.it250ispitjuna.pages;

import com.metropolitan.it250ispitjuna.dao.MarkaModelDao;
import com.metropolitan.it250ispitjuna.entities.Marka;
import com.metropolitan.it250ispitjuna.entities.Model;
import com.metropolitan.it250ispitjuna.services.ProtectedPage;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;

/**
 *
 * @author Vuk
 */
@ProtectedPage
@RolesAllowed(value = {"ADMIN"})
public class DodavanjeMarke {

    @Property
    private Marka marka;

    @Property
    private Model model;
    @Property
    private Marka onemarka;

    @Property
    private Model onemodel;

    @Inject
    private MarkaModelDao markaDao;

    @Property
    private List<Marka> listaMarki;

    @Property
    private List<Model> listaModela;
    @InjectComponent
    private Zone zoneAuto;
    @InjectComponent
    private Zone formZone;
    @Inject
    private Request request;
    @Inject
    private AjaxResponseRenderer ajaxResponseRenderer;
    @Inject
    private ComponentResources _componentResources;
    

    void onActivate() {
        listaMarki = markaDao.listaMarki();
        listaModela = markaDao.listaModela();
    }

    @CommitAfter
    Object onSuccess() {
        markaDao.updateMarka(marka);
        marka = new Marka();
        listaMarki = markaDao.listaMarki();
        if (request.isXHR()) {
            ajaxResponseRenderer.addRender(zoneAuto).addRender(formZone);
        }
        return request.isXHR() ? zoneAuto.getBody() : null;
    }
    @CommitAfter
    Object onActionFromDeleteMarka(int id) {
        markaDao.deleteMarka(id);
        listaMarki = markaDao.listaMarki();
        return request.isXHR() ? zoneAuto.getBody() : null;
    }

    @CommitAfter
    Object onActionFromEditMarka(Marka autoUpdate) {
        marka = autoUpdate;
        return request.isXHR() ? formZone.getBody() : null;
    }
    
    public JSONObject getOptions() { 
        JSONObject json = new JSONObject();
    json.put("bJQueryUI", "true"); 
    json.put("bStateSave", true); 
    json.put("bAutoWidth", true); 
    return json;
}
    }

