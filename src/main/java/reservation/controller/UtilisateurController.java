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
import reservation.entity.Hotel;
import reservation.entity.Utilisateur;
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
    
    @RequestMapping(value = "/utilisateur/recherche", method = RequestMethod.GET)
    public String rechercherChambres(Model model) {
       
        model.addAttribute("hotel", new Hotel());
        
        return "/utilisateur/rechercher.jsp";
    }
    
    @RequestMapping(value = "/utilisateur/recherche", method = RequestMethod.POST)
    public String rechercherPost(@ModelAttribute("hotel") Hotel h, HttpSession session) {
        ArrayList<Chambre> chambres = new ArrayList<>();
       
       
        
        chambres = rchs.rechercherChambreParVille(h.getAdresse().getLocalite(), h.getChambres().get(0).getDateCheckIn(),h.getChambres().get(0).getDateCheckOut());

       for(Chambre c:chambres) {
           System.out.println(c.getNom());
       }
        session.setAttribute("resultats", chambres);
        return "redirect:/utilisateur/recherche";
    }
    
    
    
   
    
    
}
