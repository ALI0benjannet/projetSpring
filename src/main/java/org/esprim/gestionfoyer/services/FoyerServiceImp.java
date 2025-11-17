package org.esprim.gestionfoyer.services;

import org.esprim.gestionfoyer.entity.Foyer;
import org.esprim.gestionfoyer.entity.Universite;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoyerServiceImp implements FoyerService {

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return List.of();
    }

    @Override
    public Foyer retrieveFoyer(Long idFoyer) {
        return null;
    }

    @Override
    public Foyer addFoyer(Foyer foyer) {
        return null;
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return null;
    }

    @Override
    public void removeFoyer(Long idFoyer) {

    }


}
