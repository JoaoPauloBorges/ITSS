package br.com.itss.SysParkingManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SysParkingManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysParkingManagementApplication.class, args);
	}

}
