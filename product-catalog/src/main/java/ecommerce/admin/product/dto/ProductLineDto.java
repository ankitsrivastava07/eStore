package ecommerce.admin.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductLineDto {
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String brandName;
	private Long quantity;
}
