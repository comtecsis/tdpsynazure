package ws.synopsis.clients.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

import ws.synopsis.clients.controller.ClientController;

@RestController
public class ClientsControllerImpl implements ClientController {

	@Autowired
	@Lazy
	private EurekaClient eurekaClient;
	
	@Value("${spring.application.name}")
    private String appName;

	@Override
	public String greeting() {
		return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
	}
}
