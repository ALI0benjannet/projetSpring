package org.esprim.gestionfoyer.controller;

import lombok.AllArgsConstructor;
import org.esprim.gestionfoyer.entity.Bloc;
import org.esprim.gestionfoyer.services.BlocService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController  {
    BlocService blocService;
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> retrieveAllBlocs() {
        BlocService blocService = null;
        List<Bloc> blocList = blocService.retrieveAllBlocs();
        return blocList;
    }

    // 🔹 GET : récupérer un bloc par ID
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBlocById(@PathVariable("bloc-id") Long blocId) {
        Bloc bloc = blocService.retrieveBloc(blocId);
        return bloc;
    }

    // 🔹 POST : ajouter un bloc
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.addBloc(b);
        return bloc;
    }

    // 🔹 DELETE : supprimer un bloc
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long blocId) {
        blocService.removeBloc(blocId);
    }

    // 🔹 PUT : modifier un bloc
    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.updateBloc(b);
        return bloc;
    }
}
