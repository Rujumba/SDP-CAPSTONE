package sdp.views.accountReconciliation.services.Impl;

import java.util.Date;
import java.util.List;

import sdp.models.patient.Patient;
import sdp.views.accountReconciliation.services.ClinicPatientService;

public class ClinicPatientServiceImpl extends ClinicPatientService{


    @Override
    public void scheduleAppointment(long patientId, Date appointmentDate, String doctorName) {
        throw new UnsupportedOperationException("Unimplemented method 'scheduleAppointment'");
    }

    @Override
    public List<Patient> getAppointmentsByDate(Date appointmentDate) {
        throw new UnsupportedOperationException("Unimplemented method 'getAppointmentsByDate'");
    }

    @Override
    public List<Patient> getAppointmentsByDoctor(String doctorName) {
        throw new UnsupportedOperationException("Unimplemented method 'getAppointmentsByDoctor'");
    }

    
}
