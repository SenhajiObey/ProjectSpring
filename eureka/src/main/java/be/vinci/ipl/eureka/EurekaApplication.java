package be.vinci.ipl.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
public class EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}

	@SpringBootApplication
	@EnableEurekaServer
	public static class RegistryApplication {
		public static void main(String[] args) {
			SpringApplication.run(RegistryApplication.class, args);
		}
	}
}