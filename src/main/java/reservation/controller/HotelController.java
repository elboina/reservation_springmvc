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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.entity.Hotel;
import reservation.service.HotelService;

/**
 *
 * @author formation
 */
@Controller
@RequestMapping(value = "/hotel")
public class HotelController {

    @Autowired
    private HotelService hs;
    
    @RequestMapping(value = "/supprimer/{idHotel}")
    public String supprimer( @PathVariable(value = "idHotel") long id){
        //Supprimer en DB
        hs.delete(id);
        //Redirection vers liste
        return "redirect:/hotel/lister";
    } 
    
    @RequestMapping(value = "/modifier/{id}", method = RequestMethod.GET)
    public String modifierGet(Model model,@PathVariable(value = "id") long hotelId) {
        Hotel h = hs.findOne(hotelId);
        model.addAttribute("monHotel", h);
        return "/hotel/modifier.jsp";
    }
    
    @RequestMapping(value = "/modifier", method = RequestMethod.POST)
    public String modifierPost(@ModelAttribute("monHotel") Hotel h) {
        hs.save(h);
        return "redirect:/hotel/lister";
        
    }
    
    @RequestMapping(value ="/ajouter", method = RequestMethod.GET)
    public String ajouterGet(Model model) {
        model.addAttribute("nouvHotel", new Hotel());
        return "/hotel/ajouter.jsp";
    }
    
    @RequestMapping(value = "/ajouter", method = RequestMethod.POST)
    public String ajouterPost(@ModelAttribute("nouvHotel") Hotel h) {
        hs.save(h);
        return "redirect:/hotel/lister";
    }
    
            

    @RequestMapping(value = "/lister", method = RequestMethod.GET)
    public String listerHotels(Model model) {

        model.addAttribute("hotels", hs.findAll());

        return "/hotel/lister.jsp";
    }
}
