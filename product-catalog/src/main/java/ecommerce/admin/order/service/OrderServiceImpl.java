package ecommerce.admin.order.service;

import org.springframework.stereotype.Service;

import ecommerce.admin.order.dao.OrderDao;
import ecommerce.admin.order.dto.CreateOrderDto;
import ecommerce.admin.order.dto.CreateOrderResponse;
import lombok.AllArgsConstructor;

@Service(value = "orderService")
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
