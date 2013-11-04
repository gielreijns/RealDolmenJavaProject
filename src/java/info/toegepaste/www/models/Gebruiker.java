/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "gebruiker")
@NamedQueries({
    
})
public class Gebruiker implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "voornaam")
    private String voornaam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "naam")
    private String naam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefoon")
    private String telefoon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "wachtwoord")
    private String wachtwoord;
    @Basic(optional = false)
    @NotNull
    @Column(name = "straat")
    private String straat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nummer")
    private String nummer;
    @JoinColumn(name = "gemeenteId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Gemeente gemeente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reis")
    private List<Reis> reizen;

    public Gebruiker() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    public Gemeente getGemeente() {
        return gemeente;
    }

    public void setGemeente(Gemeente gemeente) {
        this.gemeente = gemeente;
    }

    public List<Reis> getReizen() {
        return reizen;
    }

    public void setReizen(List<Reis> reizen) {
        this.reizen = reizen;
    }

    @Override
    public String toString() {
        return "Gebruiker{" + "id=" + id + ", voornaam=" + voornaam + ", naam=" + naam + ", telefoon=" + telefoon + ", email=" + email + ", wachtwoord=" + wachtwoord + ", straat=" + straat + ", nummer=" + nummer + ", reizen=" + reizen + '}';
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gebruiker)) {
            return false;
        }
        Gebruiker other = (Gebruiker) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
