/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.services;

import info.toegepaste.www.models.Gebruiker;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Bruno
 */
public class GebruikerServiceImpl implements GebruikerService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Gebruiker checkLogin(Gebruiker gebruiker) {
        Query query = entityManager.createNamedQuery("Gebruiker.checkLogin");
        query.setParameter("email", gebruiker.getEmail());
        query.setParameter("wachtwoord", gebruiker.getWachtwoord());
        return (Gebruiker) query.getSingleResult();
    }
}
