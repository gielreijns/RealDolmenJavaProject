/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.services;

import info.toegepaste.www.models.Gebruiker;

/**
 *
 * @author Bruno
 */
public interface GebruikerService {

    public Gebruiker checkLogin(Gebruiker gebruiker);
    public Gebruiker registreer(Gebruiker gebruiker);
}
