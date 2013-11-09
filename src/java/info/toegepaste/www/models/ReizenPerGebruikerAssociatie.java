/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author matth_000
 */
@Entity
@Table(name="reis_gebruiker")
@IdClass(ReizenPerGebruikerAssociatieId.class)
public class ReizenPerGebruikerAssociatie {
   
    @Id
    private Long reisId;
    @Id
    private Long gebruikerId;
    
    @Column(name="aantalPersonen")
  private int aantalPersonen;


    
    

    
    
}
