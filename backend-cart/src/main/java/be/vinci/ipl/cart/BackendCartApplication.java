package be.vinci.ipl.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class BackendCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendCartApplication.class, args);
	}

}
