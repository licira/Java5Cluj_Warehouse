package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import warehouse.entity.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByProductId(Long id);
}
