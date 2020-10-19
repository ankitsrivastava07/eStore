package ecommerce.admin.product.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequest {

	private Long id;
	private String name;
	private String description;
	private Double price;
	private String brandName;
	private Long quantity;
}
