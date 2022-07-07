package ws.synopsis.clients.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ws.synopsis.clients.dao.entity.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long>{

}
