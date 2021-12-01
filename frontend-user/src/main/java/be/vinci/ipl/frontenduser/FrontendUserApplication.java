package be.vinci.ipl.frontenduser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableEurekaServer
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FrontendUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontendUserApplication.class, args);
	}

}
