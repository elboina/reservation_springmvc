/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import reservation.entity.Utilisateur;

/**
 *
 * @author formation
 */
@Repository
public interface UtilisateurServiceCRUD extends CrudRepository<Utilisateur, Long>{
    public Utilisateur findByIdentifiantAndMotDePasse(String identifiant, String motDePasse);
    
}
