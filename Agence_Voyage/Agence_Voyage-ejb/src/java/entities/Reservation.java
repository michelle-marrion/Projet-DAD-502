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
@Table(name = "reservation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r")
    , @NamedQuery(name = "Reservation.findById", query = "SELECT r FROM Reservation r WHERE r.id = :id")
    , @NamedQuery(name = "Reservation.findByIdVol", query = "SELECT r FROM Reservation r WHERE r.idVol = :idVol")
    , @NamedQuery(name = "Reservation.findByIdClient", query = "SELECT r FROM Reservation r WHERE r.idClient = :idClient")
    , @NamedQuery(name = "Reservation.findByIdChambre", query = "SELECT r FROM Reservation r WHERE r.idChambre = :idChambre")
    , @NamedQuery(name = "Reservation.findByDescription", query = "SELECT r FROM Reservation r WHERE r.description = :description")
    , @NamedQuery(name = "Reservation.findByDateReservation", query = "SELECT r FROM Reservation r WHERE r.dateReservation = :dateReservation")
    , @NamedQuery(name = "Reservation.findByDateUpdate", query = "SELECT r FROM Reservation r WHERE r.dateUpdate = :dateUpdate")})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_vol")
    private int idVol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_client")
    private int idClient;
    @Column(name = "id_chambre")
    private Integer idChambre;
    @Size(max = 254)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_reservation")
    @Temporal(TemporalType.DATE)
    private Date dateReservation;
    @Column(name = "date_update")
    @Temporal(TemporalType.DATE)
    private Date dateUpdate;

    public Reservation() {
    }

    public Reservation(Integer id) {
        this.id = id;
    }

    public Reservation(Integer id, int idVol, int idClient, Date dateReservation) {
        this.id = id;
        this.idVol = idVol;
        this.idClient = idClient;
        this.dateReservation = dateReservation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdVol() {
        return idVol;
    }

    public void setIdVol(int idVol) {
        this.idVol = idVol;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Integer getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(Integer idChambre) {
        this.idChambre = idChambre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
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
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Reservation[ id=" + id + " ]";
    }
    
}
