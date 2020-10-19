package ecommerce.admin.order.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.admin.order.dao.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
