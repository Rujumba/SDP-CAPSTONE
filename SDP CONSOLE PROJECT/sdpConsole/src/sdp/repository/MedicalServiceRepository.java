package sdp.repository;

import sdp.models.medicalServiceModel.MedicalService;

import java.util.ArrayList;
import java.util.List;

public class MedicalServiceRepository implements IMedicalServiceRepository {

    private List<MedicalService> medicalServiceList = new ArrayList<>();
    private MedicalService medicalService;


    public MedicalServiceRepository() {
//      medicalServiceList.add(0, new MedicalService("X-ray", 900.8));
//      medicalServiceList.add(1, new MedicalService("Consultation", 450.0));
    }

    @Override
    public void save(MedicalService medicalService) {
        medicalServiceList.add(medicalService);
    }

    @Override
    public List<MedicalService> getMedicalServices() {
        return medicalServiceList;
    }

    @Override
    public MedicalService getMedicalService(String name) {
        return medicalService;
    }


    public List<MedicalService> getMedicalServiceList() {
        return medicalServiceList;
    }

    public void setMedicalServiceList(List<MedicalService> medicalServiceList) {
        this.medicalServiceList = medicalServiceList;
    }
}
