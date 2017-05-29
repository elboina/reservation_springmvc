/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.service.HotelService;

/**
 *
 * @author formation
 */
@Controller
public class HotelController {

    @Autowired
    private HotelService hs;
    
    @RequestMapping(value = "hotel/supprimer/{idHotel}", method = RequestMethod.GET)
    public String supprimer( @PathVariable(value = "idHotel") long id){
        //Supprimer en DB
        hs.delete(id);
        //Redirection vers liste
        return "redirect:/hotel/lister";
    } 
            

    @RequestMapping(value = "/hotel/lister", method = RequestMethod.GET)
    public String listerHotels(Model model) {

        model.addAttribute("hotels", hs.findAll());

        return "/hotel/lister.jsp";
    }
}
