package com.automacaopredial.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.automacaopredial.domain.Usuario;
import com.automacaopredial.dto.UsuarioDTO;
import com.automacaopredial.repositories.UsuarioRepository;
import com.automacaopredial.resources.exceptions.FieldMessage;

public class UsuarioUpdateValidator implements ConstraintValidator<UsuarioUpdate, UsuarioDTO> {

	@Autowired
	//pega o cabecalho do http
	private HttpServletRequest request;
	
	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public void initialize(UsuarioUpdate ann) {
	}

	@Override
	public boolean isValid(UsuarioDTO objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		//pega o id do htrp e converte em Map
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		Usuario aux = repo.findByEmail(objDto.getEmail());
		if (aux != null && !aux.getId().equals(uriId)) { //verifica se o email pertence a outro usuario
			list.add(new FieldMessage("email", "Email já existente"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage())
				   .addPropertyNode(e.getFieldName())
				   .addConstraintViolation();
		}
		return list.isEmpty();
	}
}