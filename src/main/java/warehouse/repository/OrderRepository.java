package warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import warehouse.entity.Order;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByOrderId(Long id);
}
