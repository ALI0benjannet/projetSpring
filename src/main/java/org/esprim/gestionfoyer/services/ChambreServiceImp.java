package org.esprim.gestionfoyer.services;

import org.esprim.gestionfoyer.entity.Chambre;
import org.esprim.gestionfoyer.entity.TypeChambre;
import org.esprim.gestionfoyer.repositories.ChambreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreServiceImp implements ChambreService {

    private final ChambreRepository chambreRepository;

    // Injection par constructeur
    public ChambreServiceImp(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }


    @Override
    public List<Chambre> getChambresParBlocEtType(Long idBloc, TypeChambre typeC) {

        return chambreRepository.findChambresByBlocEtTypeJPQL(idBloc, typeC);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        return chambreRepository.findChambresByNomUniversite(nomUniversite);
    }

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre retrieveChambre(long idchambre) {
        return chambreRepository.findById(idchambre).orElse(null);
    }

    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void removeChambre(Long idchambre) {
        chambreRepository.deleteById(idchambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre modifyChambre(Chambre c) {
        return chambreRepository.save(c);
    }
}