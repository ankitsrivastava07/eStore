package ecommerce.admin.order.dao.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import ecommerce.admin.order.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Double totalAmount;
	@Column(nullable = false)
	private String status;

	@OneToOne(cascade = CascadeType.PERSIST)
	private DeliveryAddressEntity address;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id")
	private List<OrderProductEntity> order;

	@Column(nullable = true)
	private LocalDateTime createdAt;
	@ManyToOne
	@JoinColumn(name = "created_by")
	private UserEntity user;

	@PrePersist
	public void prePersist() {
		this.createdAt = LocalDateTime.now();
		this.status = OrderStatus.PROCESSING.toString();
	}

	@PreUpdate
	public void preUpdate() {
		this.createdAt = LocalDateTime.now();
		this.status = OrderStatus.PROCESSING.toString();
	}

}
