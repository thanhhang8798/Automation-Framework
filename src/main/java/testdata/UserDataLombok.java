package testdata;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDataLombok {
//    @Getter(AccessLevel.PROTECTED)
    private String employeeFirstName;
    private String employeeLastName;
    private String editFirstName;
    private String editLastName;
    private String driverLicenseNumber;
    private String licenseExpiryDate;
    private String dateOfBirth;

    public static UserDataLombok getUserData() {
        return new UserDataLombok();
    }
}
