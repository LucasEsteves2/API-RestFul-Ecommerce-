package org.serratec.ecommerce.repositories;

import javax.transaction.Transactional;

import org.serratec.ecommerce.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	@Transactional()
	Categoria findByNome(String  categoria);
}
