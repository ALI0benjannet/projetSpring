package org.esprim.gestionfoyer.services;

import lombok.AllArgsConstructor;
import org.esprim.gestionfoyer.entity.Bloc;
import org.esprim.gestionfoyer.entity.Chambre;
import org.esprim.gestionfoyer.repositories.BlocRepositorys;
import org.esprim.gestionfoyer.repositories.ChambreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class BlocServiceImp implements BlocService {

    private BlocRepositorys blocRepository;
    private ChambreRepository chambreRepository;

    @Override
    public List<Bloc> retrieveAllBlocs() {
        return List.of();
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return null;
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return null;
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return null;
    }

    @Override
    public void removeBloc(Long idBloc) {

    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numerochambre, Long idBloc) {
        // 1. Récupérer le bloc
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc non trouvé"));

        // 2. Récupérer toutes les chambres correspondant aux numéros
        List<Chambre> chambres = chambreRepository.findAllByNombreChambreIn(numerochambre);
        if (chambres.size() != numerochambre.size()) {
            throw new RuntimeException("Une ou plusieurs chambres sont introuvables.");
        }

        // 3. Associer chaque chambre au bloc et l'ajouter à l'ensemble du bloc
        for (Chambre chambre : chambres) {
            // Vérifier si la chambre est déjà affectée à un autre bloc
            if (chambre.getBloc() != null && !chambre.getBloc().getIdBloc().equals(idBloc)) {
                throw new RuntimeException(
                        "La chambre " + chambre.getNumerochambre() + " est déjà affectée à un autre bloc."
                );
            }

            // Associer la chambre au bloc
            chambre.setBloc(bloc);

            // Ajouter la chambre à l'ensemble du bloc
            bloc.getChambres().add(chambre);
        }

        return blocRepository.save(bloc);
    }

}
