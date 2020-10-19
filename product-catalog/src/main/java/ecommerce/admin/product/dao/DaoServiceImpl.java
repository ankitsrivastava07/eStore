package ecommerce.admin.product.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.stereotype.Repository;

import ecommerce.admin.product.dao.entity.ProductEntity;
import ecommerce.admin.product.dao.repository.ProductRepository;
import ecommerce.admin.product.dto.ProductLineDto;
import ecommerce.common.ObjectTranslator;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class DaoServiceImpl implements DaoService {

	private ProductRepository productRepository;
	private ObjectTranslator objectTranslator;

	@Override
	public ProductLineDto create(ProductLineDto productDto) {
		ProductEntity productEntity = objectTranslator.translate(productDto, ProductEntity.class);
		return objectTranslator.translate(productRepository.save(productEntity), ProductLineDto.class);

	}

	@Override
	public ProductLineDto update(ProductLineDto productDto) {
		ProductEntity entity = objectTranslator.translate(productDto, ProductEntity.class);
		entity = productRepository.save(entity);
		return objectTranslator.translate(entity, ProductLineDto.class);

	}

	@Override
	public void delete(Long productId) {
		productRepository.deleteById(productId);
	}

	public List<ProductLineDto> findAll() {
		return objectTranslator.translateToList(productRepository.findAll(), ProductLineDto.class);

	}

	public Optional<ProductLineDto> findById(Long id) {

		ProductLineDto product = objectTranslator.translate(productRepository.findById(id), ProductLineDto.class);
		Function<ProductLineDto, Optional<ProductLineDto>> f = product2 -> Optional.of(product2);
		return f.apply(product);
	}

}
