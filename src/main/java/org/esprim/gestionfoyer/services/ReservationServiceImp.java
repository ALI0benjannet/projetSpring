package org.esprim.gestionfoyer.services;

import org.esprim.gestionfoyer.entity.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationServiceImp implements ReservationService {
    @Override
    public List<Reservation> retrieveAllReservations() {
        return List.of();
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return null;
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return null;
    }

    @Override
    public void removeReservation(String idReservation) {

    }
}
