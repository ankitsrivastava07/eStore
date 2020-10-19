package ecommerce.user.order.dao;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ecommerce.admin.product.dao.entity.ProductEntity;
import ecommerce.admin.product.dao.repository.ProductRepository;
import ecommerce.common.ObjectTranslator;
import ecommerce.common.ProductOutOfStock;
import ecommerce.user.order.OrderStatus;
import ecommerce.user.order.controller.CreateOrderResponse;
import ecommerce.user.order.dao.entity.OrderEntity;
import ecommerce.user.order.dao.entity.OrderProductEntity;
import ecommerce.user.order.dao.repository.OrderRepository;
import ecommerce.user.order.dto.CreateOrderDto;
import ecommerce.user.order.dto.OrderProductDto;
import ecommerce.user.order.dto.ProductLineDto;
import lombok.AllArgsConstructor;

@Repository(value = "orderDao2")
@AllArgsConstructor
public class OrderDaoImpl implements OrderDao {

	private ObjectTranslator objectTranslator;
	private ProductRepository productRepsitory;
	private OrderRepository orderRepository;
	private JdbcTemplate jdbcTemplate;

	@Override
	public CreateOrderResponse create(CreateOrderDto createOrderDto) {
		OrderEntity order = objectTranslator.translate(createOrderDto, OrderEntity.class);
		order.setTotalAmount(totalAmount(createOrderDto));
		order = orderRepository.save(order);
		return objectTranslator.translate(order, CreateOrderResponse.class);
	}

	@Override
	public void cancelOrder(Long orderId) {
		OrderEntity order = orderRepository.getOne(orderId);
		order.setStatus(OrderStatus.CANCELLED.toString());
		order = orderRepository.save(order);
	}

	@Override
	public CreateOrderResponse update(CreateOrderDto createOrderDto) {

		OrderEntity order = orderRepository.findById(createOrderDto.getOrderId()).get();

		List<OrderProductEntity> products = order.getOrder();

		List<OrderProductDto> product = createOrderDto.getOrderProduct();

		String sql = "update order_products set product_id=?,quantity =? where id= ?";

		int ind = 0;
		for (OrderProductEntity entity : products) {

			jdbcTemplate.update(sql, product.get(ind).getProduct().getId(), product.get(ind).getQuantity(),
					entity.getId());
			ind++;
		}
		order.setTotalAmount(totalAmount(createOrderDto));
		order = orderRepository.save(order);
		CreateOrderResponse createOrderResponse = objectTranslator.translate(order, CreateOrderResponse.class);
		return createOrderResponse;
	}

	private Double totalAmount(CreateOrderDto createOrderDto) {

		Double sum = 0.0;
		int ind = 0;

		List<ProductLineDto> products = createOrderDto.getOrderProduct().stream().map(OrderProductDto::getProduct)
				.collect(Collectors.toList());

		List<Long> quantity = createOrderDto.getOrderProduct().stream().map(OrderProductDto::getQuantity)
				.collect(Collectors.toList());

		ProductEntity entity;

		for (ProductLineDto product : products) {

			entity = productRepsitory.getOne(product.getId());

			if (entity.getQuantity() < quantity.get(ind))
				throw new ProductOutOfStock(entity.getName() + "  available " + entity.getQuantity());

			sum = sum + entity.getPrice() * quantity.get(ind);
			ind++;
		}
		return sum;
	}

}
