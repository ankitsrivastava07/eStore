package ecommerce.user.order.controller;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateOrderRequest {

	private List<Order> ordersProduct;
	private DeliveryAddress address;
	private Long userId;
	private Long orderId;

}
