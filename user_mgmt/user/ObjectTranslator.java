package com.estore.user_mgmt.user;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ObjectTranslator {
	private ModelMapper mapper = new ModelMapper();

	public <D> D translate(Object source, Class<D> destination) {
		return mapper.map(source, destination);
	}

}
