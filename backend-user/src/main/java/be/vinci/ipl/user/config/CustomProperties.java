package be.vinci.ipl.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("be.vinci.ipl.user")
public class CustomProperties {

    private String api;

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
