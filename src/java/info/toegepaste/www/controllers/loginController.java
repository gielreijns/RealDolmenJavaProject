package info.toegepaste.www.controllers;

import info.toegepaste.www.models.*;
import info.toegepaste.www.services.*;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.Session;

/**
 *
 * @author Bruno
 */
@Named
@SessionScoped
public class loginController implements Serializable {

    @Inject
    private GemeenteService gemeenteService;
    @Inject
    private LandService landService;
    @Inject
    private GebruikerService gebruikerService;
    @Inject
    private loginController loginController;
    private Gebruiker gebruiker;
    private boolean loggedIn;
    private String email, wachtwoord;
    private String naam;

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
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

    public GemeenteService getGemeenteService() {
        return gemeenteService;
    }

    public void setGemeenteService(GemeenteService gemeenteService) {
        this.gemeenteService = gemeenteService;
    }

    public LandService getLandService() {
        return landService;
    }

    public void setLandService(LandService landService) {
        this.landService = landService;
    }

    public GebruikerService getGebruikerService() {
        return gebruikerService;
    }

    public void setGebruikerService(GebruikerService gebruikerService) {
        this.gebruikerService = gebruikerService;
    }

    public loginController getLoginController() {
        return loginController;
    }

    public void setLoginController(loginController loginController) {
        this.loginController = loginController;
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    public String login() {
        Gebruiker gebruiker2 = new Gebruiker();
        gebruiker2.setEmail(email);
        gebruiker2.setWachtwoord(wachtwoord);


        gebruiker = gebruikerService.checkLogin(gebruiker2);
        if (gebruiker.getId() != 0) {
            loggedIn = true;
            naam = gebruiker.getVoornaam() + " " + gebruiker.getNaam();
        } else {
            loggedIn = false;
        }
        return "index.xhtml";
    }

    public String logout() {
        gebruiker = new Gebruiker();
        loggedIn = false;
        return "index.xhtml";
    }
}
