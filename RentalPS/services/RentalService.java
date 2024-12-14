package RentalPS.services;

import RentalPS.entities.Rental;
import RentalPS.entities.Review;
import java.util.Map;
import java.util.Scanner;

public class RentalService {
    private Map<Integer, Rental> rentals;
    private Scanner scanner = new Scanner(System.in);

    public RentalService(Map<Integer, Rental> rentals) {
        this.rentals = rentals;
    }

    public void displayRentals(Map<Integer, Review> reviews) {
        if (rentals.isEmpty()) {
            System.out.println("Tidak ada rental untuk ditampilkan.");
        } else {
            for (Rental rental : rentals.values()) {
                System.out.println(String.format("ID: %d, PS: %s, Waktu Sewa: %s, Harga: Rp %d, Status: %s",
                        rental.getId(),
                        rental.getPsName(),
                        rental.getRentalPeriod(),
                        (int) rental.getPrice(),
                        rental.getStatus()));

                Review review = reviews.get(rental.getId());
                if (review != null) {
                    System.out.println("Ulasan: " + review.getReviewText());
                } else {
                    System.out.println("Ulasan: Belum ada ulasan.");
                }
            }
        }
    }

    public void addRental(Rental rental) {
        rentals.put(rental.getId(), rental);
    }

    public void removeRental(int rentalId) {
        rentals.remove(rentalId);
    }
}