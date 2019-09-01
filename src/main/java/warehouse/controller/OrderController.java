package warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import warehouse.entity.Order;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderProcessing orderProcessing;

    @GetMapping("/list")
    public String getAll(Model model){
        List<Order> orders= orderProcessing.getAll();
        model.addAttribute("orders",orders);
        return "list";
    }
    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable Long id){
        Order order= orderProcessing.get(id);
        model.addAttribute("order",order);
        return "order/show";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("order",new Order());
        return "order/create";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model,@PathVariable Long id){
        Order order= orderProcessing.get(id);
        model.addAttribute("order",order);
        return "order/show";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Order order,Model model){
        order= orderProcessing.save(order);
        model.addAttribute("order",order);
        return "order/show";
    }
    @PutMapping("/update")
    public String update(@ModelAttribute Order order,Model model){
        order= orderProcessing.save(order);
        model.addAttribute("order",order);
        return "order/show";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        orderProcessing.delete(id);
        return "redirect:/list";
    }
}
