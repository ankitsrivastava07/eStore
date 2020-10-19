package ecommerce.admin.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderProductDto {
	private ProductLineDto product;
	private Long productQuantity;
}
