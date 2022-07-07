package ws.synopsis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"file://${cloudproject.home}/api-clients.properties", "file://${cloudproject.ssl.home}/project-ssl.properties"})
public class RegistryService {
	public static void main(String[] args) {
		SpringApplication.run(RegistryService.class, args);
	}
}
