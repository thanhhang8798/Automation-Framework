package testdata;

import core.GlobalConstants;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class DataJsonArray {
    public static DataJsonArray getEmployee() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(GlobalConstants.DATA_FILE_PATH + "JsonArray.json"), DataJsonArray.class);
    }

    private String name;
    private String position;

    private List<String> skilltree;

    Address address;
    public static class Address {
        private String street;
        private String streetNo;

        public String getStreet() {
            return street;
        }

        public String getStreetNo() {
            return streetNo;
        }
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public List<String> getSkilltree() {
        return skilltree;
    }
}
