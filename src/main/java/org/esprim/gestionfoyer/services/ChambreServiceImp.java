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

    @Override
    public List<Chambre> retrieveAllChambres() {
        return List.of();
    }

    @Override
    public Chambre retrieveChambre(long idchambre) {
        return null;
    }

    @Override
    public Chambre retrieveChambre(Long idchambre) {
        return null;
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return null;
    }

    @Override
    public void removeChambre(Long idchambre) {

    }

    @Override
    public Chambre modifyChambre(Chambre chambre) {
        return null;
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return null;
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        return chambreRepository.findChambreByNomUniversite(nomUniversite);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(Long idBloc, TypeChambre typeC) {
        return List.of();
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepository.trouverChambresByBlocAndType(idBloc, typeC);
    }


    @Override
    public void nbPlacesDisponibleParChambreAnneeEnCours() {

    }

    @Scheduled(cron = "0/15 * * * * *")
    public void pourcentageChambreParTypeChambre() {
        List<Chambre> chambres = chambreRepository.findAll();

        int totalChambres = chambres.size();
        log.info("Nombre totale des chambres: "+ totalChambres);
        if (totalChambres > 0) {
            //parcourir la liste des chambres pour compter les Types
            Map<String ,Integer> countByType = new HashMap<>();
            for (Chambre chambre : chambres) {
                String type = String.valueOf(chambre.getTypeC());
                countByType.put(type, countByType.getOrDefault(type, 0) + 1);
            }
            // Calcul et affichage des pourcentages
            log.info(" Pourcentage des chambres par type :");
            for (Map.Entry<String, Integer> entry : countByType.entrySet()) {
                String type = entry.getKey();
                int count = entry.getValue();
                double percentage = (count * 100.0) / totalChambres;

                log.info("Type " + type + " : " + count + " chambres (" + String.format("%.2f", percentage) + "%)");
            }
        } else {
            log.warn("Aucune chambre trouvée !");
        }
    }
}