/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.entity.Reservation;
import reservation.service.ChambreService;
import reservation.service.ClientService;
import reservation.service.ReservationService;

/**
 *
 * @author formation
 */
@Controller
@RequestMapping(value = "/reservations")
public class ReservationController {
    
    @Autowired
    private ReservationService rs;
    @Autowired
    private ClientService cls;
    @Autowired
    private ChambreService chs;
    @RequestMapping(value = "/lister", method = RequestMethod.GET)
    public String lister(Model model) {
        model.addAttribute("listeReservations", rs.findAll() );
        return "reservations/lister.jsp";
    }
    
    @RequestMapping(value = "/ajouter", method = RequestMethod.GET)
    public String ajouterGET(Model model) {
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("clients",cls.findWithNomAndPrenom());
        model.addAttribute("chambres", chs.findAll());
        
        return "/reservations/ajouter.jsp";
    }
    
    @RequestMapping(value = "/ajouter", method = RequestMethod.POST)
    public String ajouterPOST(@ModelAttribute("reservation") Reservation res) {
        
        rs.save(res);
        return "redirect:/reservations/lister";
    }
}
