/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package info.toegepaste.www.controllers;

import info.toegepaste.www.models.Gemeente;
import info.toegepaste.www.models.Reis;
import info.toegepaste.www.models.Vervoerswijze;
import info.toegepaste.www.services.GemeenteService;
import info.toegepaste.www.services.ReisService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Bruno
 */
@Named
@SessionScoped
public class DetailController implements Serializable{
    @Inject
    private DetailController detailController;
    @Inject
    private GemeenteService gemeenteService;
    @Inject
    private ReisService reisService;
    
    private Reis reis;
    private Gemeente vertrekplaats;
    private Gemeente bestemming;
    private Vervoerswijze vervoerswijze;

    public DetailController getDetailController() {
        return detailController;
    }

    public void setDetailController(DetailController detailController) {
        this.detailController = detailController;
    }

    public GemeenteService getGemeenteService() {
        return gemeenteService;
    }

    public void setGemeenteService(GemeenteService gemeenteService) {
        this.gemeenteService = gemeenteService;
    }

    public ReisService getReisService() {
        return reisService;
    }

    public void setReisService(ReisService reisService) {
        this.reisService = reisService;
    }

    public Reis getReis() {
        return reis;
    }

    public void setReis(Reis reis) {
        this.reis = reis;
    }

    public Gemeente getVertrekplaats() {
        return vertrekplaats;
    }

    public void setVertrekplaats(Gemeente vertrekplaats) {
        this.vertrekplaats = vertrekplaats;
    }

    public Gemeente getBestemming() {
        return bestemming;
    }

    public void setBestemming(Gemeente bestemming) {
        this.bestemming = bestemming;
    }

    public Vervoerswijze getVervoerswijze() {
        return vervoerswijze;
    }

    public void setVervoerswijze(Vervoerswijze vervoerswijze) {
        this.vervoerswijze = vervoerswijze;
    }
    
    public String reisDetailsZoeken(Reis reis) {
        Gemeente gemeente = new Gemeente();
        
        this.reis = reis;
        gemeente = reis.getVertrekplaats();
        vertrekplaats = gemeenteService.getGemeente(gemeente);
        
        gemeente = reis.getGemeente();
        bestemming = gemeenteService.getGemeente(gemeente);
        
        return "reisDetails.xhtml";
    }
}
