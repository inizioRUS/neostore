package ru.bebriki.bebriki.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "workerId")
    private Integer workerId;
    @Column(name = "date")
    private LocalDateTime date;
    @OneToMany(targetEntity = OrderItem.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "orderItemId", referencedColumnName = "id")
    private List<Good> items;

    public Order(Integer workerId, LocalDateTime date, List<Good> items) {
        this.workerId = workerId;
        this.date = date;
        this.items = items;
    }


}
