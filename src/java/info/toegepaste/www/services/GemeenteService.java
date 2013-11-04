/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package info.toegepaste.www.services;

import info.toegepaste.www.model.Gemeente;
import info.toegepaste.www.model.Land;
import java.util.List;

/**
 *
 * @author Bruno
 */
public interface GemeenteService {
    public List<Gemeente> getAllGemeentes();
    public List<Gemeente> getAllGemeentesByLand(Land land);
}
