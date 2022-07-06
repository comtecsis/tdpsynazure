package ws.synopsis.clients.controller.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import ws.synopsis.clients.controller.ClientController;
import ws.synopsis.clients.dto.ClientDTO;

@RestController
public class ClientsControllerImpl implements ClientController {

	@Value("${spring.application.name}")
	private String appName;

	@Override
	public List<ClientDTO> clients() {
		return Arrays.asList(ClientDTO.builder().id(1L).docNum("47666565").build());
	}

}
