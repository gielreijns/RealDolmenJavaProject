/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.services;

import info.toegepaste.www.models.Continent;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Bruno
 */
public class ContinentServiceImpl implements ContinentService {

    @PersistenceContext
    private EntityManager entityManager;
    private List resultList;

    @Override
    public List<Continent> getAllContinenten() {
        Query query = entityManager.createNamedQuery("Continent.getAll");
        resultList = query.getResultList();
        return resultList;
    }
}
