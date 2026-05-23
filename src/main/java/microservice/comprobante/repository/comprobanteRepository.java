package microservice.comprobante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import microservice.comprobante.model.comprobante;

public interface comprobanteRepository extends JpaRepository<comprobante, Long> {

    

    
}
