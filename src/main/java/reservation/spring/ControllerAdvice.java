/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.spring;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author formation
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.getModel().put("Les données indiquées ne sont pas correctes", e.getMessage());
        mav.setViewName("erreur");
        return mav;
    }
}
