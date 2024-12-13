package RentalPS.services;

import RentalPS.entities.Rental;

public class PaymentService {
    public void processPayment(Rental rental) {
        if (rental != null) {
            System.out.println("Pembayaran untuk PS: " + rental.getPsName() +
                    " dengan total: Rp " + rental.getPrice() + " berhasil.");
        } else {
            System.out.println("Rental tidak ditemukan!");
        }
    }
}