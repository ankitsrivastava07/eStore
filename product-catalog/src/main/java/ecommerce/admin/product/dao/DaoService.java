package ecommerce.admin.product.dao;

import java.util.List;
import java.util.Optional;

import ecommerce.admin.product.dto.ProductLineDto;

public interface DaoService {
	ProductLineDto create(ProductLineDto productDto);
	void delete(Long productId);
	ProductLineDto update(ProductLineDto productDto);
	List<ProductLineDto> findAll();
	Optional<ProductLineDto> findById(Long id);
}
