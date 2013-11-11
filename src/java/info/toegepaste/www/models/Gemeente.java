/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "gemeente")
@NamedQueries({
    @NamedQuery(name = "Gemeente.getAll", query = "SELECT g FROM Gemeente g"),
    @NamedQuery(name = "Gemeente.getAllFromLand", query = "SELECT g FROM Gemeente g WHERE g.land = :land"),
    @NamedQuery(name = "Gemeente.getAllBestemmingen", query = "SELECT g FROM Gemeente g WHERE g.isBestemming = true"),
    @NamedQuery(name = "Gemeente.getAllNietBestemmingen", query = "SELECT g FROM Gemeente g WHERE g.isBestemming = false")
})
public class Gemeente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "naam")
    private String naam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "postcode")
    private String postcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isBestemming")
    private boolean isBestemming;
    
    @ManyToOne
    private Land land;
    
    
    

    @OneToMany(mappedBy = "gemeente")
    private List<Gebruiker> gebruikers;
    @OneToMany(mappedBy = "gemeente")
    private List<Reis> reizen;
    @OneToMany(mappedBy = "gemeente")
    private List<Vertrekplaats> vertrekplaatsen;
    
   
    
    

    public Gemeente() {
    }

    public List<Gebruiker> getGebruikers() {
        return gebruikers;
    }

    public void setGebruikers(List<Gebruiker> gebruikers) {
        this.gebruikers = gebruikers;
    }

    public List<Reis> getReizen() {
        return reizen;
    }

    public void setReizen(List<Reis> reizen) {
        this.reizen = reizen;
    }

    public List<Vertrekplaats> getVertrekplaatsen() {
        return vertrekplaatsen;
    }

    public void setVertrekplaatsen(List<Vertrekplaats> vertrekplaatsen) {
        this.vertrekplaatsen = vertrekplaatsen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public boolean isIsBestemming() {
        return isBestemming;
    }

    public void setIsBestemming(boolean isBestemming) {
        this.isBestemming = isBestemming;
    }

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    

    

    @Override
    public String toString() {
        return "Gemeente{" + "id=" + id + ", naam=" + naam + ", postcode=" + postcode + ", land=" + land + ", gebruikers=" +  '}';
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gemeente)) {
            return false;
        }
        Gemeente other = (Gemeente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
