package sdp.views.accountReconciliation.services;

import java.util.Date;
import java.util.List;
import sdp.models.patient.Patient;

public abstract class HospitalPatientService extends PatientService {

    public abstract void admitPatient(long patientId, Date admissionDate);

    public abstract void dischargePatient(long patientId, Date dischargeDate);

    public abstract List<Patient> getAdmittedPatients();

    public abstract List<Patient> getDischargedPatients();
}