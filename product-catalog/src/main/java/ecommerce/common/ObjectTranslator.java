package ecommerce.common;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ObjectTranslator {

	private ModelMapper mapper = new ModelMapper();

	public <D> D translate(Object source, Class<D> destination) {
		return mapper.map(source, destination);
	}

	public <D> List<D> translateToList(List<?> list, Class<D> destination) {

		return list.stream().map(e -> translate(e, destination)).collect(Collectors.toList());

	}
}
