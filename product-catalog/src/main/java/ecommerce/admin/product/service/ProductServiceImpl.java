package ecommerce.admin.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ecommerce.admin.product.dao.DaoService;
import ecommerce.admin.product.dto.ProductLineDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	private DaoService daoService;

	@Override
	public ProductLineDto create(ProductLineDto productDto) {
		return daoService.create(productDto);
	}

	@Override
	public ProductLineDto update(ProductLineDto productDto) {
		return daoService.update(productDto);
	}

	@Override
	public void delete(Long productId) {
		daoService.delete(productId);
		
	}

	@Override
	public List<ProductLineDto> findAll() {
		return daoService.findAll();
	}

	@Override
	public Optional<ProductLineDto> findById(Long id) {
		return daoService.findById(id);
	}

}
