package org.serratec.ecommerce.services.validacao;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.serratec.ecommerce.controller.exception.FieldMessage;
import org.serratec.ecommerce.dto.ClienteNewDTO;
import org.serratec.ecommerce.entity.Cliente;
import org.serratec.ecommerce.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert2, ClienteNewDTO> {

	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert2 ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		

		Cliente aux = repo.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}