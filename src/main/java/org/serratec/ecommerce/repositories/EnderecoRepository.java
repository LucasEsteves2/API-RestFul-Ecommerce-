package org.serratec.ecommerce.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.serratec.ecommerce.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	@Transactional()
	List<Endereco> findByCidade(String cidade);
}
