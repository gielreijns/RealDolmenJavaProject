package info.toegepaste.www.controllers;

import info.toegepaste.www.models.Gemeente;
import info.toegepaste.www.models.Reis;
import info.toegepaste.www.models.Vervoerswijze;
import info.toegepaste.www.services.GemeenteService;
import info.toegepaste.www.services.ReisService;
import info.toegepaste.www.services.VervoerswijzeService;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
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
    private String gemeenteNaam;
    private Integer aantalPlaatsen;
    private String vervoerswijzeNaam;
    private GregorianCalendar vertrekdatum;
    private GregorianCalendar terugkeerdatum;
    private Reis reis;
    private List<Reis> gevondenReizen;
    private List<Gemeente> bestemmingen;

    
    public List<Reis> getGevondenReizen() {
        return gevondenReizen;
    }

    public void setGevondenReizen(List<Reis> gevondenReizen) {
        this.gevondenReizen = gevondenReizen;
    }
    
    public String getVervoerswijzeNaam() {
        return vervoerswijzeNaam;
    }

    public void setVervoerswijzeNaam(String vervoerswijzeNaam) {
        this.vervoerswijzeNaam = vervoerswijzeNaam;
    }

    public String getGemeenteNaam() {
        return gemeenteNaam;
    }

    public void setGemeenteNaam(String gemeenteNaam) {
        this.gemeenteNaam = gemeenteNaam;
    }

    public Integer getAantalPlaatsen() {
        return aantalPlaatsen;
    }

    public void setAantalPlaatsen(Integer aantalPlaatsen) {
        this.aantalPlaatsen = aantalPlaatsen;
    }

    public GregorianCalendar getVertrekdatum() {
        return vertrekdatum;
    }

    public void setVertrekdatum(GregorianCalendar vertrekdatum) {
        this.vertrekdatum = vertrekdatum;
    }

    public GregorianCalendar getTerugkeerdatum() {
        return terugkeerdatum;
    }

    public void setTerugkeerdatum(GregorianCalendar terugkeerdatum) {
        this.terugkeerdatum = terugkeerdatum;
    }

   

    

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
    public String zoeken() {
        gemeente = new Gemeente();
        gemeente.setNaam(gemeenteNaam);
        
        //eerst enkel zoeken op gemeente om te testen
        gevondenReizen = reisService.getReisByGemeente(gemeente);
        //gevondenReizen = reisService.getReisByAllZoekParameters(gemeente, aantalPlaatsen, vervoerswijze, vertrekdatum, terugkeerdatum);
        return "zoekResultaten.xhtml";
    }
}
