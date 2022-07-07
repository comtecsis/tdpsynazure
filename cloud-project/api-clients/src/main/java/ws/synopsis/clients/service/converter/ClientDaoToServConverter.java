package ws.synopsis.clients.service.converter;

import org.springframework.core.convert.converter.Converter;

import ws.synopsis.clients.dao.entity.ClientEntity;
import ws.synopsis.clients.service.dto.ClientDTO;

public class ClientDaoToServConverter implements Converter<ClientEntity, ClientDTO> {

	@Override
	public ClientDTO convert(ClientEntity source) {
		//@formatter:off
		return ClientDTO.builder()
			.id(source.getId())
			.name(source.getName())
			.lastname(source.getLastname())
			.docNum(source.getDocNum())
		.build();
		//@formatter:on
	}

}
