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

    public ArrayList<Chambre> rechercherChambreParVille(String ville, int nbPersonnes, Date dateArrivee, Date dateDepart) {

        ArrayList<Chambre> chambres = new ArrayList<>();
        

        chambres = chs.findAllByHotelAdresseLocaliteAndNbPersonnesGreaterThan(ville, nbPersonnes);
        
        for(Chambre c:chambres) {
            for(Reservation r:c.getReservations()) {
                if(dateArrivee.before(r.getDateCheckOut()) && dateDepart.after(r.getDateCheckIn())) {
                    chambres.remove(c);
                }
            }

        }
        return chambres;
    }
    
    public ArrayList<Chambre> rechercherChambreParVilleV2(String ville, int nbPersonnes, Date dateArrivee, Date dateDepart) {
        ArrayList<Chambre> chambres = chs.rechercherChambresParVilleCapaciteDates(ville, nbPersonnes, dateArrivee, dateDepart);
        return chambres;
    }

}
