package ws.synopsis.clients.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
	private Long id;
	private String name;
	private String lastname;
	private String docNum;
}
