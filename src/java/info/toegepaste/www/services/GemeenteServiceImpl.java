/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.services;

import info.toegepaste.www.models.*;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Bruno
 */
public class GemeenteServiceImpl implements GemeenteService, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

//    @Inject
//    private GemeenteService gemeenteService;
    @Override
    public List<Gemeente> getAllGemeentes() {
        Query query = entityManager.createNamedQuery("Gemeente.getAll");
        return query.getResultList();
    }

    @Override
    public List<Gemeente> getAllGemeentesVanLand(Land land) {
        Query query = entityManager.createNamedQuery("Gemeente.getAllFromLand");
        query.setParameter("land", land);
        return query.getResultList();
    }

    @Override
    public List<Gemeente> getAllBestemmingenFromContinent(Continent continent) {
        Query query = entityManager.createNamedQuery("Gemeente.getAllBestemmingenFromContinent");
        query.setParameter("continent", continent);
        return query.getResultList();
    }
    
    public Gemeente getGemeente(Gemeente gemeente) {
        Query query = entityManager.createNamedQuery("Gemeente.getGemeente");
        query.setParameter("gemeenteId", gemeente.getId());
        return (Gemeente) query.getSingleResult();
    }

    @Override
    public List<Gemeente> getAllBestemmingen() {
        Query query = entityManager.createNamedQuery("Gemeente.getAllBestemmingen");;
        return query.getResultList();
    }

    @Override
    public List<Gemeente> getAllNietBestemmingen() {
        Query query = entityManager.createNamedQuery("Gemeente.getAllNietBestemmingen");
        return query.getResultList();
    }
}
