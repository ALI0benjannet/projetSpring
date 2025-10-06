package org.esprim.gestionfoyer.repositories;

import org.esprim.gestionfoyer.entity.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocRepositorys extends JpaRepository<Bloc, Long> {

}
