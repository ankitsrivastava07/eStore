package ecommerce.user.order.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ecommerce.admin.product.dao.entity.ProductEntity;
import lombok.Getter;
import lombok.Setter;


@Table(name = "order_products")
@Getter
@Setter
@Entity(name="orderProduct")
public class OrderProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity product;
	@Column(nullable = false)
	private Long quantity;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderEntity order;

}
