/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.services;

import info.toegepaste.www.models.Reis;
import info.toegepaste.www.models.Vervoerswijze;
import java.util.List;

/**
 *
 * @author Bruno
 */
public interface VervoerswijzeService {

    public List<Vervoerswijze> getAllVervoerswijzen();
    
    public Vervoerswijze getVervoerswijze(Vervoerswijze vervoerswijze);
}
