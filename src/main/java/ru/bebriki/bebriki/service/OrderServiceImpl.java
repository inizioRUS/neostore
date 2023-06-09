package ru.bebriki.bebriki.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.bebriki.bebriki.Errors.AchievementNotFoundException;
import ru.bebriki.bebriki.Errors.OrderNotFoundException;
import ru.bebriki.bebriki.controller.GoodController;
import ru.bebriki.bebriki.dtos.OrderDTO;
import ru.bebriki.bebriki.dtos.WorkerDTO;
import ru.bebriki.bebriki.models.Good;
import ru.bebriki.bebriki.models.Order;
import ru.bebriki.bebriki.models.OrderItem;
import ru.bebriki.bebriki.models.Worker;
import ru.bebriki.bebriki.repositories.OrderRepository;
import ru.bebriki.bebriki.responses.GoodResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private GoodServiceImpl goodService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private WorkerServiceImpl workerService;


    @Override
    public OrderDTO getOrderById(int id) throws OrderNotFoundException {

        Optional<Order> order = orderRepository.findById(id);

        if (order.isEmpty()) {
            throw new OrderNotFoundException("There is no such order like this");
        }

        return toDTO(order.get());
    }

    @Override
    public OrderDTO toDTO(Order order) {
        Order orderDB = orderRepository.findById(order.getId()).get();
        return OrderDTO.builder()
                .id(orderDB.getId())
                .date(orderDB.getDate())
                .items(orderDB.getItems())
                .workerId(orderDB.getWorkerId())
                .build();
    }

    @Override
    public Order toOrder(OrderDTO orderDTO) {

        Worker worker = workerService.toWorker(workerService.getWorkerById(orderDTO.getWorkerId()));

        return Order.builder()
                .id(orderDTO.getId())
                .date(orderDTO.getDate())
                .items(orderDTO.getItems())
                .workerId(orderDTO.getWorkerId())
                .worker(worker)
                .build();
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderDTO> getOrderByDate(LocalDateTime dateTime) throws OrderNotFoundException {

        List<Order> orders = orderRepository.findByDate(dateTime);
        List<OrderDTO> ordersReturn = null;


        if (orders.isEmpty()) throw new OrderNotFoundException("There is no such order like this");

        for (Order o : orders) {
            ordersReturn.add(toDTO(o));
        }

        return ordersReturn;
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        orderRepository.save(toOrder(orderDTO));
        return orderDTO;
    }

    public boolean compareAmount(List<Good> list) {

        List<GoodResponse> listDb = null;
        List<GoodResponse> responseList = null;
        for (Good g : list) {
            responseList.add(GoodResponse.cast(g));
        }
        for (GoodResponse g : responseList) {
            listDb.add(goodService.findById(g.getId()));
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAmount() > listDb.get(i).getAmount()) return false;
        }
        return true;
    }

    public boolean comparePrice(int totalPrice, int id) {


        if (workerService.getWorkerById(id).getBalance() < totalPrice) return false;
        return true;
    }
    @Transactional
    public boolean placeOnOrder(List<Good> list, int id){
        int totalPrice = 0;
        List<OrderItem> orderItems = null;
        for (Good g : list) {
            totalPrice += g.getPrice() * g.getAmount();
        }
        if(compareAmount(list) && comparePrice(totalPrice, id)){
            workerService.getWorkerById(id).setBalance(workerService.getWorkerById(id).getBalance()-totalPrice);
            List<GoodResponse> listDb = null;
            List<GoodResponse> responseList = null;
            for (Good g : list) {
                responseList.add(GoodResponse.cast(g));
            }
            for(int i=0;i<responseList.size();i++){
                listDb.add(goodService.findById((responseList.get(i)).getId()));
                listDb.get(i).setAmount(listDb.get(i).getAmount()-responseList.get(i).getAmount());
            }

            for (Good good : list) {
                orderItems.add(new OrderItem(good.getAmount(), good.getPrice() * good.getAmount(), good.getId()));
            }

            createOrder(new OrderDTO((Integer)id, LocalDateTime.now(), orderItems));
            return true;

        }
        return false;
    }

}
