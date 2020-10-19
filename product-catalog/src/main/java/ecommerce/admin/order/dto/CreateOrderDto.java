package ecommerce.admin.order.dto;

import java.util.List;

import ecommerce.admin.order.controller.DeliveryAddress;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateOrderDto {
	private List<OrderProductDto> orderProduct;
	private UserDto user;
	private Long orderId;
	private DeliveryAddress address;

}
