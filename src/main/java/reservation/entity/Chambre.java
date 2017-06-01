/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author formation
 */
@Entity
public class Chambre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private Double prix;
    
    @ManyToOne
    @JoinColumn(name="hotel_id")
    private Hotel hotel;
    
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(nullable = false)
//    private Date dateCheckIn;
//    
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(nullable = false)
//    private Date dateCheckOut;
//    
//    @Column(nullable = false)
//    private Integer nbPersonnes;
//
//    public Date getDateCheckIn() {
//        return dateCheckIn;
//    }
//
//    public void setDateCheckIn(Date dateCheckIn) {
//        this.dateCheckIn = dateCheckIn;
//    }
//
//    public Date getDateCheckOut() {
//        return dateCheckOut;
//    }
//
//    public void setDateCheckOut(Date dateCheckOut) {
//        this.dateCheckOut = dateCheckOut;
//    }
//
//    public Integer getNbPersonnes() {
//        return nbPersonnes;
//    }
//
//    public void setNbPersonnes(Integer nbPersonnes) {
//        this.nbPersonnes = nbPersonnes;
//    }
    @ManyToMany(mappedBy = "chambres")
    private List<Reservation> reservations = new ArrayList<>();

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "reservation.entity.Chambre[ id=" + id + " ]";
    }
    
}
