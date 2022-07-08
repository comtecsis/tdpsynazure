package ws.synopsis.clients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"file://${cloudproject.home}/api-clients.properties", "file://${cloudproject.ssl.home}/project-ssl.properties"})
public class ApiClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiClientApplication.class, args);
	}
}
