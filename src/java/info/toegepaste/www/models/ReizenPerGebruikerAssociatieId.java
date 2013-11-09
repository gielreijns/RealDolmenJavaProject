/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author matth_000
 */

public class ReizenPerGebruikerAssociatieId implements Serializable{
    
    
    private Long reisId;
    private Long gebruikerId;

   
    
    @Override
    public int hashCode() {
       
        return (int) (reisId + gebruikerId);
    }

    
    @Override
    public boolean equals(Object object) {
       if (object instanceof ReizenPerGebruikerAssociatieId) {
      ReizenPerGebruikerAssociatieId otherId = (ReizenPerGebruikerAssociatieId) object;
      return (otherId.reisId == this.gebruikerId) && (otherId.gebruikerId == this.gebruikerId);
    }
    return false;
    }
   

    
}
