package org.esprim.gestionfoyer.services;

import org.esprim.gestionfoyer.entity.Bloc;
import org.esprim.gestionfoyer.entity.Chambre;

import java.util.List;

public interface ChambreService {
    List<Chambre> retrieveAllChambres();
    Chambre retrieveChambre(long idchambre);
    Chambre addChambre(Chambre chambre);
    void removeChambre(Long idchambre);
    Chambre updateChambre(Chambre chambre);


    Chambre modifyChambre(Chambre c);
}
