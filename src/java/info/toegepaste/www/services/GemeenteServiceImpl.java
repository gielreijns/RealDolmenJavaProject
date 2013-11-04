/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package info.toegepaste.www.services;

import info.toegepaste.www.models.Gemeente;
import info.toegepaste.www.models.Land;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author Bruno
 */
public class GemeenteServiceImpl implements GemeenteService {
    @PersistenceContext
    private EntityManager entityManager;
    private List resultList;
    
//    @Inject
//    private GemeenteService gemeenteService;
    
    @Override
    public List<Gemeente> getAllGemeentes() {
        Query query = entityManager.createNamedQuery("Gemeente.getAll");
        resultList = query.getResultList();
        return resultList;
    }
    
    @Override
    public List<Gemeente> getAllGemeentesByLand(Land land) {
        Query query = entityManager.createNamedQuery("Gemeente.getAllByLand");
        query.setParameter("land", land);
        return query.getResultList();
    }
}
