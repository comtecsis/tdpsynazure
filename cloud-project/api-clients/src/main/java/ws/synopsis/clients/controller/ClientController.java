package ws.synopsis.clients.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ws.synopsis.clients.controller.request.dto.ClientAddReq;
import ws.synopsis.clients.controller.request.dto.ClientDelReq;
import ws.synopsis.clients.controller.response.dto.GeneralResp;
import ws.synopsis.clients.service.dto.ClientDTO;

@RequestMapping("/clients")
public interface ClientController {
	@GetMapping("")
	GeneralResp<List<ClientDTO>> list();
	@PostMapping("")
	GeneralResp<ClientDTO> add(@Valid @RequestBody ClientAddReq client);
	@DeleteMapping("")
	GeneralResp<?> remove(@Valid @RequestBody ClientDelReq id);
}
