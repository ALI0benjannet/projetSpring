package org.esprim.gestionfoyer.services;

import org.esprim.gestionfoyer.entity.Bloc;
import org.esprim.gestionfoyer.entity.Chambre;
import org.esprim.gestionfoyer.entity.TypeChambre;

import java.util.List;

public interface ChambreService {
    // Méthodes CRUD de base
    List<Chambre> retrieveAllChambres();
    Chambre retrieveChambre(long idchambre);

    Chambre retrieveChambre(Long idchambre);

    Chambre addChambre(Chambre chambre);
    void removeChambre(Long idchambre);
    Chambre updateChambre(Chambre chambre);
    Chambre modifyChambre(Chambre c);

    // Méthodes de recherche avancées
    List<Chambre> getChambresParNomUniversite(String nomUniversite);
    List<Chambre> getChambresParBlocEtType(Long idBloc, TypeChambre typeC);

    List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);

    void nbPlacesDisponibleParChambreAnneeEnCours();
}