package warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import warehouse.entity.Product;
import warehouse.service.WarehouseService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private WarehouseService warehouseService;

    @GetMapping("/list")
    public String getAll(Model model){
        List<Product> products = warehouseService.getAll();
        model.addAttribute("products",products);
        return "product/list";
    }
    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable Long id){
        Optional<Product> productOptional = warehouseService.get(id);
        if(productOptional.isPresent()) {
            model.addAttribute("product", productOptional.get());
            return "product/show";
        } else {
            return "exceptions/404";
        }
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "product/create";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model,@PathVariable Long id){
        Optional<Product> productOptional = warehouseService.get(id);
        if(productOptional.isPresent()) {
            model.addAttribute("product", productOptional.get());
            return "product/edit";
        } else {
            return "exceptions/404";
        }
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product,Model model){
        product = warehouseService.save(product);
        model.addAttribute("product",product);
        return "product/show";
    }
    @PutMapping("/update")
    public String update(@ModelAttribute Product product,Model model){
        product = warehouseService.save(product);
        model.addAttribute("product",product);
        return "product/show";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        warehouseService.delete(id);
        return "redirect:/list";
    }
}
