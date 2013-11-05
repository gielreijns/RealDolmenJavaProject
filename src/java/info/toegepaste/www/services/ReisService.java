/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.services;

import info.toegepaste.www.models.Gemeente;
import info.toegepaste.www.models.Reis;
import info.toegepaste.www.models.Vervoerswijze;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bruno
 */
public interface ReisService {

    public List<Reis> getAllReizen();

    public List<Reis> getReisByGemeente(Gemeente gemeente);

    public List<Reis> getReisByAantalPlaatsen(Integer aantalPlaatsen);

    public List<Reis> getReisByVervoerswijze(Vervoerswijze vervoerswijze);

    public List<Reis> getReisByVertrekdatum(Date vertrekdatum);

    public List<Reis> getReisByTerugkeerdatum(Date terugkeerdatum);

    public List<Reis> getReisByReisPeriode(Date vertrekdatum, Date terugkeerdatum);
    
    public List<Reis> getReisByAllZoekParameters(Gemeente gemeente, Integer aantalPlaatsen, Vervoerswijze vervoerswijze, Date vertrekdatum, Date terugkeerdatum);
}
