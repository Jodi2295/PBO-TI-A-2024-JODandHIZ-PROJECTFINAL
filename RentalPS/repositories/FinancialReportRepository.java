package RentalPS.repositories;

import RentalPS.entities.FinancialReport;

public class FinancialReportRepository {
    private FinancialReport report;

    public FinancialReportRepository() {
        this.report = new FinancialReport();
    }

    public FinancialReport getReport() {
        return report;
    }

    public void recordRevenue(double amount) {
        report.addRevenue(amount);
    }
}