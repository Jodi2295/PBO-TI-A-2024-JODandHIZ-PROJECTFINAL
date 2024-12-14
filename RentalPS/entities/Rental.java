package RentalPS.entities;

import java.time.LocalDateTime;

public class Rental {
    private int id;
    private String psName;
    private String rentalPeriod;
    private double price;
    private LocalDateTime endTime;
    private String status;

    public Rental(int id, String psName, String rentalPeriod, double price, LocalDateTime endTime) {
        this.id = id;
        this.psName = psName;
        this.rentalPeriod = rentalPeriod;
        this.price = price;
        this.endTime = endTime;
        this.status = "Unpaid";
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

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Rental ID: " + id + ", PS: " + psName + ", Periode: " + rentalPeriod + ", Harga: " + price + ", Status: " + status;
    }
}