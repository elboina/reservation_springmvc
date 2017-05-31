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
import reservation.entity.Client;
import reservation.service.ClientService;

/**
 *
 * @author formation
 */
@Controller
@RequestMapping(value = "/client")
public class ClientController {
    
    @Autowired
    private ClientService cls;
    
    @RequestMapping(value = "/lister", method = RequestMethod.GET)
    public String lister(Model model) {
        model.addAttribute("clients", cls.findWithNomAndPrenom());
        return "/client/lister.jsp";
    }
    
    @RequestMapping(value = "/supprimer/{id}", method = RequestMethod.GET)
    public String supprimer(@PathVariable("id") long idClient) {
        cls.delete(idClient);
        return "redirect:/client/lister";
    }
    
    @RequestMapping(value = "/modifier/{id}", method = RequestMethod.GET)
    public String modifierGet(@PathVariable("id") long idClient, Model model) {
        model.addAttribute("client", cls.findOne(idClient));
        return "/client/modifier.jsp";
    }
    
    @RequestMapping(value = "/modifier", method = RequestMethod.POST)
    public String modifierPost(@ModelAttribute("client") Client cl) {
        cls.save(cl);
        return "redirect:/client/lister";
    }
    
    @RequestMapping(value="/ajouter", method = RequestMethod.GET)
    public String ajouterGet(Model model) {
        model.addAttribute("client", new Client());
        return "/client/ajouter.jsp";
    }
    
    @RequestMapping(value = "/ajouter", method = RequestMethod.POST)
    public String ajouterPost(@ModelAttribute("client") Client c) {
        cls.save(c);
        return "redirect:/client/lister";
    }
    
}
