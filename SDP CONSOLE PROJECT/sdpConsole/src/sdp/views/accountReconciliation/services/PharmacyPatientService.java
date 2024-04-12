package sdp.views.accountReconciliation.services;

import java.util.List;

import sdp.models.patient.Patient;

public abstract class PharmacyPatientService extends PatientService {

    // void dispenseMedication(long patientId, List<Medication> medications);
   public abstract List<Patient> getMedicationDispensedPatients();
    // public void medicatePatient(List<Medication> medications);
}