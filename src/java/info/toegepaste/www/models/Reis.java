/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "reis")
@NamedQueries({

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
    @Temporal(TemporalType.TIMESTAMP)
    private Date vertrekdatum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "terugkeerdatum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date terugkeerdatum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aantalPlaatsen")
    private int aantalPlaatsen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prijsPerPersoon")
    private Double prijsPerPersoon;
    @JoinColumn(name = "gemeenteId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Gemeente gemeente;
    @JoinColumn(name = "vervoerswijzeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vervoerswijze vervoerswijze;
    @JoinColumn(name = "vertrekplaatsId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vertrekplaats vertrekplaats;

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

    public Date getVertrekdatum() {
        return vertrekdatum;
    }

    public void setVertrekdatum(Date vertrekdatum) {
        this.vertrekdatum = vertrekdatum;
    }

    public Date getTerugkeerdatum() {
        return terugkeerdatum;
    }

    public void setTerugkeerdatum(Date terugkeerdatum) {
        this.terugkeerdatum = terugkeerdatum;
    }

    public int getAantalPlaatsen() {
        return aantalPlaatsen;
    }

    public void setAantalPlaatsen(int aantalPlaatsen) {
        this.aantalPlaatsen = aantalPlaatsen;
    }

    public Double getPrijsPerPersoon() {
        return prijsPerPersoon;
    }

    public void setPrijsPerPersoon(Double prijsPerPersoon) {
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

    public Vertrekplaats getVertrekplaats() {
        return vertrekplaats;
    }

    public void setVertrekplaats(Vertrekplaats vertrekplaats) {
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
