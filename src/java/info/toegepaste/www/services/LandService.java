/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.services;

import info.toegepaste.www.models.Continent;
import info.toegepaste.www.models.Gemeente;
import info.toegepaste.www.models.Land;
import java.util.List;

/**
 *
 * @author Bruno
 */
public interface LandService {

    public List<Land> getAllLanden();
    
    public List<Land> getAllLandenByContinent(Continent continent);
    
    public Land getLand(Land land);
}
