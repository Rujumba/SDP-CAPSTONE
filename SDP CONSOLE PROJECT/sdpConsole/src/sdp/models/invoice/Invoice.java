package sdp.models.invoice;

import sdp.models.medicalServiceModel.MedicalService;

import java.util.List;

public class Invoice {
    private int invoiceId;
    private List<MedicalService> medicalServices;
    private double totalAmount;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public List<MedicalService> getMedicalServices() {
        return medicalServices;
    }

    public void setMedicalServices(List<MedicalService> medicalServices) {
        this.medicalServices = medicalServices;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Invoice(int invoiceId, List<MedicalService> medicalServices, double totalAmount) {
        this.invoiceId = invoiceId;
        this.medicalServices = medicalServices;
        this.totalAmount = totalAmount;
    }
}
