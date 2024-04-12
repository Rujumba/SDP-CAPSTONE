package sdp.repository;

import sdp.models.medicalServiceModel.MedicalService;

import java.util.List;

public interface IMedicalServiceRepository {
    void save(MedicalService medicalService);
    List<MedicalService> getMedicalServices();
    MedicalService getMedicalService(String name);


}
