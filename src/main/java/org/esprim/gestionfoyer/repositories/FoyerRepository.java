package org.esprim.gestionfoyer.repositories;

import org.esprim.gestionfoyer.entity.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer, Long> {
    interface UniversiteRepository {
    }
}
