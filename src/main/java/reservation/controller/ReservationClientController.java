/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import java.net.URLEncoder;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import reservation.entity.Reservation;
import reservation.service.ChambreService;
import reservation.service.ClientService;
import reservation.service.ReservationService;
import reservation.service.ReservationServiceLogMetier;

/**
 *
 * @author formation
 */
@Controller
@RequestMapping()
public class ReservationClientController {

    @Autowired
    private ReservationServiceLogMetier reservmet;
    
    @Autowired
    private ReservationService serviceReservation;

    @Autowired
    private ChambreService serviceChambre;

    @Autowired
    private ClientService serviceClient;

    @RequestMapping(value = "/mesreservations")
    public String mesReservations(Model model){
        model.addAttribute("reservationsAPayer", serviceReservation.findByClientIdAndEtatReservation(1, Reservation.EtatReservation.A_PAYER));
        model.addAttribute("reservationsPayees", serviceReservation.findByClientIdAndEtatReservation(1, Reservation.EtatReservation.PAYE));
        model.addAttribute("reservationsAnnulees", serviceReservation.findByClientIdAndEtatReservation(1, Reservation.EtatReservation.ANNULE));
        
        return "/reservationclient/mesreservations.jsp";
    }
    
    

}
