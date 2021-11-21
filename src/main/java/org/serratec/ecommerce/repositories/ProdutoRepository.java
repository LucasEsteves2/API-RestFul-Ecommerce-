package org.serratec.ecommerce.repositories;

import javax.transaction.Transactional;

import org.serratec.ecommerce.entity.Cliente;
import org.serratec.ecommerce.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Transactional()
	Produto findByNome(String  nome);
}

