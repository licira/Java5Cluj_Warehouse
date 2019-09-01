package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import warehouse.entity.Product;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public String getAll(Model model){
        List<Product> products=productService.getAll();
        model.addAttribute("products",products);
        return "list";
    }
    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable Long id){
        Product product=productService.get(id);
        model.addAttribute("product",product);
        return "product/show";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "product/create";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model,@PathVariable Long id){
        Product product=productService.get(id);
        model.addAttribute("product",product);
        return "product/show";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product,Model model){
        product=productService.save(product);
        model.addAttribute("product",product);
        return "product/show";
    }
    @PutMapping("/update")
    public String update(@ModelAttribute Product product,Model model){
        product=productService.save(product);
        model.addAttribute("product",product);
        return "product/show";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        productService.delete(id);
        return "redirect:/list";
    }
}
