package pl.edu.pk.project.service;

import pl.edu.pk.project.model.Reservation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReservationService implements Service<Reservation> {
    Set<Reservation> reservations = new HashSet<>();

    public boolean add(Reservation reservation) {
        return reservations.add(reservation);
    }

    public Reservation get(String id) {
        for (Reservation reservation : reservations) {
            if (reservation.getId().equals(id)) {
                return reservation;
            }
        }
        return null;
    }

    public boolean remove(String id) {
        boolean isRemoved = false;
        for (Reservation reservation : reservations) {
            if (reservation.getId().equals(id)) {
                isRemoved = reservations.remove(reservation);
                break;
            }
        }
        return isRemoved;
    }

    public List<Reservation> getAll() {
        return new ArrayList<>(reservations);
    }
}
