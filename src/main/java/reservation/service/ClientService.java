/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.service;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import reservation.entity.Client;

/**
 *
 * @author formation
 */
@Repository
public interface ClientService extends CrudRepository<Client, Long>{
    @Query("SELECT c FROM Client c ORDER BY c.prenom, c.nom")
    public List<Client> findWithNomAndPrenom();
    Client findById(long id);
}
