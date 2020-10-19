package ecommerce.admin.order.service;

import ecommerce.admin.order.dto.CreateOrderDto;
import ecommerce.admin.order.dto.CreateOrderResponse;

public interface OrderService {

	CreateOrderResponse create(CreateOrderDto createOrderDto);

	CreateOrderResponse update(CreateOrderDto createOrderDto);

	void cancelOrder(Long productId);

}
