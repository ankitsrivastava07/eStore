package ecommerce.admin.product.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ecommerce.admin.product.dao.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
