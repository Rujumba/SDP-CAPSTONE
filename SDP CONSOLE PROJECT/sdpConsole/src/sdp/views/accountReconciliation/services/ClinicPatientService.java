package sdp.views.accountReconciliation.services;

import java.util.Date;
import java.util.List;

import sdp.models.patient.Patient;

public abstract class ClinicPatientService extends PatientService{

    public abstract void scheduleAppointment(long patientId, Date appointmentDate, String doctorName);

    public abstract List<Patient> getAppointmentsByDate(Date appointmentDate);

   public abstract List<Patient> getAppointmentsByDoctor(String doctorName);
}