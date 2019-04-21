package com.automacaopredial.services.validation;

public class EquipamentoUpdateValidator {// implements ConstraintValidator<EquipamentoUpdate, EquipamentoDTO> {
/*
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private EquipamentoRepository repo;
	
	@Override
	public void initialize(EquipamentoUpdate ann) {
	}

	@Override
	public boolean isValid(EquipamentoDTO objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		Equipamento aux = repo.findById(objDto.getId());
		if (aux != null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("equipamento", "Equipamento já existente"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
*/	
}
