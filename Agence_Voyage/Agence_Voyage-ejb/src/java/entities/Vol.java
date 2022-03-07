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
@Table(name = "vol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vol.findAll", query = "SELECT v FROM Vol v")
    , @NamedQuery(name = "Vol.findById", query = "SELECT v FROM Vol v WHERE v.id = :id")
    , @NamedQuery(name = "Vol.findByIdVilleDepart", query = "SELECT v FROM Vol v WHERE v.idVilleDepart = :idVilleDepart")
    , @NamedQuery(name = "Vol.findByIdVilleArrive", query = "SELECT v FROM Vol v WHERE v.idVilleArrive = :idVilleArrive")
    , @NamedQuery(name = "Vol.findByIdCompagnie", query = "SELECT v FROM Vol v WHERE v.idCompagnie = :idCompagnie")
    , @NamedQuery(name = "Vol.findByNom", query = "SELECT v FROM Vol v WHERE v.nom = :nom")
    , @NamedQuery(name = "Vol.findByAdresse", query = "SELECT v FROM Vol v WHERE v.adresse = :adresse")
    , @NamedQuery(name = "Vol.findByTelephone", query = "SELECT v FROM Vol v WHERE v.telephone = :telephone")
    , @NamedQuery(name = "Vol.findByEmail", query = "SELECT v FROM Vol v WHERE v.email = :email")
    , @NamedQuery(name = "Vol.findBySiteWeb", query = "SELECT v FROM Vol v WHERE v.siteWeb = :siteWeb")
    , @NamedQuery(name = "Vol.findByDateCreate", query = "SELECT v FROM Vol v WHERE v.dateCreate = :dateCreate")
    , @NamedQuery(name = "Vol.findByDateDepart", query = "SELECT v FROM Vol v WHERE v.dateDepart = :dateDepart")
    , @NamedQuery(name = "Vol.findByDateArrivee", query = "SELECT v FROM Vol v WHERE v.dateArrivee = :dateArrivee")
    , @NamedQuery(name = "Vol.findByPrix", query = "SELECT v FROM Vol v WHERE v.prix = :prix")})
public class Vol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ville_depart")
    private int idVilleDepart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ville_arrive")
    private int idVilleArrive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_compagnie")
    private int idCompagnie;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Size(max = 254)
    @Column(name = "adresse")
    private String adresse;
    @Size(max = 254)
    @Column(name = "telephone")
    private String telephone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 254)
    @Column(name = "email")
    private String email;
    @Size(max = 254)
    @Column(name = "site_web")
    private String siteWeb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_create")
    @Temporal(TemporalType.DATE)
    private Date dateCreate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_depart")
    @Temporal(TemporalType.DATE)
    private Date dateDepart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_arrivee")
    @Temporal(TemporalType.DATE)
    private Date dateArrivee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix")
    private double prix;

    public Vol() {
    }

    public Vol(Integer id) {
        this.id = id;
    }

    public Vol(Integer id, int idVilleDepart, int idVilleArrive, int idCompagnie, Date dateCreate, Date dateDepart, Date dateArrivee, double prix) {
        this.id = id;
        this.idVilleDepart = idVilleDepart;
        this.idVilleArrive = idVilleArrive;
        this.idCompagnie = idCompagnie;
        this.dateCreate = dateCreate;
        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.prix = prix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdVilleDepart() {
        return idVilleDepart;
    }

    public void setIdVilleDepart(int idVilleDepart) {
        this.idVilleDepart = idVilleDepart;
    }

    public int getIdVilleArrive() {
        return idVilleArrive;
    }

    public void setIdVilleArrive(int idVilleArrive) {
        this.idVilleArrive = idVilleArrive;
    }

    public int getIdCompagnie() {
        return idCompagnie;
    }

    public void setIdCompagnie(int idCompagnie) {
        this.idCompagnie = idCompagnie;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
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
        if (!(object instanceof Vol)) {
            return false;
        }
        Vol other = (Vol) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Vol[ id=" + id + " ]";
    }
    
}
