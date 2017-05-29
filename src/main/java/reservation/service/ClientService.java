/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.service;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import reservation.entity.Client;

/**
 *
 * @author formation
 */
public interface ClientService extends CrudRepository<Client, Long>{
    
}
