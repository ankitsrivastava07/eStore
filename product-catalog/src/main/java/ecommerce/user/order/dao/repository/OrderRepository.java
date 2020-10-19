package ecommerce.user.order.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.user.order.dao.entity.OrderEntity;
@Repository("orderRepository2")
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
