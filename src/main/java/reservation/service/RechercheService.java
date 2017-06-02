/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.service;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservation.entity.Chambre;
import reservation.entity.Hotel;
import reservation.entity.Reservation;

/**
 *
 * @author formation
 */
@Service
public class RechercheService {
    @Autowired
    private ChambreService chs;
    @Autowired
    private HotelService hs;
    public ArrayList<Chambre> rechercherChambreParVille (String ville, Date dateArrivee, Date dateDepart) {
        ArrayList<Hotel> hotels = hs.findByAdresseLocalite(ville);
        
        ArrayList<Chambre> chambres = new ArrayList<>();
        
        for(Hotel h:hotels) {
            chambres.addAll(chs.findAllByHotel(h));
        }
        
        for(Chambre c:chambres) {
            for(Reservation r:c.getReservations()) {
                if(r.getDateReservation().after(dateArrivee) && r.getDateReservation().before(dateDepart)) {
                    chambres.remove(c);
                }
            }

        }
        
        return chambres;
    }
    
   
}
