package org.esprim.gestionfoyer.repositories;

import org.esprim.gestionfoyer.entity.Chambre;
import org.esprim.gestionfoyer.entity.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findAllByNombreChambreIn(List<Long> numerochambre);
    @Query("SELECT c " +
            "FROM Chambre c " +
            "WHERE c.bloc.foyer.universite.nomUniversite"+ " = :nomUniversite")
    List<Chambre> findChambresByNomUniversite(@Param("nomUniversite") String nomUniversite);

    @Query("SELECT c " +
            "FROM Chambre c" +
            " WHERE c.bloc.idBloc = :idBloc AND c.typeC = :typeC")
    List<Chambre> findChambresByBlocEtTypeJPQL(Long idBloc, TypeChambre typeC);


    List<Chambre> findAllByBlocIdBlocAndTypeC(Long idBloc, TypeChambre typeC);
}
