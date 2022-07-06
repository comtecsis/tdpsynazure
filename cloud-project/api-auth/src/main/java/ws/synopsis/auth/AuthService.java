package ws.synopsis.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"file://${cloudproject.home}/properties/api-auth.properties"})
public class AuthService {
	public static void main(String[] args) {
		SpringApplication.run(AuthService.class, args);
	}
}
