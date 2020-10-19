package ecommerce.admin.order.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ecommerce.admin.order.OrderStatus;
import ecommerce.admin.order.dao.entity.OrderEntity;
import ecommerce.admin.order.dao.entity.OrderProductEntity;
import ecommerce.admin.order.dao.repository.OrderRepository;
import ecommerce.admin.order.dto.CreateOrderDto;
import ecommerce.admin.order.dto.CreateOrderResponse;
import ecommerce.admin.order.dto.OrderProductDto;
import ecommerce.admin.order.dto.ProductLineDto;
import ecommerce.admin.product.dao.entity.ProductEntity;
import ecommerce.admin.product.dao.repository.ProductRepository;
import ecommerce.common.ObjectTranslator;
import ecommerce.common.ProductOutOfStock;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
@Transactional
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

		String sql = "update order_products set product_id=? ,quantity =? from order_products where id= ?";

		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {

				ps.setLong(1, product.get(i).getProduct().getId());
				ps.setLong(2, product.get(i).getProductQuantity());
				ps.setLong(3, products.get(i).getId());

			}

			public int getBatchSize() {
				return products.size();
			}

		});

		order.setTotalAmount(totalAmount(createOrderDto));
		order = orderRepository.save(order);

		return null;
	}

	private Double totalAmount(CreateOrderDto createOrderDto) {

		Double sum = 0.0;
		int ind = 0;

		List<ProductLineDto> products = createOrderDto.getOrderProduct().stream().map(OrderProductDto::getProduct)
				.collect(Collectors.toList());

		List<Long> quantity = createOrderDto.getOrderProduct().stream().map(OrderProductDto::getProductQuantity)
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
