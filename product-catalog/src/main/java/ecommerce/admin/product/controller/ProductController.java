package ecommerce.admin.product.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.admin.product.dto.ProductLineDto;
import ecommerce.admin.product.service.ProductService;
import ecommerce.common.ObjectTranslator;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
	private ObjectTranslator objectTranslator;
	private ProductService productService;

	@PostMapping
	public ProductLineDto create(@RequestBody CreateProductRequest createProductRequest) {
		ProductLineDto productLineDto = objectTranslator.translate(createProductRequest, ProductLineDto.class);
		return productService.create(productLineDto);
	}

	@PutMapping
	public ProductLineDto update(@RequestBody CreateProductRequest createProductRequest) {
		ProductLineDto productDto = objectTranslator.translate(createProductRequest, ProductLineDto.class);
		return productService.update(productDto);
	}

	@DeleteMapping("/{productId}")
	public void delete(@PathVariable("productId") Long productId) {
		productService.delete(productId);
	}

}
