/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.service;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import reservation.entity.Chambre;

/**
 *
 * @author formation
 */
public interface ChambreService extends CrudRepository<Chambre, Long> {
    public ArrayList<Chambre> findAllByHotelAdresseLocaliteAndNbPersonnesGreaterThan(String localite, int nbPersonnes);
    
    @Query("SELECT c "
            + "FROM Chambre c "
            + "JOIN c.hotel h "
            + "WHERE h.adresse.localite = ?1 "
            + "AND c.nbPersonnes >= ?2 "
            + " EXCEPT "
            + "SELECT c "
            + " FROM Chambre c "
            + " JOIN c.reservations r "
            + " WHERE r.dateCheckOut >= ?3 "
            + " AND r.dateCheckIn <= ?4"
            )
    public ArrayList<Chambre> rechercherChambresParVilleCapaciteDates(String localite, int nbPersonnes, Date dateArrivee, Date dateSortie);
    
}
