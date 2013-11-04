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
@Table(name = "land")
@NamedQueries({
@NamedQuery(name = "Land.getAll", query = "SELECT l FROM Land l")
})
public class Land implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "continent")
    private List<Continent> continenten;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gemeente")
    private List<Gemeente> gemeenten;

    public Land() {
    }

    public List<Gemeente> getGemeenten() {
        return gemeenten;
    }

    public void setGemeenten(List<Gemeente> gemeenten) {
        this.gemeenten = gemeenten;
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

    public List<Continent> getContinenten() {
        return continenten;
    }

    public void setContinenten(List<Continent> continenten) {
        this.continenten = continenten;
    }

    @Override
    public String toString() {
        return "Land{" + "id=" + id + ", naam=" + naam + ", continenten=" + continenten + ", gemeenten=" + gemeenten + '}';
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Land)) {
            return false;
        }
        Land other = (Land) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
