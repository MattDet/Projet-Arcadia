package zoo.arcadia.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"zoo.arcadia.back.entity"})
@SpringBootApplication(scanBasePackages = {"zoo.arcadia.back.controller", "zoo.arcadia.back.service", "zoo.arcadia.back.repository", "zoo.arcadia.back.entity"})
@EnableJpaRepositories(basePackages = {"zoo.arcadia.back.repository"})
public class BackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackApplication.class, args);
	}

}
