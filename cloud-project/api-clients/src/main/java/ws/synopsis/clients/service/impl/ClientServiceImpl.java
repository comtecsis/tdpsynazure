package ws.synopsis.clients.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.ConversionService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ws.synopsis.clients.controller.request.dto.ClientAddReq;
import ws.synopsis.clients.dao.entity.ClientEntity;
import ws.synopsis.clients.dao.repository.ClientRepository;
import ws.synopsis.clients.service.ClientService;
import ws.synopsis.clients.service.dto.ClientDTO;

@Slf4j
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

	private ClientRepository repository;
	private ConversionService converters;

	@Override
	public List<ClientDTO> list() {
		return repository.findAll().stream().map((client) -> converters.convert(client, ClientDTO.class)).collect(Collectors.toList());
	}

	public ClientDTO add(ClientAddReq client) {
		ClientEntity entity = repository.save(converters.convert(client, ClientEntity.class));
		return converters.convert(entity, ClientDTO.class);
	}

	public void remove(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			log.error("El registro con id {} no existe.", id);
		}
	}

}
