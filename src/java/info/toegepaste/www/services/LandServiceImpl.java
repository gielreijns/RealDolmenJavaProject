/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package info.toegepaste.www.services;

import info.toegepaste.www.model.Land;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Bruno
 */
public class LandServiceImpl implements LandService {
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Land> getAllLanden() {
        Query query = entityManager.createNamedQuery("Land.getAll");
        return query.getResultList();
    }
}
