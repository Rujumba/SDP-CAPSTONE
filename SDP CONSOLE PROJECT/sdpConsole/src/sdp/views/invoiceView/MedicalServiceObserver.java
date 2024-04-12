package sdp.views.invoiceView;

import sdp.models.medicalServiceModel.MedicalService;

public interface MedicalServiceObserver {
    void update(MedicalService medicalService);
}
