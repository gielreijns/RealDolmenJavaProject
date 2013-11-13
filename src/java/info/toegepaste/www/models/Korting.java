/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package info.toegepaste.www.models;

import java.io.Serializable;

/**
 *
 * @author Bruno
 */
public class Korting implements Serializable{
    /**
     * kortingsPercentage moet tussen 0 en 100
     */
    public double calculateKorting(double bedrag, int kortingsPercentage) {
        double nieuwBedrag = 0.0;
        double korting = 0.0;
        
        if (controleerPercentage(kortingsPercentage)) {
            korting = (bedrag / 100) * kortingsPercentage;
            nieuwBedrag = bedrag - korting;
        } else {
            nieuwBedrag = bedrag;
        }
        
        return nieuwBedrag;
    }
    
    public boolean controleerPercentage(int percentage) {
        boolean controle = true;
        
        if(percentage < 0 || percentage > 100) {
            controle = false;
        }
        
        return controle;
    }
}
