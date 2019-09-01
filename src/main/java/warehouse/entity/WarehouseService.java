package warehouse.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouse.entity.Product;
import warehouse.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Optional<Product> get(Long id){
        return  productRepository.findById(id);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public  void delete(Long id){
        Optional<Product> optionalProduct= get(id);
        if (optionalProduct.isPresent()){
            productRepository.delete(optionalProduct.get());
        }

    }






}
