/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.entity.Chambre;
import reservation.entity.Client;
import reservation.entity.Hotel;
import reservation.entity.Utilisateur;
import reservation.service.ClientService;
import reservation.service.HotelService;
import reservation.service.RechercheService;
import reservation.service.UtilisateurServiceCRUD;

/**
 *
 * @author formation
 */
@Controller
public class UtilisateurController {
    @Autowired
    private UtilisateurServiceCRUD utc;
    @Autowired
    private RechercheService rchs;
    @Autowired
    private HotelService hs;
    @Autowired
    private ClientService cls;
    

    @RequestMapping(value = "/identification", method = RequestMethod.GET)
    public String identificationGET(Model model) {
       
        model.addAttribute("utilDTO", new Utilisateur());
        return "/identification.jsp";

    }
    @RequestMapping(value="/identification", method = RequestMethod.POST)
    public String identificationPOST(@ModelAttribute("utilDTO") Utilisateur u, HttpSession session) {
        
        
       // Renvoie vers page d'identification si pas membre
       if(utc.findByIdentifiantAndMotDePasse(u.getIdentifiant(), u.getMotDePasse()) == null) {
           return "redirect:/identification";
       } else {
           u = utc.findByIdentifiantAndMotDePasse(u.getIdentifiant(), u.getMotDePasse());
       }
       
       
        session.setAttribute("utilConnecte", true);
        session.setAttribute("usrConnecte",u);
       
       
       // Enregistre en session que l'util est admin et Renvoie vers la liste d'hôtels
       if(u.getTypeUtilisateur().equals(Utilisateur.TypeUtilisateur.ADMIN)) {
           session.setAttribute("adminConnecte", true);
           
       return "redirect:/hotel/lister";
       }
        
       
       //Renvoie vers l'accueil pour les clients
//       return "redirect:/hotel/lister";
       return "redirect:/utilisateur/accueil";
    }
    
       
    @RequestMapping(value = "/deconnexion", method = RequestMethod.GET)
    public String deconnexion( HttpSession session) {
        session.invalidate();
        return "redirect:/hotel/lister";
    }
    
    @RequestMapping(value = "/inscription", method = RequestMethod.GET)
    public String inscriptionGet(Model model) {
        model.addAttribute("newUtil", new Utilisateur());
        return "/inscription.jsp";
    }
    
    @RequestMapping(value = "/inscription", method = RequestMethod.POST)
    public String inscriptionPost(@ModelAttribute("newUtil") Utilisateur u) {
        u.setTypeUtilisateur(Utilisateur.TypeUtilisateur.CLIENT);
        Client c = new Client();
        cls.save(c);
        
        c.setUtilisateur(u);
        
        
        
        u.setClient(c);
        utc.save(u);
        
        return "redirect:/identification";
    }
    
    @RequestMapping(value = "/utilisateur/accueil", method = RequestMethod.GET)
    public String accueilClient(Utilisateur c, Model model, HttpSession session)
    {
        c = (Utilisateur)session.getAttribute("usrConnecte");
        model.addAttribute("username", c.getIdentifiant());
        return "/utilisateur/accueil.jsp";
        
    }
    
    
    
    
    
   
    
    
}
