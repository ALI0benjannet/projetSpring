package org.esprim.gestionfoyer.services;

import org.esprim.gestionfoyer.entity.Bloc;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlocServiceImp implements BlocService {
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
}
