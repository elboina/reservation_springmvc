/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.service;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import reservation.entity.Hotel;

/**
 *
 * @author formation
 */
@Repository
public interface HotelService extends CrudRepository<Hotel, Long> {
    public ArrayList<Hotel> findByAdresseLocalite(String localite);
    Hotel findById(long id);
}
