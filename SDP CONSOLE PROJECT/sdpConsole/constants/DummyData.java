package sdpConsole.constants;

import java.util.ArrayList;
import java.util.List;

public class DummyData {
    private List<String> district;

    private List<String> healthFacility;

    public DummyData(){
        // Initialize district list
        district = new ArrayList<>();
        // Add dummy data to district list
        district.add("Kampala");
        district.add("Mbarara");
        district.add("Jinja");

        // Initialize the health facility list
        healthFacility = new ArrayList<>();
        // Add dummy data to dummyData list
        healthFacility.add("Pharmacy");
        healthFacility.add("Hospital");
        healthFacility.add("Clinic");
    }

    public List<String> getDistrict() {
        return district;
    }

    public void setDistrict(List<String> district) {
        this.district = district;
    }

    public List<String> getHealthFacility() {
        return healthFacility;
    }

    public void setHealthFacility(List<String> healthFacility) {
        this.healthFacility = healthFacility;
    }
}
