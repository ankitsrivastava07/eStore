package ecommerce.admin.product.service;

import java.util.List;
import java.util.Optional;

import ecommerce.admin.product.dto.ProductLineDto;

public interface ProductService {
	
	ProductLineDto create(ProductLineDto productDto);
	void delete(Long productId);
	ProductLineDto update(ProductLineDto productDto);
	List<ProductLineDto> findAll();
	Optional<ProductLineDto> findById(Long id);
}
