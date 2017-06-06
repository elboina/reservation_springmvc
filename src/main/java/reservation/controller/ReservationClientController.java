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

    @RequestMapping(value = "/reservationclient")
    public String reserverBidonGET() {

        long idClient = 1;
        long idChambre = 1;
        Date dateCheckIn = new Date("06/02/2017");
        Date dateCheckOut = new Date("06/10/2017");
        
        
        
        return "a_completer.jsp";
    }
    
    @RequestMapping(value = "/mesreservations")
    public String recapGET(Model model){
        model.addAttribute("reservations", serviceReservation.findAll());
        
        return "/mesreservations.jsp";
    }

}
