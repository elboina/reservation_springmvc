/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.service;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.data.repository.CrudRepository;
import reservation.entity.Chambre;
import reservation.entity.Hotel;

/**
 *
 * @author formation
 */
public interface ChambreService extends CrudRepository<Chambre, Long> {
    public ArrayList<Chambre> findAllByHotelAdresseLocalite(String localite);
    public ArrayList<Chambre> findAllByHotel(Hotel h);
    public ArrayList<Chambre> findAllByDateCheckInAfter(Date date);
}
