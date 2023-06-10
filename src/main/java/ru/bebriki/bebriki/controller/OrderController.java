package ru.bebriki.bebriki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bebriki.bebriki.Errors.OrderNotFoundException;
import ru.bebriki.bebriki.dtos.OrderDTO;
import ru.bebriki.bebriki.models.Good;
import ru.bebriki.bebriki.models.Order;
import ru.bebriki.bebriki.service.OrderService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable("id") int id) throws OrderNotFoundException {
        return orderService.getOrderById(id);
    }

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") int id) {
        orderService.deleteOrder(id);
    }

    @GetMapping("/date")
    public List<OrderDTO> getOrderByDate(@RequestParam LocalDateTime dateTime) throws OrderNotFoundException {
        return orderService.getOrderByDate(dateTime);
    }

    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @PostMapping("/pay")
    public boolean placeOnOrder(@RequestParam List<Good> list, @PathVariable int id){
        return orderService.placeOnOrder(list, id);
    }

    @GetMapping("/compareAmount")
    public boolean compareAmount(List<Good> list){
        return orderService.compareAmount(list);
    }
    @GetMapping("/comparePrice")
    public boolean comparePrice(int totalPrice, int id){
        return orderService.comparePrice(totalPrice, id);
    }

}
