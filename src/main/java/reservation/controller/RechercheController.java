/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.entity.Chambre;
import reservation.service.RechercheService;
import reservation.spring.ControllerAdvice;

/**
 *
 * @author formation
 */
@Controller
@RequestMapping(value = "/utilisateur")
public class RechercheController {

    @Autowired
    private RechercheService rchs;

    @RequestMapping(value = "/recherche", method = RequestMethod.GET)
    public String rechercherChambres(Model model, HttpStatus status) {

        model.addAttribute("chambre", new Chambre());
        if(status == HttpStatus.valueOf(404)) {
            ControllerAdvice ca = new ControllerAdvice();
            ca.exceptionHandler(new Exception());
            
            
        }

        return "/utilisateur/rechercher.jsp";
    }

    @RequestMapping(value = "/recherche", method = RequestMethod.POST)
    public String rechercherPost(@ModelAttribute("chambre") Chambre ch, HttpSession session) {
//        ArrayList<Chambre> chambres = rchs.rechercherChambreParVille(ch.getHotel().getAdresse().getLocalite(), ch.getNbPersonnes(), ch.getReservations().get(0).getDateCheckIn(), ch.getReservations().get(0).getDateCheckOut());
        ArrayList<Chambre> chambres = rchs.rechercherChambreParVilleV2(ch.getHotel().getAdresse().getLocalite(), ch.getNbPersonnes(), ch.getReservations().get(0).getDateCheckIn(), ch.getReservations().get(0).getDateCheckOut());
        int nbResultats = chambres.size();
        session.setAttribute("resultats", chambres);
        session.setAttribute("dateCheckIn", ch.getReservations().get(0).getDateCheckIn());
        session.setAttribute("dateCheckOut", ch.getReservations().get(0).getDateCheckOut());
        session.setAttribute("nombreResultats", nbResultats);
        return "redirect:/utilisateur/recherche";
        
    }
}
