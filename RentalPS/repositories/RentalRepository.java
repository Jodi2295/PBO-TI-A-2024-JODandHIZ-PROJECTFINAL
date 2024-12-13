package RentalPS.repositories;

import RentalPS.entities.Rental;
import java.util.ArrayList;
import java.util.List;

public class RentalRepository {
    private List<Rental> rentals = new ArrayList<>();

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public Rental findRentalById(int id) {
        for (Rental rental : rentals) {
            if (rental.getId() == id) {
                return rental;
            }
        }
        return null;
    }

    public void removeRental(int id) {
        rentals.removeIf(rental -> rental.getId() == id);
    }
}