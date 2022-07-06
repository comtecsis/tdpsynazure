package ws.synopsis.auth.controller.impl;

import org.springframework.web.bind.annotation.RestController;

import ws.synopsis.auth.controller.HomeController;

@RestController
public class HomeControllerImpl implements HomeController {

	@Override
	public String home(String name) {
		return String.format("Hello %s!  welcome to the Security app", name);
	}

}
