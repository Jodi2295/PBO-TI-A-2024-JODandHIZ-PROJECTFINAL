package RentalPS.entities;

public class FinancialReport {
    private double totalRevenue;

    public FinancialReport() {
        this.totalRevenue = 0;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void addRevenue(double amount) {
        this.totalRevenue += amount;
    }

    @Override
    public String toString() {
        if (totalRevenue == (long) totalRevenue) {
            return String.format("Total Pendapatan: Rp %.0f", totalRevenue);
        } else {
            return String.format("Total Pendapatan: Rp %.2f", totalRevenue);
        }
    }
}