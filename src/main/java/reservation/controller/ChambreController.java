/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.entity.Chambre;
import reservation.service.ChambreService;
import reservation.service.HotelService;

/**
 *
 * @author formation
 */
@Controller
public class ChambreController {
    
    @Autowired
    private ChambreService chs;
    @Autowired
    private HotelService hs;
    
    @RequestMapping(value = "/chambre/lister", method = RequestMethod.GET)
    public String lister(Model model) {
        List<Chambre> chambres = (List<Chambre>)chs.findAll();
        model.addAttribute("listeChambres", chambres);
        return "/chambre/lister";
    }
    
    @RequestMapping(value = "/chambre/modifier/{id}", method = RequestMethod.GET)
    public String modifierGet(Model model, @PathVariable("id") long idChambre) {
        model.addAttribute("maChambre", chs.rechercherParId(idChambre));
        model.addAttribute("hotels", hs.findAll());
        return "/chambre/modifier";
    }
    
    @RequestMapping(value ="/chambre/modifier", method=RequestMethod.POST)
    public String modifierPost(@ModelAttribute("maChambre")Chambre c) {
        
        chs.save(c);
        return "redirect:/chambre/lister";
        
    }
    
    @RequestMapping(value = "chambre/ajouter", method = RequestMethod.GET)
    public String ajouterGet(Model model) {
        model.addAttribute("chambre", new Chambre());
        model.addAttribute("hotels", hs.findAll());
        return "/chambre/ajouter";
    }
    
    @RequestMapping(value ="/chambre/ajouter", method = RequestMethod.POST)
    public String ajouterPost(@ModelAttribute("chambre") Chambre c) {
        chs.save(c);
        return "redirect:/chambre/lister";
    }
    
    @RequestMapping(value = "/chambre/supprimer/{id}", method = RequestMethod.GET)
    public String supprimer(@PathVariable("id") long idChambre) {
        chs.deleteById(idChambre);
        return "redirect:/chambre/lister";
    }
}
