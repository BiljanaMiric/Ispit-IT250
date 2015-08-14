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
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;

/**
 *
 * @author BASKETBALL IN HEART
 */
@ProtectedPage
@RolesAllowed(value = {"ADMIN"})
public class DodavanjeModela {

    @Property
    private Marka marka;
    @Property
    private Marka markaId;
    @Property
    private Model model;
    @Property
    private Marka onemarka;

    @Property
    private Model onemodel;

    @Inject
    private MarkaModelDao markaDao;
    @Persist
    @Property
    private List<Marka> listaMarki;
    @Persist
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

    public ValueEncoder getEncoder() {
        return new ValueEncoder<Marka>() {
            @Override
            public String toClient(Marka v) {
                return String.valueOf(v.getMarkaId()); // pazi ovde
            }

            @Override
            public Marka toValue(String string) {
                Marka drz = markaDao.getMarkaById(Integer.parseInt(string));
                return drz;
            }
        };
    }

    void onActivate() {
        listaMarki = markaDao.listaMarki();
        System.out.println("lista = " + listaMarki.size());
        listaModela = markaDao.listaModela();
    }

    @CommitAfter
    Object onActionFromModel() {
        model.setMarkaId(marka);
        markaDao.updateModel(model);
        model = new Model();
        listaModela = markaDao.listaModela();
        if (request.isXHR()) {
            ajaxResponseRenderer.addRender(zoneAuto).addRender(formZone);
        }
        return request.isXHR() ? zoneAuto.getBody() : null;
    }

    @CommitAfter
    Object onActionFromDelete(int id) {
        markaDao.deleteModel(id);
        listaModela = markaDao.listaModela();
        return request.isXHR() ? zoneAuto.getBody() : null;
    }

    @CommitAfter
    Object onActionFromEdit(Model autoUpdate) {
        model = autoUpdate;
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

