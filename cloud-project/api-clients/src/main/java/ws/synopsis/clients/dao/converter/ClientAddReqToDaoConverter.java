package ws.synopsis.clients.dao.converter;

import org.springframework.core.convert.converter.Converter;

import ws.synopsis.clients.controller.request.dto.ClientAddReq;
import ws.synopsis.clients.dao.entity.ClientEntity;

public class ClientAddReqToDaoConverter implements Converter<ClientAddReq, ClientEntity> {

	@Override
	public ClientEntity convert(ClientAddReq source) {
		return ClientEntity.builder()
				.name(source.getName())
				.lastname(source.getLastname())
				.docNum(source.getDocNum())
				.build();
	}

}
