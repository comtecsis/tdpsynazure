package ws.synopsis.clients.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CLIENT")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "LONG_CLIENT_ID")
    private Long id;
    
	@Column(name = "VCH_NAME", length = 100)
    private String name;
    
	@Column(name = "VCH_LASTNAME", length = 100)
    private String lastname;
    
	@Column(name = "VCH_DOCNUM", length = 100)
    private String docNum;
    
}
