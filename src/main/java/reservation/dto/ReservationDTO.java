/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import reservation.entity.Client;

/**
 *
 * @author formation
 */

public class ReservationDTO {
    public enum EtatReservation {
        A_PAYER, 
        PAYE,
        ANNULE
    }
    private Long id;
    private Date dateReservation;
    private Double prixTotal;
    private Client client;
    private List<Long> chambresId = new ArrayList<>();
    private EtatReservation etatReservation;
    private Date dateCheckIn;
    private Date dateCheckOut;

    public Date getDateCheckIn() {
        return dateCheckIn;
    }

    public void setDateCheckIn(Date dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }

    public Date getDateCheckOut() {
        return dateCheckOut;
    }

    public void setDateCheckOut(Date dateCheckOut) {
        this.dateCheckOut = dateCheckOut;
    }

    public EtatReservation getEtatReservation() {
        return etatReservation;
    }

    public void setEtatReservation(EtatReservation etatReservation) {
        this.etatReservation = etatReservation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Long> getChambresId() {
        return chambresId;
    }

    public void setChambresId(List<Long> chambresId) {
        this.chambresId = chambresId;
    }
    
    
}
