package ecommerce.user.order.dao;

import ecommerce.user.order.controller.CreateOrderResponse;
import ecommerce.user.order.dto.CreateOrderDto;

public interface OrderDao {

	CreateOrderResponse create(CreateOrderDto createOrderDto);

	void cancelOrder(Long orderId);

	CreateOrderResponse update(CreateOrderDto createOrderDto);

}
