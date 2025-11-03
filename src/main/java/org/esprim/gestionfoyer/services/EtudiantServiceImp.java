package org.esprim.gestionfoyer.services;

import org.esprim.gestionfoyer.entity.Etudiant;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EtudiantServiceImp implements EtudiantService{

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return List.of();
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return null;
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return null;
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return null;
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {

    }
}
