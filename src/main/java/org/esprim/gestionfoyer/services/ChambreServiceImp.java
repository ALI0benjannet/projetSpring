package org.esprim.gestionfoyer.services;

import org.esprim.gestionfoyer.entity.Chambre;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChambreServiceImp implements ChambreService {


    @Override
    public List<Chambre> retrieveAllChambres() {
        return List.of();
    }

    @Override
    public Chambre retrieveChambre(long idchambre) {
        return null;
    }

    @Override
    public Chambre addChambre(Chambre chambre) {
        return null;
    }

    @Override
    public void removeChambre(Long idchambre) {

    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return null;
    }

    @Override
    public Chambre modifyChambre(Chambre c) {
        return null;
    }
}
