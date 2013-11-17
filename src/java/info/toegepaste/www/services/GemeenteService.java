/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.services;

import info.toegepaste.www.models.*;
import java.util.List;

/**
 *
 * @author Bruno
 */
public interface GemeenteService {

    public List<Gemeente> getAllGemeentes();

    public List<Gemeente> getAllGemeentesVanLand(Land land);

    public List<Gemeente> getAllBestemmingen();

    public List<Gemeente> getAllNietBestemmingen();
    
    public List<Gemeente> getAllBestemmingenFromContinent(Continent continent);
    
    public Gemeente getGemeente(Gemeente gemeente);
}
