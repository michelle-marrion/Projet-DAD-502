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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michelle Marrion
 */
@Entity
@Table(name = "villedepart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Villedepart.findAll", query = "SELECT v FROM Villedepart v")
    , @NamedQuery(name = "Villedepart.findByIdVille", query = "SELECT v FROM Villedepart v WHERE v.idVille = :idVille")})
public class Villedepart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ville")
    private Long idVille;

    public Villedepart() {
    }

    public Villedepart(Long idVille) {
        this.idVille = idVille;
    }

    public Long getIdVille() {
        return idVille;
    }

    public void setIdVille(Long idVille) {
        this.idVille = idVille;
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
        if (!(object instanceof Villedepart)) {
            return false;
        }
        Villedepart other = (Villedepart) object;
        if ((this.idVille == null && other.idVille != null) || (this.idVille != null && !this.idVille.equals(other.idVille))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Villedepart[ idVille=" + idVille + " ]";
    }
    
}
