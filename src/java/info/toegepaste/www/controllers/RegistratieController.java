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
