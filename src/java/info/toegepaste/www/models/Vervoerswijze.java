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
@Table(name = "vervoerswijze")
@NamedQueries({
    @NamedQuery(name = "Vervoerswijze.getAll", query = "SELECT v FROM Vervoerswijze v")
})
public class Vervoerswijze implements Serializable {
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
    
   
    @OneToMany(mappedBy = "vervoerswijze")
    private List<Reis> reizen;
    

    public Vervoerswijze() {
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

    public List<Reis> getReizen() {
        return reizen;
    }

    public void setReizen(List<Reis> reizen) {
        this.reizen = reizen;
    }

    @Override
    public String toString() {
        return "Vervoerswijze{" + "id=" + id + ", naam=" + naam + ", reizen=" + reizen + '}';
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vervoerswijze)) {
            return false;
        }
        Vervoerswijze other = (Vervoerswijze) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
