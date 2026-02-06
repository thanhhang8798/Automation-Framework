package testdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import core.GlobalConstants;
import tools.jackson.databind.ObjectMapper;

import java.io.File;

public class DataJson {
        public static DataJson getUser() {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(new File(GlobalConstants.DATA_FILE_PATH + "User.json"), DataJson.class);
        }

        @JsonProperty("employeeFirstName")
        private String employeeFirstName;

        @JsonProperty("employeeLastName")
        private String employeeLastName;

        @JsonProperty("editFirstName")
        private String editFirstName;

        @JsonProperty("editLastName")
        private String editLastName;

        @JsonProperty("driverLicenseNumber")
        private String driverLicenseNumber;

        @JsonProperty("licenseExpiryDate")
        private String licenseExpiryDate;

        @JsonProperty("dateOfBirth")
        private String dateOfBirth;

        public String getEmployeeFirstName() {
                return employeeFirstName;
        }

        public String getEmployeeLastName() {
                return employeeLastName;
        }

        public String getEditFirstName() {
                return editFirstName;
        }

        public String getEditLastName() {
                return editLastName;
        }

        public String getDriverLicenseNumber() {
                return driverLicenseNumber;
        }

        public String getLicenseExpiryDate() {
                return licenseExpiryDate;
        }

        public String getDateOfBirth() {
                return dateOfBirth;
        }
}
