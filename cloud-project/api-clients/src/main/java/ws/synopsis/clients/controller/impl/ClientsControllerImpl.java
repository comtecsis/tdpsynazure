package ws.synopsis.clients.controller.impl;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ws.synopsis.clients.controller.ClientController;
import ws.synopsis.clients.controller.request.dto.ClientAddReq;
import ws.synopsis.clients.controller.request.dto.ClientDelReq;
import ws.synopsis.clients.controller.response.dto.GeneralResp;
import ws.synopsis.clients.controller.response.enumeration.StatusRespEnum;
import ws.synopsis.clients.service.dto.ClientDTO;
import ws.synopsis.clients.service.impl.ClientServiceImpl;

@RestController
@AllArgsConstructor
public class ClientsControllerImpl implements ClientController {

	private ClientServiceImpl service;

	@Override
	public GeneralResp<List<ClientDTO>> list() {
		return GeneralResp.<List<ClientDTO>>builder().status(StatusRespEnum.OK.status()).data(service.list()).build();
	}

	@Override
	public GeneralResp<ClientDTO> add(ClientAddReq client) {
		ClientDTO clientDto = service.add(client);
		return GeneralResp.<ClientDTO>builder().status(StatusRespEnum.OK.status()).data(clientDto).build();
	}

	@Override
	public GeneralResp<?> remove(ClientDelReq client) {
		service.remove(client.getId());
		return GeneralResp.builder().status(StatusRespEnum.OK.status()).build();
	}

}
