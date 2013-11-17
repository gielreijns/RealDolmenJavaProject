/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package info.toegepaste.www.controllers;

import info.toegepaste.www.models.*;
import info.toegepaste.www.services.*;
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
public class BestemmingController implements Serializable{
    @Inject
    private BestemmingController bestemmingController;
    @Inject
    private ContinentService continentService;

    public ContinentService getContinentService() {
        return continentService;
    }

    public void setContinentService(ContinentService continentService) {
        this.continentService = continentService;
    }
    

    public BestemmingController getBestemmingController() {
        return bestemmingController;
    }

    public void setBestemmingController(BestemmingController bestemmingController) {
        this.bestemmingController = bestemmingController;
    }

    
  
}
