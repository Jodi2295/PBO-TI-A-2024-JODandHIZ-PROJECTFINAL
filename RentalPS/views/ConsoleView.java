package RentalPS.views;

import RentalPS.services.RentalService;
import RentalPS.entities.Rental;
import RentalPS.entities.Review;
import RentalPS.repositories.FinancialReportRepository;
import RentalPS.services.FinancialReportService;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView {
    private static Scanner scanner = new Scanner(System.in);

    private static Map<Integer, Rental> rentals = new HashMap<>();
    private static RentalService rentalService = new RentalService(rentals);

    private static Map<String, String> registeredUsers = new HashMap<>();
    private static boolean isUserLoggedIn = false;
    private static String loggedInUsername = "";
    private static int rentalIdCounter = 1;

    private static Map<Integer, Review> reviews = new HashMap<>();

    private static FinancialReportRepository financialReportRepository = new FinancialReportRepository();
    private static FinancialReportService financialReportService = new FinancialReportService(financialReportRepository);

    public static void main(String[] args) {
        startApp();
    }

    public static void startApp() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Selamat datang di Sistem Rental");
            System.out.println("1. Daftar Akun");
            System.out.println("2. Login");
            System.out.println("3. Keluar");
            System.out.print("Pilih: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    register();
                    break;
                case "2":
                    login();
                    break;
                case "3":
                    isRunning = false;
                    System.out.println("Terima kasih karena sudah menggunakan sistem ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    public static void register() {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        registeredUsers.put(username, password);
        System.out.println("Pendaftaran berhasil! Silakan login dengan akun Anda.");
    }

    public static void login() {
        if (registeredUsers.isEmpty()) {
            System.out.println("Anda belum mendaftar, silakan mendaftar terlebih dahulu.");
            return;
        }

        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        if (registeredUsers.containsKey(username) && registeredUsers.get(username).equals(password)) {
            isUserLoggedIn = true;
            loggedInUsername = username;
            System.out.println("Login berhasil! Selamat datang, " + loggedInUsername + "!");
            showMainMenu();
        } else {
            System.out.println("Username atau password salah! Silakan coba lagi.");
        }
    }

    public static void showMainMenu() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tampilkan Semua Rental");
            System.out.println("2. Tambah Rental");
            System.out.println("3. Hapus Rental");
            System.out.println("4. Lakukan Pembayaran");
            System.out.println("5. Laporan Keuangan");
            System.out.println("6. Tambahkan Ulasan");
            System.out.println("7. Keluar dari menu utama");
            System.out.print("Pilih: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    rentalService.displayRentals(reviews);
                    break;
                case "2":
                    addRental();
                    break;
                case "3":
                    removeRental();
                    break;
                case "4":
                    makePayment();
                    break;
                case "5":
                    financialReportService.displayFinancialReport();
                    break;
                case "6":
                    reviewRental();
                    break;
                case "7":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    public static void addRental() {
        System.out.print("Masukkan PS yang ingin disewa (PS1, PS2, PS3, PS4, PS5): ");
        String psName = scanner.nextLine();
        System.out.print("Masukkan waktu sewa (per jam / per hari): ");
        String rentalPeriod = scanner.nextLine();

        double rentalPrice = calculateRentalPrice(psName, rentalPeriod);
        if (rentalPrice != -1) {
            Rental rental = new Rental(rentalIdCounter++, psName, rentalPeriod, rentalPrice);
            rentals.put(rental.getId(), rental);
            System.out.println("Rental berhasil ditambahkan dengan ID: " + rental.getId());
        } else {
            System.out.println("Nama PS atau waktu sewa tidak valid!");
        }
    }

    public static double calculateRentalPrice(String psName, String rentalPeriod) {
        double pricePerHour = 0, pricePerDay = 0;

        switch (psName) {
            case "PS1":
                pricePerHour = 4000;
                pricePerDay = 40000;
                break;
            case "PS2":
                pricePerHour = 6000;
                pricePerDay = 60000;
                break;
            case "PS3":
                pricePerHour = 8000;
                pricePerDay = 80000;
                break;
            case "PS4":
                pricePerHour = 10000;
                pricePerDay = 100000;
                break;
            case "PS5":
                pricePerHour = 12000;
                pricePerDay = 120000;
                break;
            default:
                return -1;
        }

        if (rentalPeriod.contains("jam")) {
            int hours = Integer.parseInt(rentalPeriod.replace(" jam", "").trim());
            return pricePerHour * hours;
        } else if (rentalPeriod.contains("hari")) {
            int days = Integer.parseInt(rentalPeriod.replace(" hari", "").trim());
            return pricePerDay * days;
        }

        return -1;
    }

    public static void makePayment() {
        System.out.print("Masukkan ID rental untuk melakukan pembayaran: ");
        int id = Integer.parseInt(scanner.nextLine());

        Rental rental = rentals.get(id);
        if (rental != null) {
            double amount = rental.getPrice();
            System.out.println("Pembayaran sebesar " + String.format("Rp %d", (int) amount) + " berhasil dilakukan.");

            financialReportService.recordRevenue(amount);

            rentals.remove(id);
            System.out.println("Rental dengan ID " + id + " telah dihapus.");
        } else {
            System.out.println("Rental dengan ID " + id + " tidak ditemukan!");
        }
    }

    public static void removeRental() {
        System.out.print("Masukkan ID rental yang ingin dihapus: ");
        int id = Integer.parseInt(scanner.nextLine());

        Rental rental = rentals.remove(id);
        if (rental != null) {
            System.out.println("Rental dengan ID " + id + " telah dihapus.");
        } else {
            System.out.println("Rental dengan ID " + id + " tidak ditemukan!");
        }
    }

    public static void reviewRental() {
        System.out.print("Masukkan ID rental yang ingin memberi ulasan: ");
        int rentalId = Integer.parseInt(scanner.nextLine());

        Rental rental = rentals.get(rentalId);
        if (rental != null) {
            System.out.print("Masukkan ulasan Anda: ");
            String reviewText = scanner.nextLine();

            Review review = new Review(rentalId, loggedInUsername, reviewText);
            reviews.put(rentalId, review);

            System.out.println("Ulasan berhasil ditambahkan!");
        } else {
            System.out.println("Rental dengan ID " + rentalId + " tidak ditemukan!");
        }
    }
}
