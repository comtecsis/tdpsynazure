package ws.synopsis.clients.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public interface ClientController {
	@RequestMapping("/greeting")
    String greeting();
}
