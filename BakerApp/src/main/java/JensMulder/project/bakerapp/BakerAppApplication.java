package JensMulder.project.bakerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class BakerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BakerAppApplication.class, args);
	}
}
