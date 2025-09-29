package org.esprim.gestionfoyer.entity;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;
    private Long numerochambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;


}
