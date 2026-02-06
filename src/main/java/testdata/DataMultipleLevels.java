package testdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import core.GlobalConstants;
import tools.jackson.databind.ObjectMapper;

import java.io.File;

public class DataMultipleLevels {
    public static DataMultipleLevels getUser() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(GlobalConstants.DATA_FILE_PATH + "UserMultipleLevel.json"), DataMultipleLevels.class);
    }

    @JsonProperty("Register")
    Register register;
    static class Register {
        @JsonProperty("fullname")
        private String fullname;
    }

    @JsonProperty("Login")
    Login login;
    static class Login {
        @JsonProperty("username")
        private String username;

        @JsonProperty("password")
        private String password;
    }

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lasname")
    private String lasname;

    public String getFullName() {
        return register.fullname;
    }

    public String getUsername() {
        return login.username;
    }
    public String getPassword() {
        return login.password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLasname() {
        return lasname;
    }
}
