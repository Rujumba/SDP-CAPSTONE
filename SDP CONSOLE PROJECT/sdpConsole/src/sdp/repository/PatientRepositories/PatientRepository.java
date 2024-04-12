package sdp.repository.PatientRepositories;

import java.util.ArrayList;
import java.util.List;
import sdp.models.patient.Patient;


public class PatientRepository {
    private List<Patient> patientsList = new ArrayList<>();

    public List<Patient> getPatientsList() {
        return patientsList;
    }

    public void setPatientsList(List<Patient> patientsList) {
        this.patientsList = patientsList;
    }

    public void addPatient(Patient patient){
        patientsList.add(patient);
    }
    
}
