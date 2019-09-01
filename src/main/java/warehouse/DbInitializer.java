package warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import warehouse.entity.Admin;
import warehouse.entity.Customer;
import warehouse.entity.Product;
import warehouse.entity.User;
import warehouse.repository.ProductRepository;
import warehouse.repository.UserRepository;
import warehouse.role.Role;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class DbInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        //users
        Set<Role> adminRoles = new HashSet<>(Arrays.asList(Role.ROLE_ADMIN));
        String encodedPassword = passwordEncoder.encode("password");
        User adminAndUser = new Admin("admin@yahoo.com", encodedPassword, adminRoles);
        userRepository.save(adminAndUser);

        Set<Role> customerRoles = new HashSet<>(Arrays.asList(Role.ROLE_CUSTOMER));
        encodedPassword = passwordEncoder.encode("password");
        User user = new Customer("user@yahoo.com", encodedPassword, customerRoles);
        userRepository.save(user);

        //products
        Product iPhoneX = new Product("iPhoneX", 500.0, "iPhoneX");
        productRepository.save(iPhoneX);

        Product iPhoneXs = new Product("iPhoneXs", 450.0, "iPhoneXs");
        productRepository.save(iPhoneXs);

        Product iPhoneXr = new Product("iPhoneXr", 600.0, "iPhoneXr");
        productRepository.save(iPhoneXr);

        Product samsnugGalaxyS8 = new Product("samsnugGalaxyS8", 250.0, "samsnugGalaxyS8");
        productRepository.save(samsnugGalaxyS8);

        Product samsnugGalaxyS9 = new Product("samsnugGalaxyS9", 300.0, "samsnugGalaxyS9");
        productRepository.save(samsnugGalaxyS9);

        Product samsnugGalaxyS10 = new Product("samsnugGalaxyS10", 350.0, "samsnugGalaxyS10");
        productRepository.save(samsnugGalaxyS10);
    }
}
