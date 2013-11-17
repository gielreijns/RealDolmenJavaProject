/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package info.toegepaste.www.services;

import info.toegepaste.www.models.Gemeente;
import info.toegepaste.www.models.Reis;
import info.toegepaste.www.models.Vervoerswijze;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Bruno
 */


public class ReisServiceImpl implements ReisService, Serializable {
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Reis> getAllReizen() {
        Query query = entityManager.createNamedQuery("Reis.getAll");
        return query.getResultList();
    }
    
    @Override
    public List<Reis> getReisByGemeente(Gemeente gemeente) {
        Query query = entityManager.createNamedQuery("Reis.getByGemeente");
        query.setParameter("gemeente", gemeente);
        return query.getResultList();
    }
    
    @Override
    public List<Reis> getReisByAantalPlaatsen(Integer aantalPlaatsen) {
        Query query = entityManager.createNamedQuery("Reis.getByAantalPlaatsen");
        query.setParameter("aantalPlaatsen", aantalPlaatsen);
        return query.getResultList();
    }
    
    @Override
    public List<Reis> getReisByVervoerswijze(Vervoerswijze vervoerswijze) {
        Query query = entityManager.createNamedQuery("Reis.getByVervoerswijze");
        query.setParameter("vervoerswijze", vervoerswijze);
        return query.getResultList();
    }
    
    @Override
    public List<Reis> getReisByVertrekdatum(GregorianCalendar vertrekdatum) {
        Query query = entityManager.createNamedQuery("Reis.getByVertrekdatum");
        query.setParameter("vertrekdatum", vertrekdatum);
        return query.getResultList();
    }
    
    @Override
    public List<Reis> getReisByTerugkeerdatum(GregorianCalendar terugkeerdatum) {
        Query query = entityManager.createNamedQuery("Reis.getTerugkeerdatum");
        query.setParameter("terugkeerdatum", terugkeerdatum);
        return query.getResultList();
    }
    
    @Override
    public List<Reis> getReisByReisPeriode(GregorianCalendar vertrekdatum, GregorianCalendar terugkeerdatum) {
        Query query = entityManager.createNamedQuery("Reis.getByReisPeriode");
        query.setParameter("vertrekdatum", vertrekdatum);
        query.setParameter("terugkeerdatum", terugkeerdatum);
        return query.getResultList();
    }
    
    @Override
    public List<Reis> getReisByAllZoekParameters(Gemeente gemeente, Integer aantalPlaatsen, Vervoerswijze vervoerswijze) {
        Query query = entityManager.createNamedQuery("Reis.getByAllZoekParameters");
        query.setParameter("gemeente", gemeente);
        query.setParameter("aantalPlaatsen", aantalPlaatsen);
        query.setParameter("vervoerswijze", vervoerswijze);
        
        return query.getResultList();
    }
}
