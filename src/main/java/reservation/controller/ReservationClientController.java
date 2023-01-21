/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import reservation.entity.Client;
import reservation.entity.Reservation;
import reservation.entity.Utilisateur;
import reservation.service.ReservationService;

/**
 *
 * @author formation
 */
@Controller
@RequestMapping()
public class ReservationClientController {

    @Autowired
    private ReservationService serviceReservation;

    @RequestMapping(value = "/mesreservations")
    public String mesReservations(Model model, HttpSession session) {
        Utilisateur u = (Utilisateur) session.getAttribute("usrConnecte");
        Client cli = u.getClient();
        long cliId = cli.getId();
        model.addAttribute("reservationsAPayer", serviceReservation.findByClientIdAndEtatReservation(cliId, Reservation.EtatReservation.A_PAYER));
        model.addAttribute("reservationsPayees", serviceReservation.findByClientIdAndEtatReservation(cliId, Reservation.EtatReservation.PAYE));
        model.addAttribute("reservationsAnnulees", serviceReservation.findByClientIdAndEtatReservation(cliId, Reservation.EtatReservation.ANNULE));

        return "/reservationclient/mesreservations";
    }

    @RequestMapping("/detailreservation/{id}")
    public String detailReservationGET(@PathVariable("id") long idReservation, Model model) {
        Reservation res = serviceReservation.findById(idReservation);
        model.addAttribute("reservation", res);

        return "/reservationclient/detail";
    }

    @RequestMapping("/detailreservation/paye/{id}")
    public String respayeesGET(@PathVariable("id") long id) {
        Reservation respayee =serviceReservation.findById(id);
        respayee.setEtatReservation(Reservation.EtatReservation.PAYE);
        serviceReservation.save(respayee);
        return "redirect:/mesreservations";
    }
    
    @RequestMapping("/detailreservation/annulees/{id}")
    public String reannuleesGET(@PathVariable("id") long id) {
        Reservation resannulee =serviceReservation.findById(id);
        resannulee.setEtatReservation(Reservation.EtatReservation.ANNULE);
        serviceReservation.save(resannulee);
        return "redirect:/mesreservations";
    }

}
