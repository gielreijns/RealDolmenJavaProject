/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.models;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "reis")
@NamedQueries({
    @NamedQuery(name = "Reis.getAll", query = "SELECT r from Reis r order by r.naam"),
@NamedQuery(name = "Reis.getByNaam", query = "SELECT r from Reis r WHERE r.naam = :naam"),
@NamedQuery(name = "Reis.getByGemeente", query = "SELECT r from Reis r WHERE r.gemeente = :gemeente order by r.naam"),
@NamedQuery(name = "Reis.getByAantalPlaatsen", query = "SELECT r from Reis r WHERE r.aantalPlaatsen >= :aantalPlaatsen "),
@NamedQuery(name = "Reis.getByAantalPlaatsenGemeente", query = "SELECT r from Reis r WHERE r.aantalPlaatsen >= :aantalPlaatsen AND r.gemeente = :gemeente"),
@NamedQuery(name = "Reis.getByAantalPlaatsenVervoerswijze", query = "SELECT r from Reis r WHERE r.aantalPlaatsen >= :aantalPlaatsen AND r.vervoerswijze = :vervoerswijze"),
@NamedQuery(name = "Reis.getByVervoerswijze", query = "SELECT r from Reis r WHERE r.vervoerswijze = :vervoerswijze"),
@NamedQuery(name = "Reis.getByVertrekdatum", query = "SELECT r from Reis r WHERE r.vertrekdatum = :vertrekdatum"),
@NamedQuery(name = "Reis.getTerugkeerdatum", query = "SELECT r from Reis r WHERE r.terugkeerdatum = :terugkeerdatum"),
@NamedQuery(name = "Reis.getByReisPeriode", query = "SELECT r from Reis r WHERE r.vertrekdatum = :vertrekdatum AND r.terugkeerdatum = :terugkeerdatum"),
@NamedQuery(name = "Reis.getByAllZoekParameters", query = "SELECT r from Reis r WHERE r.gemeente = :gemeente AND r.aantalPlaatsen >= :aantalPlaatsen AND r.vervoerswijze = :vervoerswijze ORDER BY r.naam")
})
public class Reis implements Serializable {

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
    @Column(name = "beschrijving")
    private String beschrijving;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vertrekdatum")
    @Temporal(TemporalType.DATE)
    private GregorianCalendar vertrekdatum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "terugkeerdatum")
    @Temporal(TemporalType.DATE)
    private GregorianCalendar terugkeerdatum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aantalPlaatsen")
    private int aantalPlaatsen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prijsPerPersoon")
    private int prijsPerPersoon;

    @ManyToOne
    private Gemeente gemeente;
    
    @ManyToOne
    private Vervoerswijze vervoerswijze;
    
    @ManyToOne
    private Gemeente vertrekplaats;
    
    

    public Reis() {
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

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public GregorianCalendar getVertrekdatum() {
        return vertrekdatum;
    }

    public void setVertrekdatum(GregorianCalendar vertrekdatum) {
        this.vertrekdatum = vertrekdatum;
    }

    public GregorianCalendar getTerugkeerdatum() {
        return terugkeerdatum;
    }

    public void setTerugkeerdatum(GregorianCalendar terugkeerdatum) {
        this.terugkeerdatum = terugkeerdatum;
    }

    

    public int getAantalPlaatsen() {
        return aantalPlaatsen;
    }

    public void setAantalPlaatsen(int aantalPlaatsen) {
        this.aantalPlaatsen = aantalPlaatsen;
    }

    public int getPrijsPerPersoon() {
        return prijsPerPersoon;
    }

    public void setPrijsPerPersoon(int prijsPerPersoon) {
        this.prijsPerPersoon = prijsPerPersoon;
    }

    public Gemeente getGemeente() {
        return gemeente;
    }

    public void setGemeente(Gemeente gemeente) {
        this.gemeente = gemeente;
    }

    public Vervoerswijze getVervoerswijze() {
        return vervoerswijze;
    }

    public void setVervoerswijze(Vervoerswijze vervoerswijze) {
        this.vervoerswijze = vervoerswijze;
    }

    public Gemeente getVertrekplaats() {
        return vertrekplaats;
    }

    public void setVertrekplaats(Gemeente vertrekplaats) {
        this.vertrekplaats = vertrekplaats;
    }

   

    @Override
    public String toString() {
        return "Reis{" + "id=" + id + ", naam=" + naam + ", beschrijving=" + beschrijving + ", vertrekdatum=" + vertrekdatum + ", terugkeerdatum=" + terugkeerdatum + ", aantalPlaatsen=" + aantalPlaatsen + ", prijsPerPersoon=" + prijsPerPersoon + ", gemeente=" + gemeente + ", vervoerswijze=" + vervoerswijze + ", vertrekplaats=" + vertrekplaats + '}';
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reis)) {
            return false;
        }
        Reis other = (Reis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
