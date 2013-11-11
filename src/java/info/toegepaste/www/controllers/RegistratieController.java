/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package info.toegepaste.www.controllers;

import info.toegepaste.www.models.Gemeente;
import info.toegepaste.www.services.GemeenteService;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Bruno
 */
@Named
@RequestScoped
public class RegistratieController implements Serializable{
    
    
    @Inject
    private GemeenteService gemeenteService;
    @Inject
    private RegistratieController registratieController;
    private Integer selectedGemeenteId;
    private String voornaam;
    private String naam;
    private Integer telefoon;
    private String straat;
    private String straatnummer;
    private String email;
    private String wachtwoord;

    public GemeenteService getGemeenteService() {
        return gemeenteService;
    }

    public void setGemeenteService(GemeenteService gemeenteService) {
        this.gemeenteService = gemeenteService;
    }

    public RegistratieController getRegistratieController() {
        return registratieController;
    }

    public void setRegistratieController(RegistratieController registratieController) {
        this.registratieController = registratieController;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Integer getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(Integer telefoon) {
        this.telefoon = telefoon;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getStraatnummer() {
        return straatnummer;
    }

    public void setStraatnummer(String straatnummer) {
        this.straatnummer = straatnummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }
    

    public Integer getSelectedGemeenteId() {
        return selectedGemeenteId;
    }

    public void setSelectedGemeenteId(Integer selectedGemeenteId) {
        this.selectedGemeenteId = selectedGemeenteId;
        
    }
        
    public List<Gemeente> getGemeentes(){
        return gemeenteService.getAllGemeentes();
    }
    
    
    
    
}
