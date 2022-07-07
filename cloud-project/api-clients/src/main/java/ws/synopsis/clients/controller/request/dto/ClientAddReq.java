package ws.synopsis.clients.controller.request.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientAddReq {
	@NotNull
	private String name;
	@NotNull
	private String lastname;
	@NotNull
	private String docNum;
}
