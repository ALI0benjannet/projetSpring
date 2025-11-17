package org.esprim.gestionfoyer.services;

import org.esprim.gestionfoyer.entity.Bloc;

import java.util.List;

public interface BlocService {
        List<Bloc> retrieveAllBlocs();
        Bloc retrieveBloc(Long idBloc);
        Bloc addBloc(Bloc bloc);
        Bloc updateBloc(Bloc bloc);
        void removeBloc(Long idBloc);
        Bloc affecterChambresABloc(List<Long> numChambre,Long idBloc);
}
