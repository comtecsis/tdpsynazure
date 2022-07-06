package ws.synopsis.clients.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ws.synopsis.clients.dto.ClientDTO;

@RequestMapping("/clients")
public interface ClientController {
	@GetMapping("")
    List<ClientDTO> clients();
}
