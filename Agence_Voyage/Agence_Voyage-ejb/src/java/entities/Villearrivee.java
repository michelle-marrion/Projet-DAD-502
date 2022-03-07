/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michelle Marrion
 */
@Entity
@Table(name = "villearrivee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Villearrivee.findAll", query = "SELECT v FROM Villearrivee v")
    , @NamedQuery(name = "Villearrivee.findByIdVille", query = "SELECT v FROM Villearrivee v WHERE v.idVille = :idVille")
    , @NamedQuery(name = "Villearrivee.findByLocalite", query = "SELECT v FROM Villearrivee v WHERE v.localite = :localite")})
public class Villearrivee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ville")
    private Integer idVille;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "localite")
    private String localite;

    public Villearrivee() {
    }

    public Villearrivee(Integer idVille) {
        this.idVille = idVille;
    }

    public Villearrivee(Integer idVille, String localite) {
        this.idVille = idVille;
        this.localite = localite;
    }

    public Integer getIdVille() {
        return idVille;
    }

    public void setIdVille(Integer idVille) {
        this.idVille = idVille;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVille != null ? idVille.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Villearrivee)) {
            return false;
        }
        Villearrivee other = (Villearrivee) object;
        if ((this.idVille == null && other.idVille != null) || (this.idVille != null && !this.idVille.equals(other.idVille))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Villearrivee[ idVille=" + idVille + " ]";
    }
    
}
