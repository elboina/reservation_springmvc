/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author formation
 */
@Controller
@RequestMapping("/")
public class HomePageController {
    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return "home";
    } 
            
}
