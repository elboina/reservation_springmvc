/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.service;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import reservation.entity.Chambre;

/**
 *
 * @author formation
 */
public interface ChambreService extends CrudRepository<Chambre, Long> {
    
}
