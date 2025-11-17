package org.esprim.gestionfoyer.services;

import lombok.AllArgsConstructor;
import org.esprim.gestionfoyer.entity.Foyer;
import org.esprim.gestionfoyer.entity.Universite;
import org.esprim.gestionfoyer.repositories.FoyerRepository;
import org.esprim.gestionfoyer.repositories.UniversiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UniversiteServiceImp implements UniversiteService{
    private UniversiteRepository universiteRepository;
    private FoyerRepository foyerRepository;
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

    @Override
    public Universite affecterFoyer(long idFoyer, String nomUniversite) {

        // 1. Vérifier si le foyer existe
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer introuvable avec ID : " + idFoyer));
//
        // 2. Vérifier si l'université existe
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite)
                .orElseThrow(()-> new RuntimeException("Université introuvable : " + nomUniversite));
//
        // 3. Vérifier si l'université n'a pas déjà un foyer
        if (universite.getFoyer() != null) {
            throw new RuntimeException("Cette université a déjà un foyer associé.");
        }

        // 4. Affecter le foyer à l'université
        universite.setFoyer(foyer);
        foyer.setUniversite(universite);

        // 5. Sauvegarder
         universiteRepository.save(universite);
         foyerRepository.save(foyer);
        return universite;
    }
    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {

        // 1. Récupérer l'université
        Optional<Universite> optionalUniversite = universiteRepository.findByIdUniversite(idUniversite);

        if (!optionalUniversite.isPresent()) {
            throw new RuntimeException("Université introuvable : " + idUniversite);
        }

        Universite universite = optionalUniversite.get();

        // 2. Vérifier qu'elle a un foyer
        if (universite.getFoyer() == null) {
            throw new RuntimeException("Cette université n'a aucun foyer à désaffecter.");
        }

        // 3. Désaffecter le foyer
        Foyer foyer = universite.getFoyer();
        universite.setFoyer(null);

        // 4. Sauvegarder
        universiteRepository.save(universite);

        return universite;
    }



}
