/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.dto.ReservationDTO;
import reservation.entity.Chambre;
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
        List<Integer> index = new ArrayList<>();
        List<Chambre> ch = (List<Chambre>)chs.findAll();
        for(int i=0; i < ch.size(); i++) 
            index.add(i);
        
        
        model.addAttribute("dto", new ReservationDTO());
        model.addAttribute("clients",cls.findWithNomAndPrenom());
        model.addAttribute("chambres", ch);
        model.addAttribute("index", index);
        model.addAttribute("etats", Reservation.EtatReservation.values());
        
        return "/reservations/ajouter.jsp";
    }
    
    @RequestMapping(value = "/ajouter", method = RequestMethod.POST)
    public String ajouterPOST(@ModelAttribute("dto") ReservationDTO dto) {
        Reservation res = new Reservation();
        for(Long id:dto.getChambresId()) {
            res.getChambres().add(chs.findOne(id));
        }
        res.setClient(dto.getClient());
        res.setDateReservation(dto.getDateReservation());
        res.setPrixTotal(dto.getPrixTotal());
        res.setId(dto.getId());
        res.setDateCheckIn(dto.getDateCheckIn());
        res.setDateCheckOut(dto.getDateCheckOut());
        
//        String etat = dto.getEtatReservation().toString();
//        res.setEtatReservation(Reservation.EtatReservation.valueOf(etat));
        rs.save(res);
        
        return "redirect:/reservations/lister";
    }
    
   @RequestMapping(value ="/supprimer/{id}", method = RequestMethod.GET)
   public String supprimer(@PathVariable("id") long id) {
       rs.delete(id);
       return "redirect:/reservations/lister";
   }
   
}
