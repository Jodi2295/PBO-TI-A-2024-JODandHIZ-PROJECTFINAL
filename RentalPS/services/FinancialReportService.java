package RentalPS.services;

import RentalPS.repositories.FinancialReportRepository;

public class FinancialReportService {
    private FinancialReportRepository reportRepository;

    public FinancialReportService(FinancialReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public void recordRevenue(double amount) {
        reportRepository.recordRevenue(amount);
    }

    public void displayFinancialReport() {
        System.out.println("\nLaporan Keuangan:");
        System.out.println(reportRepository.getReport());
    }
}