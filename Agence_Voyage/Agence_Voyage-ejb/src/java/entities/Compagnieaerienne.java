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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "compagnieaerienne")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compagnieaerienne.findAll", query = "SELECT c FROM Compagnieaerienne c")
    , @NamedQuery(name = "Compagnieaerienne.findById", query = "SELECT c FROM Compagnieaerienne c WHERE c.id = :id")
    , @NamedQuery(name = "Compagnieaerienne.findByNom", query = "SELECT c FROM Compagnieaerienne c WHERE c.nom = :nom")
    , @NamedQuery(name = "Compagnieaerienne.findByAdresse", query = "SELECT c FROM Compagnieaerienne c WHERE c.adresse = :adresse")
    , @NamedQuery(name = "Compagnieaerienne.findByTelephone", query = "SELECT c FROM Compagnieaerienne c WHERE c.telephone = :telephone")
    , @NamedQuery(name = "Compagnieaerienne.findByMail", query = "SELECT c FROM Compagnieaerienne c WHERE c.mail = :mail")
    , @NamedQuery(name = "Compagnieaerienne.findBySiteweb", query = "SELECT c FROM Compagnieaerienne c WHERE c.siteweb = :siteweb")
    , @NamedQuery(name = "Compagnieaerienne.findByDateCreate", query = "SELECT c FROM Compagnieaerienne c WHERE c.dateCreate = :dateCreate")
    , @NamedQuery(name = "Compagnieaerienne.findByDateUpdate", query = "SELECT c FROM Compagnieaerienne c WHERE c.dateUpdate = :dateUpdate")})
public class Compagnieaerienne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "adresse")
    private String adresse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "telephone")
    private String telephone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "mail")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "siteweb")
    private String siteweb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_create")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @Column(name = "date-update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdate;

    public Compagnieaerienne() {
    }

    public Compagnieaerienne(Integer id) {
        this.id = id;
    }

    public Compagnieaerienne(Integer id, String nom, String adresse, String telephone, String mail, String siteweb, Date dateCreate) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.mail = mail;
        this.siteweb = siteweb;
        this.dateCreate = dateCreate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSiteweb() {
        return siteweb;
    }

    public void setSiteweb(String siteweb) {
        this.siteweb = siteweb;
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
        if (!(object instanceof Compagnieaerienne)) {
            return false;
        }
        Compagnieaerienne other = (Compagnieaerienne) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Compagnieaerienne[ id=" + id + " ]";
    }
    
}
