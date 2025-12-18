package org.esprim.gestionfoyer.services;

import lombok.extern.slf4j.Slf4j;
import org.esprim.gestionfoyer.entity.Chambre;
import org.esprim.gestionfoyer.entity.TypeChambre;
import org.esprim.gestionfoyer.repositories.ChambreRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ChambreServiceImp implements ChambreService {

    private final ChambreRepository chambreRepository;

    public ChambreServiceImp(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    // ================= CRUD =================

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre retrieveChambre(long idchambre) {
        return chambreRepository.findById(idchambre).orElse(null);
    }

    @Override
    public Chambre retrieveChambre(Long idchambre) {
        return chambreRepository.findById(idchambre).orElse(null);
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public void removeChambre(Long idchambre) {
        chambreRepository.deleteById(idchambre);
    }

    @Override
    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    // ================= MÉTHODES MÉTIER =================

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        return chambreRepository.findChambreByNomUniversite(nomUniversite);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(Long idBloc, TypeChambre typeC) {
        return chambreRepository.trouverChambresByBlocAndType(idBloc, typeC);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepository.trouverChambresByBlocAndType(idBloc, typeC);
    }

    // ================= SERVICE 03 =================

    @Scheduled(fixedRate = 300000) // toutes les 5 minutes
    @Override
    public void nbPlacesDisponibleParChambreAnneeEnCours() {

        List<Chambre> chambres = chambreRepository.findAll();

        for (Chambre chambre : chambres) {

            int capaciteMax = getCapacite(chambre.getTypeC());
            int placesOccupees = chambre.getReservations().size();
            int placesDispo = capaciteMax - placesOccupees;

            if (placesDispo <= 0) {
                log.info("La chambre {} {} est complète",
                        chambre.getTypeC(),
                        chambre.getNumerochambre());
            } else {
                log.info("Le nombre de place disponible pour la chambre {} {} est {}",
                        chambre.getTypeC(),
                        chambre.getNumerochambre(),
                        placesDispo);
            }
        }
    }

    // ================= AUTRE SERVICE =================

    @Scheduled(cron = "0/15 * * * * *")
    public void pourcentageChambreParTypeChambre() {

        List<Chambre> chambres = chambreRepository.findAll();
        int totalChambres = chambres.size();

        log.info("Nombre total des chambres : {}", totalChambres);

        if (totalChambres > 0) {
            Map<String, Integer> countByType = new HashMap<>();

            for (Chambre chambre : chambres) {
                String type = chambre.getTypeC().name();
                countByType.put(type, countByType.getOrDefault(type, 0) + 1);
            }

            log.info("Pourcentage des chambres par type :");
            for (Map.Entry<String, Integer> entry : countByType.entrySet()) {
                double percentage = (entry.getValue() * 100.0) / totalChambres;
                log.info("Type {} : {} chambres ({}%)",
                        entry.getKey(),
                        entry.getValue(),
                        String.format("%.2f", percentage));
            }
        } else {
            log.warn("Aucune chambre trouvée !");
        }
    }

    // ================= MÉTHODE PRIVÉE =================

    private int getCapacite(TypeChambre type) {
        return switch (type) {
            case SIMPLE -> 1;
            case DOUBLE -> 2;
            case TRIPLE -> 3;
        };
    }
}
