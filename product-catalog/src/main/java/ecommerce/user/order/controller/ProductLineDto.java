package ecommerce.user.order.controller;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ProductLineDto {
	private Long id;
	private Long quantity;
}
