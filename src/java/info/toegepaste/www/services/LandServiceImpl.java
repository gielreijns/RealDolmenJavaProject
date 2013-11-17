/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.services;

import info.toegepaste.www.models.Continent;
import info.toegepaste.www.models.Gemeente;
import info.toegepaste.www.models.Land;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Bruno
 */
public class LandServiceImpl implements LandService, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Land> getAllLanden() {
        Query query = entityManager.createNamedQuery("Land.getAll");
        return query.getResultList();
    }

    @Override
    public List<Land> getAllLandenByContinent(Continent continent) {
        Query query = entityManager.createNamedQuery("Land.getAllByContinent");
        query.setParameter("continent", continent);
        return query.getResultList();
    }
    
   @Override
   public Land getLand(Land land) {
       Query query = entityManager.createNamedQuery("Land.getLand");
        query.setParameter("landId", land.getId());
        return (Land) query.getSingleResult();
   }
}
