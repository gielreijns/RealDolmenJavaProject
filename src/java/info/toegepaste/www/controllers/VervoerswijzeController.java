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
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Bruno
 */
@Named
public class VervoerswijzeController implements Serializable{
    
    @Inject
    private VervoerswijzeController vervoerswijzeController;
    @Inject
    private VervoerswijzeService vervoerswijzeService;
    
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
