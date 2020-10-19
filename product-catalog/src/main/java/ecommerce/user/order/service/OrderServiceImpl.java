package ecommerce.user.order.service;

import org.springframework.stereotype.Service;

import ecommerce.user.order.controller.CreateOrderResponse;
import ecommerce.user.order.dao.OrderDao;
import ecommerce.user.order.dto.CreateOrderDto;
import lombok.AllArgsConstructor;

@Service(value="orderService2")
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao;

	@Override
	public CreateOrderResponse create(CreateOrderDto createOrderDto) {
		return orderDao.create(createOrderDto);
	}

	@Override
	public CreateOrderResponse update(CreateOrderDto createOrderDto) {
		return orderDao.update(createOrderDto);
	}


	@Override
	public void cancelOrder(Long orderId) {
		orderDao.cancelOrder(orderId);
	}
}
