package ecommerce.admin.order.dao;

import ecommerce.admin.order.dto.CreateOrderDto;
import ecommerce.admin.order.dto.CreateOrderResponse;

public interface OrderDao {

	CreateOrderResponse create(CreateOrderDto createOrderDto);

	void cancelOrder(Long orderId);

	CreateOrderResponse update(CreateOrderDto createOrderDto);

}
