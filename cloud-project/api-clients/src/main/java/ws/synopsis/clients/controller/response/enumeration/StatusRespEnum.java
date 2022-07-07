package ws.synopsis.clients.controller.response.enumeration;

import lombok.ToString;
import ws.synopsis.clients.controller.response.dto.StatusResp;

@ToString
public enum StatusRespEnum {
	
	OK("0000", "Operacion satisfactoria.");

	private StatusResp status;

	StatusRespEnum(String code, String message) {
		status = StatusResp.builder().code(code).message(message).build();
	}
	
	public StatusResp status() {
		return status;
	}

}
