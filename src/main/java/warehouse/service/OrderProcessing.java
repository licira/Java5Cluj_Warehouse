package warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouse.entity.Order;
import warehouse.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderProcessing {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> getById(Long id) {
        return orderRepository.findById(id);
    }

    public Order saveOrUpdate(Order order) {

        return orderRepository.save(order);
    }

    public void deleteById(Long id){
        Optional<Order> optionalOrder = getById(id);
        if (optionalOrder.isPresent()) {
            orderRepository.delete(optionalOrder.get());
        }
    }
}
