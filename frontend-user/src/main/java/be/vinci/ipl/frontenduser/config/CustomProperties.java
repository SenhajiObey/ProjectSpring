package be.vinci.ipl.frontenduser.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "be.vinci.ipl.service")
public class CustomProperties {

    private String api;
    private String secret;

    public String getSecret(){
        return secret;
    }


    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
