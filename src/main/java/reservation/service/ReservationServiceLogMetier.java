/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author formation
 */

@Service
public class ReservationServiceLogMetier {
    
    @Autowired
    private ReservationService serviceReservation;
    
    @Autowired
    private ChambreService serviceChambre;
    
    @Autowired
    private ClientService serviceClient;
    
    public void ajoutReservation(long idClient, long idChambre, Date dateCheckIn, Date dateCheckOut){
        //Calcul du prix total
        long prixTotal;

        //ajoute une nouvelle reservation à l'état A_PAYER dans la base
        prixTotal = idChambre+90*(dateCheckOut.getDate()-dateCheckIn.getDate());
    }
}
