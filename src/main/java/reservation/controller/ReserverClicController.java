/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.entity.Chambre;
import reservation.entity.Client;
import reservation.entity.Reservation;
import reservation.entity.Utilisateur;
import reservation.service.ChambreService;
import reservation.service.ReservationService;

/**
 *
 * @author formation
 */
@Controller
public class ReserverClicController {
    @Autowired
    private ReservationService rs;
    @Autowired
    private ChambreService chs;
    
    @RequestMapping(value = "/detailreservation/reserver/{idChambre}", method = RequestMethod.GET)
    public String clicReserver(Model model, HttpSession session, @PathVariable("idChambre") long idChambre) {
        Reservation res = new Reservation();
        Utilisateur u = (Utilisateur) session.getAttribute("usrConnecte");
        Date dateCheckIn = (Date) session.getAttribute("dateCheckIn");
        Date dateCheckOut = (Date) session.getAttribute("dateCheckOut");
        Client c = u.getClient();
        Chambre ch = chs.findOne(idChambre);
        res.setEtatReservation(Reservation.EtatReservation.A_PAYER);
        res.setClient(c);
        res.getChambres().add(ch);
        res.setPrixTotal(ch.getPrix());
        c.getReservations().add(res);
        res.setDateCheckIn(dateCheckIn);
        res.setDateCheckOut(dateCheckOut);
        res.setDateReservation(new Date());
        
        ch.getReservations().add(res);
        rs.save(res);
        model.addAttribute("reservation", res);
        
        return "/reservationclient/detail.jsp";
    }
}
