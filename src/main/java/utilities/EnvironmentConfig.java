package utilities;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/${env}.properties"})
public interface EnvironmentConfig extends Config {
    @Config.Key("App.Url")
    String getAppUrl();

    @Config.Key("App.User")
    String getAppUser();

    @Config.Key("App.Pass")
    String getAppPassword();
}
