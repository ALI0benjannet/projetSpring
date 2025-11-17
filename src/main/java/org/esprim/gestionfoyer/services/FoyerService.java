package org.esprim.gestionfoyer.services;

import org.esprim.gestionfoyer.entity.Foyer;
import org.esprim.gestionfoyer.entity.Universite;

import java.util.List;

public interface FoyerService {

    List<Foyer> retrieveAllFoyers();

    Foyer retrieveFoyer(Long idFoyer);

    Foyer addFoyer(Foyer foyer);

    Foyer updateFoyer(Foyer foyer);

    void removeFoyer(Long idFoyer);

}