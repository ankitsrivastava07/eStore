package ecommerce.user.order.service;

import ecommerce.user.order.controller.CreateOrderResponse;
import ecommerce.user.order.dto.CreateOrderDto;

public interface OrderService {

	CreateOrderResponse create(CreateOrderDto createOrderDto);

	CreateOrderResponse update(CreateOrderDto createOrderDto);

	void cancelOrder(Long productId);

}
