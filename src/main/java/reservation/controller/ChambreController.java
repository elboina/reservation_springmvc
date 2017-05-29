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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.entity.Chambre;
import reservation.service.ChambreService;

/**
 *
 * @author formation
 */
@Controller
public class ChambreController {
    
    @Autowired
    private ChambreService chs;
    
    @RequestMapping(value = "/chambre/lister", method = RequestMethod.GET)
    public String lister(Model model) {
        List<Chambre> chambres = (List<Chambre>)chs.findAll();
        model.addAttribute("listeChambres", chambres);
        return "/chambre/lister.jsp";
    }
}
