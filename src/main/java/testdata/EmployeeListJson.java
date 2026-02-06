package testdata;

import core.GlobalConstants;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class EmployeeListJson {
    public static EmployeeListJson getEmployeeList() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(GlobalConstants.DATA_FILE_PATH + "EmployeeList.json"), EmployeeListJson.class);
    }

    public List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public static class Employee {
        private String name;
        private String age;
        private String email;

        public String getName() {
            return name;
        }

        public String getAge() {
            return age;
        }

        public String getEmail() {
            return email;
        }
    }
}
