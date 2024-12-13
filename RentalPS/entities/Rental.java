package RentalPS.entities;

public class Rental {
    private int id;
    private String psName;
    private String rentalPeriod;
    private double price;

    public Rental(int id, String psName, String rentalPeriod, double price) {
        this.id = id;
        this.psName = psName;
        this.rentalPeriod = rentalPeriod;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getPsName() {
        return psName;
    }

    public String getRentalPeriod() {
        return rentalPeriod;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Rental ID: " + id + ", PS: " + psName + ", Periode: " + rentalPeriod + ", Harga: " + price;
    }
}