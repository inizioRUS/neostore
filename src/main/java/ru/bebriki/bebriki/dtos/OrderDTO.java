package ru.bebriki.bebriki.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bebriki.bebriki.models.Good;
import ru.bebriki.bebriki.models.OrderItem;
import ru.bebriki.bebriki.models.Worker;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Integer id;
    private Integer workerId;
    private LocalDateTime date;
    private List<OrderItem> items;

    public OrderDTO(Integer workerId, LocalDateTime date, List<OrderItem> items) {
        this.workerId = workerId;
        this.date = date;
        this.items = items;
    }

}
