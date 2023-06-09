package ru.bebriki.bebriki.service;

import ru.bebriki.bebriki.Errors.OrderNotFoundException;
import ru.bebriki.bebriki.dtos.OrderDTO;
import ru.bebriki.bebriki.models.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    OrderDTO getOrderById(int id) throws OrderNotFoundException;

    OrderDTO toDTO(Order order);

    Order toOrder(OrderDTO orderDTO);

    List<OrderDTO> getAllOrders();

    void deleteOrder(int id);

    List<OrderDTO> getOrderByDate(LocalDateTime dateTime) throws OrderNotFoundException;

    OrderDTO createOrder(OrderDTO orderDTO);
}
