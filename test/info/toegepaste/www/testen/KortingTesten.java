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
    public Korting korting;
    
    public KortingTesten() {
    }
    
    @Test
    public void testPercentageBoven100() {
        int percentage = 101;
        double bedrag = 10.5;
        double resultaat;
        
        resultaat = korting.calculateKorting(bedrag, percentage);
        
        assertEquals(bedrag, resultaat);  
    }
    
    @Test
    public void testPercentageKleinerDan1() {
        int percentage = -1;
        double bedrag = 10.5;
        double resultaat;
        
        resultaat = korting.calculateKorting(bedrag, percentage);
        
        assertEquals(bedrag, resultaat);  
    }
    
    @Test
    public void controleBerekening1() {
        int percentage = 10;
        double bedrag = 10.50;
        double resultaat;
        
        resultaat = korting.calculateKorting(bedrag, percentage);
        
        assertEquals(resultaat, 9.45);  
    }
    
    @Test
    public void controleBerekening2() {
        int percentage = 10;
        double bedrag = 10.49;
        double resultaat;
        
        resultaat = korting.calculateKorting(bedrag, percentage);
        
        assertEquals(resultaat, 9.44);  
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
