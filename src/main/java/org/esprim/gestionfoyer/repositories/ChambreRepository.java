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
    //1Méthode JPQL

    List<Chambre> findAllByNumeroChambreIn(List<Long> numeroChambre);
    @Query("SELECT c FROM Chambre c " +
            "WHERE c.bloc.foyer.universite.nomUniversite = :nomUniversite")
    List<Chambre> getChambresParNomUniversite
            (@Param("nomUniversite") String nomUniversite);

    List<Chambre> findChambreByNomUniversite(String nomUniversite);
    //2Méthede Keyword
    List<Chambre> findChambreParBlocEtType(long idBloc, TypeChambre typeC);

    //1Méthode JPQL
    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeC = :typeC" )
    List<Chambre> trouverChambresByBlocAndType(long idBloc, TypeChambre typeC);
    //2Méthede Keyword
    List<Chambre> findChambreParBlocIdBlocAndTypeC(long idBloc, TypeChambre typeC);

    List<Chambre> findAllByNombreChambreIn(List<Long> numerochambre);
}