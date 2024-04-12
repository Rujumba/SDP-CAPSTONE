package sdp.views.accountReconciliation.services;

import sdp.views.accountReconciliation.services.Impl.HospitalPatientServiceImpl;
import sdp.views.accountReconciliation.services.Impl.PharmacyPatientServiceImpl;
import sdp.views.accountReconciliation.services.Impl.ClinicPatientServiceImpl;

public class PatientServiceFactory {

    public static PatientService createService(String facilityType) {
        if (facilityType.equalsIgnoreCase("hospital")) {
            return new HospitalPatientServiceImpl();
        } else if (facilityType.equalsIgnoreCase("pharmacy")) {
            return new ClinicPatientServiceImpl();
        } else if (facilityType.equalsIgnoreCase("clinic")) {
            return new PharmacyPatientServiceImpl();
        } else {
            throw new IllegalArgumentException("Invalid facility type");
        }
    }
}
