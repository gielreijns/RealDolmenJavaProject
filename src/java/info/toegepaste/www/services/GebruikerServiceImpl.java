/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.services;

import info.toegepaste.www.models.Gebruiker;
import java.io.Serializable;
import java.util.List;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Bruno
 */
public class GebruikerServiceImpl implements GebruikerService, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Gebruiker checkLogin(Gebruiker gebruiker) {
        Query query = entityManager.createNamedQuery("Gebruiker.checkLoginCount");
        query.setParameter("email", gebruiker.getEmail());
        query.setParameter("wachtwoord", gebruiker.getWachtwoord());
        if ((long) query.getSingleResult() == 1) {
            query = entityManager.createNamedQuery("Gebruiker.checkLogin");
            query.setParameter("email", gebruiker.getEmail());
            query.setParameter("wachtwoord", gebruiker.getWachtwoord());
            return (Gebruiker) query.getSingleResult();
        } else {
            Gebruiker geenGebruiker = new Gebruiker();
            geenGebruiker.setId(0);
            return geenGebruiker;
        }
    }

    @Override
    public Gebruiker registreer(Gebruiker gebruiker) {

        entityManager.persist(gebruiker);


        return gebruiker;
    }
}
