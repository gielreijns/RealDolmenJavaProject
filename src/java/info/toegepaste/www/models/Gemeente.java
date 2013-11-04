/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.model;

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
        @NamedQuery(name = "Gemeente.getAllByLand", query = "SELECT g FROM Gemeente g WHERE g.land = :land")
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
    private int postcode;
    @JoinColumn(name = "landId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Land land;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gebruiker")
    private List<Gebruiker> gebruikers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reis")
    private List<Reis> reizen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vertrekplaats")
    private List<Vertrekplaats> vertrekplaatsen;

    public Gemeente() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Vertrekplaats> getVertrekplaatsen() {
        return vertrekplaatsen;
    }

    public void setVertrekplaatsen(List<Vertrekplaats> vertrekplaatsen) {
        this.vertrekplaatsen = vertrekplaatsen;
    }

    public List<Reis> getReizen() {
        return reizen;
    }

    public void setReizen(List<Reis> reizen) {
        this.reizen = reizen;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    public List<Gebruiker> getGebruikers() {
        return gebruikers;
    }

    public void setGebruikers(List<Gebruiker> gebruikers) {
        this.gebruikers = gebruikers;
    }

    @Override
    public String toString() {
        return "Gemeente{" + "id=" + id + ", naam=" + naam + ", postcode=" + postcode + ", land=" + land + ", gebruikers=" + gebruikers + ", reizen=" + reizen + ", vertrekplaatsen=" + vertrekplaatsen + '}';
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
