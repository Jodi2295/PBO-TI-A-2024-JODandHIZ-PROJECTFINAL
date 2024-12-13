package RentalPS.services;

import RentalPS.entities.Rental;
import RentalPS.entities.Review;
import java.util.Map;

public class RentalService {
    private Map<Integer, Rental> rentals;

    public RentalService(Map<Integer, Rental> rentals) {
        this.rentals = rentals;
    }

    public void displayRentals(Map<Integer, Review> reviews) {
        if (rentals.isEmpty()) {
            System.out.println("Tidak ada rental untuk ditampilkan.");
        } else {
            for (Rental rental : rentals.values()) {
                System.out.println(String.format("ID: %d, PS: %s, Waktu Sewa: %s, Harga: Rp %d",
                        rental.getId(),
                        rental.getPsName(),
                        rental.getRentalPeriod(),
                        (int) rental.getPrice()));

                Review review = reviews.get(rental.getId());
                if (review != null) {
                    System.out.println("Ulasan Oleh ID Rental " + review);
                }
            }
        }
    }
}