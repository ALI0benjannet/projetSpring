package org.esprim.gestionfoyer.services;

import org.esprim.gestionfoyer.entity.Universite;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UniversiteServiceImp implements UniversiteService{
    @Override
    public List<Universite> retrieveAllUniversites() {
        return List.of();
    }

    @Override
    public Universite retrieveUniversite(Long idUniversite) {
        return null;
    }

    @Override
    public Universite addUniversite(Universite universite) {
        return null;
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return null;
    }

    @Override
    public void removeUniversite(Long idUniversite) {

    }
}
