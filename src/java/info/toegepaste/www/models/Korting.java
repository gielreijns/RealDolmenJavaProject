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
public class Korting implements Serializable {

    public Korting() {
    }

    /**
     * kortingsPercentage moet altijd tussen 0 en 100
     */
    public int calculateKorting(int bedrag, int kortingsPercentage) {
        int nieuwBedrag;
        int korting = 2;

        if (controleerPercentage(kortingsPercentage)) {
            korting = Math.round((bedrag / 100) * kortingsPercentage);
            nieuwBedrag = bedrag - korting;
        } else {
            nieuwBedrag = bedrag;
        }

        return nieuwBedrag;
    }

    private boolean controleerPercentage(int percentage) {
        boolean controle = true;

        if (percentage <= 0 || percentage > 100) {
            controle = false;
        }

        return controle;
    }
}
