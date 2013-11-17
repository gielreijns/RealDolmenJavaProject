package info.toegepaste.www.controllers;

import info.toegepaste.www.models.Gemeente;
import info.toegepaste.www.models.Land;
import info.toegepaste.www.models.Reis;
import info.toegepaste.www.models.Vervoerswijze;
import info.toegepaste.www.services.GemeenteService;
import info.toegepaste.www.services.LandService;
import info.toegepaste.www.services.ReisService;
import info.toegepaste.www.services.VervoerswijzeService;
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
    @Inject
    private VervoerswijzeService vervoerswijzeService;
    @Inject
    private LandService landService;
    
    private Reis reis;
    private Gemeente vertrekplaats;
    private Gemeente bestemming;
    private Vervoerswijze vervoerswijze;
    private Land vertrekLand;
    private Land aankomstLand;

    public Land getVertrekLand() {
        return vertrekLand;
    }

    public void setVertrekLand(Land vertrekLand) {
        this.vertrekLand = vertrekLand;
    }

    public Land getAankomstLand() {
        return aankomstLand;
    }

    public void setAankomstLand(Land aankomstLand) {
        this.aankomstLand = aankomstLand;
    }

    public LandService getLandService() {
        return landService;
    }

    public void setLandService(LandService landService) {
        this.landService = landService;
    }

    public VervoerswijzeService getVervoerswijzeService() {
        return vervoerswijzeService;
    }

    public void setVervoerswijzeService(VervoerswijzeService vervoerswijzeService) {
        this.vervoerswijzeService = vervoerswijzeService;
    }
    
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
        vertrekLand = landService.getLand(gemeente.getLand());
        
        gemeente = reis.getGemeente();
        bestemming = gemeenteService.getGemeente(gemeente);
        aankomstLand = landService.getLand(gemeente.getLand());
        
        vervoerswijze = vervoerswijzeService.getVervoerswijze(reis.getVervoerswijze());
        
        return "reisDetails.xhtml";
    }
}

