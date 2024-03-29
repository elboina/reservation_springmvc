/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.service;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import reservation.entity.Reservation;

/**
 *
 * @author formation
 */
@Repository
public interface ReservationService extends CrudRepository<Reservation, Long> {
    
    public List<Reservation> findByClientIdAndEtatReservation(long id, Reservation.EtatReservation etatres);
    
    Reservation findById(long id);
}
