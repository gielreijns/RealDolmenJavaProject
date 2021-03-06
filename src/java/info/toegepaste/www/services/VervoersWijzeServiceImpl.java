/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.services;

import info.toegepaste.www.models.Vervoerswijze;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Bruno
 */
public class VervoersWijzeServiceImpl implements VervoerswijzeService, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Vervoerswijze> getAllVervoerswijzen() {
        Query query = entityManager.createNamedQuery("Vervoerswijze.getAll");
        return query.getResultList();
    }
    
    public Vervoerswijze getVervoerswijze(Vervoerswijze vervoerswijze) {
        Query query = entityManager.createNamedQuery("Vervoerswijze.getVervoerswijze");
        query.setParameter("vervoerswijzeId", vervoerswijze.getId());
        return (Vervoerswijze) query.getSingleResult();
    }
}
