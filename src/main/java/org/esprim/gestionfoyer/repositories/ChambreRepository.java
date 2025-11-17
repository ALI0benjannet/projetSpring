package org.esprim.gestionfoyer.repositories;

import org.esprim.gestionfoyer.entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findAllByNombreChambreIn(List<Long> numerochambre);


}
