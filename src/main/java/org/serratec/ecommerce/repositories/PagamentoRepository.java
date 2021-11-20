package org.serratec.ecommerce.repositories;

import org.serratec.ecommerce.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository  extends JpaRepository<Pagamento, Long>{

}
