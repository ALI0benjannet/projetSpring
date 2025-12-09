package org.esprim.gestionfoyer.services;

import lombok.extern.slf4j.Slf4j;
import org.esprim.gestionfoyer.entity.Bloc;
import org.esprim.gestionfoyer.entity.Chambre;
import org.esprim.gestionfoyer.repositories.BlocRepositorys;
import org.esprim.gestionfoyer.repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class BlocServiceImp implements BlocService {

    @Autowired
    private BlocRepositorys blocRepository;

    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException(
                        "Bloc not found with id : " + idBloc));
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, Long idBloc) {
        return null;
    }

    @Override
    public Bloc affecterChambreABloc(List<Long> numeroChambre, Long idBloc) {

        // Récupérer le bloc
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException(
                        "Bloc introuvable avec cet id : " + idBloc));

        // Récupérer les chambres via leurs numéros
        List<Chambre> chambres =
                chambreRepository.findAllByNumeroChambreIn(numeroChambre);

        if (chambres.size() != numeroChambre.size()) {
            throw new RuntimeException("Une ou plusieurs chambres sont introuvables");
        }


        //Affecter chaque chambre au bloc
        for (Chambre chambre : chambres) {

            if (chambre.getBloc() != null) {
                throw new RuntimeException(
                        "La chambre numéro " + chambre.getNumerochambre()
                                + " appartient déjà au bloc : "
                                + chambre.getBloc().getNomBloc());
            }

            chambre.setBloc(bloc);
        }


        //Sauvegarder les chambres modifiées
        chambreRepository.saveAll(chambres);

        //Retourner le bloc mis à jour
        return bloc;
    }
    @Scheduled(cron = "0 * * * * *")  // toutes les minutes
    public void listeChambresParBloc() {

        List<Bloc> blocs = blocRepository.findAll();

        if (!blocs.isEmpty()) {
            for (Bloc bloc : blocs) {
                log.info("Bloc => " + bloc.getNomBloc() +
                        " ayant une capacité " + bloc.getCapaciteBloc());
            }
        }
    }

}