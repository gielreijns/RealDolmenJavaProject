/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.testen;

import info.toegepaste.www.models.Korting;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno
 */
public class KortingTesten {

    public Korting korting = new Korting();

    @Test
    public void testPercentageBoven100() {
        int percentage = 101;
        int bedrag = 100;
        int resultaat;

        resultaat = korting.calculateKorting(bedrag, percentage);
        
        assertEquals(bedrag, resultaat);
    }

    @Test
    public void testPercentageKleinerDan1() {
        int percentage = 0;
        int bedrag = 100;
        int resultaat;

        resultaat = korting.calculateKorting(bedrag, percentage);

        assertEquals(bedrag, resultaat);
    }

    @Test
    public void controleBerekening() {
        int percentage = 10;
        int bedrag = 100;
        int resultaat;

        resultaat = korting.calculateKorting(bedrag, percentage);

        assertEquals(resultaat, 90);
    }
}
