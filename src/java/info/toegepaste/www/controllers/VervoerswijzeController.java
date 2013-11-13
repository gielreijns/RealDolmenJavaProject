/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package info.toegepaste.www.controllers;

import info.toegepaste.www.models.Vervoerswijze;
import info.toegepaste.www.services.VervoerswijzeService;
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
public class VervoerswijzeController implements Serializable{
    
    @Inject
    private VervoerswijzeController vervoerswijzeController;
    @Inject
    private VervoerswijzeService vervoerswijzeService;
    private Integer selectedVervoerswijzeId;
    private Vervoerswijze vervoerswijze;

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
    
    public VervoerswijzeController getVervoerswijzeController() {
        return vervoerswijzeController;
    }

    public void setVervoerswijzeController(VervoerswijzeController vervoerswijzeController) {
        this.vervoerswijzeController = vervoerswijzeController;
    }
    
    public List<Vervoerswijze> getVervoerswijzen() {
        return vervoerswijzeService.getAllVervoerswijzen();
    }
}
