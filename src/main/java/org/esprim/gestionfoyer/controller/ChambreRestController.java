package org.esprim.gestionfoyer.controller;

import lombok.AllArgsConstructor;
import org.esprim.gestionfoyer.entity.Chambre;
import org.esprim.gestionfoyer.services.ChambreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/chamber")
public class ChambreRestController {
    ChambreService chambreService;
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> retrieveAllChambres() {
        List<Chambre> chambreList = chambreService.retrieveAllChambres();
        return chambreList;
    }
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambreById(@PathVariable("chambre-id") Long chId) {
        Chambre chambre = chambreService.retrieveChambre(chId);
        return chambre;
    }
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }
    @DeleteMapping("remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId) {
        chambreService.removeChambre(chId);
    }
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.modifyChambre(c);
        return chambre;
    }
}
