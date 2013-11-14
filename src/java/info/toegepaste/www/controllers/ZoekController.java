package info.toegepaste.www.controllers;

import info.toegepaste.www.models.Gemeente;
import info.toegepaste.www.models.Reis;
import info.toegepaste.www.models.Vervoerswijze;
import info.toegepaste.www.services.GemeenteService;
import info.toegepaste.www.services.ReisService;
import info.toegepaste.www.services.VervoerswijzeService;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Bruno
 */
@Named
@RequestScoped
public class ZoekController implements Serializable{
    @Inject
    private ZoekController zoekController;
    @Inject
    private GemeenteService gemeenteService;
    @Inject
    private ReisService reisService;
    
    @Inject
    private VervoerswijzeService vervoerswijzeService;
    private Integer selectedVervoerswijzeId;
    private Vervoerswijze vervoerswijze;
    private Gemeente gemeente;
    private Reis reis;
    private List<Gemeente> bestemmingen;

    public VervoerswijzeService getVervoerswijzeService() {
        return vervoerswijzeService;
    }

    public void setVervoerswijzeService(VervoerswijzeService vervoerswijzeService) {
        this.vervoerswijzeService = vervoerswijzeService;
    }

    public Integer getSelectedVervoerswijzeId() {
        return selectedVervoerswijzeId;
    }

    public void setSelectedVervoerswijzeId(Integer selectedVervoerswijzeId) {
        this.selectedVervoerswijzeId = selectedVervoerswijzeId;
    }

    public Vervoerswijze getVervoerswijze() {
        return vervoerswijze;
    }

    public void setVervoerswijze(Vervoerswijze vervoerswijze) {
        this.vervoerswijze = vervoerswijze;
    }
    
    
    
    public List<Vervoerswijze> getVervoerswijzen() {
        return vervoerswijzeService.getAllVervoerswijzen();
    }
    public Reis getReis() {
        return reis;
    }

    public void setReis(Reis reis) {
        this.reis = reis;
    }

    public ReisService getReisService() {
        return reisService;
    }

    public void setReisService(ReisService reisService) {
        this.reisService = reisService;
    }

    public Gemeente getGemeente() {
        return gemeente;
    }

    public void setGemeente(Gemeente gemeente) {
        this.gemeente = gemeente;
    }

    public List<Gemeente> getBestemmingen() {
        return bestemmingen;
    }

    public void setBestemmingen(List<Gemeente> bestemmingen) {
        this.bestemmingen = bestemmingen;
    }

    public ZoekController getZoekController() {
        return zoekController;
    }

    public void setZoekController(ZoekController zoekController) {
        this.zoekController = zoekController;
    }

    public GemeenteService getGemeenteService() {
        return gemeenteService;
    }

    public void setGemeenteService(GemeenteService gemeenteService) {
        this.gemeenteService = gemeenteService;
    }
    
    public List<Gemeente> getAlleBestemmingen() {
        return gemeenteService.getAllBestemmingen();
    }
    
    public List<Reis> getReisByBestemming() {
        return reisService.getReisByGemeente(gemeente);
    }
}
