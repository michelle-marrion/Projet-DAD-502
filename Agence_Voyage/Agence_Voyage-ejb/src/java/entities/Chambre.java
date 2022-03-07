/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michelle Marrion
 */
@Entity
@Table(name = "chambre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chambre.findAll", query = "SELECT c FROM Chambre c")
    , @NamedQuery(name = "Chambre.findById", query = "SELECT c FROM Chambre c WHERE c.id = :id")
    , @NamedQuery(name = "Chambre.findByIdHotel", query = "SELECT c FROM Chambre c WHERE c.idHotel = :idHotel")
    , @NamedQuery(name = "Chambre.findByNumero", query = "SELECT c FROM Chambre c WHERE c.numero = :numero")
    , @NamedQuery(name = "Chambre.findByDescription", query = "SELECT c FROM Chambre c WHERE c.description = :description")
    , @NamedQuery(name = "Chambre.findByPrix", query = "SELECT c FROM Chambre c WHERE c.prix = :prix")
    , @NamedQuery(name = "Chambre.findByDateCreate", query = "SELECT c FROM Chambre c WHERE c.dateCreate = :dateCreate")
    , @NamedQuery(name = "Chambre.findByDateUpdate", query = "SELECT c FROM Chambre c WHERE c.dateUpdate = :dateUpdate")})
public class Chambre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_hotel")
    private int idHotel;
    @Size(max = 254)
    @Column(name = "numero")
    private String numero;
    @Size(max = 254)
    @Column(name = "description")
    private String description;
    @Size(max = 254)
    @Column(name = "prix")
    private String prix;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_create")
    @Temporal(TemporalType.DATE)
    private Date dateCreate;
    @Column(name = "date_update")
    @Temporal(TemporalType.DATE)
    private Date dateUpdate;

    public Chambre() {
    }

    public Chambre(Integer id) {
        this.id = id;
    }

    public Chambre(Integer id, int idHotel, Date dateCreate) {
        this.id = id;
        this.idHotel = idHotel;
        this.dateCreate = dateCreate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chambre)) {
            return false;
        }
        Chambre other = (Chambre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Chambre[ id=" + id + " ]";
    }
    
}
