/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.services;

import info.toegepaste.www.models.Continent;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Bruno
 */
public class ContinentServiceImpl implements ContinentService, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Continent> getAllContinenten() {
        Query query = entityManager.createNamedQuery("Continent.getAll");
        return query.getResultList();
    }
    @Override
    public List<Continent> getAllContinentenWithBestemming() {
        Query query = entityManager.createNamedQuery("Continent.getAllWithBestemming");
        return query.getResultList();
    }
}
