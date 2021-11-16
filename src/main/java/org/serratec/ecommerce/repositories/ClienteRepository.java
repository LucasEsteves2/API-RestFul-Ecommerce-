package org.serratec.ecommerce.repositories;

import org.serratec.ecommerce.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
	Cliente findByEmail(String email); 


}
